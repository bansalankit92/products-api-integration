package com.integration.extensions.domains.devops.ecrutil;

import java.util.*;
import java.util.stream.Collectors;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ecr.AmazonECR;
import com.amazonaws.services.ecr.AmazonECRClientBuilder;
import com.amazonaws.services.ecr.model.*;
import com.integration.extensions.domains.devops.ContainerImage;
import com.integration.extensions.domains.devops.ContainerImageRepository;
import com.integration.extensions.domains.devops.ec2util.EC2Util;

public class ECRUtil {

    public static AmazonECR getECR(Map<String, Object> connectionAttributes) throws Exception {
        Object key = connectionAttributes.get(EC2Util.AWS_KEY);
        Object secret = connectionAttributes.get(EC2Util.AWS_SECRET);
        Object region = connectionAttributes.get(EC2Util.AWS_REGION);

        AWSCredentials awsCredentials = new BasicAWSCredentials(
                String.valueOf(key), String.valueOf(secret));

        AmazonECR amazonECR = AmazonECRClientBuilder.standard().withRegion(String.valueOf(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
        return amazonECR;
    }

    public static ContainerImageRepository getRepository(AmazonECR ecr, String repositoryName)
            throws Exception {
        return ECRUtil.getAllRepositories(ecr).stream()
                .filter(repository -> repository.name.toLowerCase().contains(repositoryName.trim().toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Container repository not found " + repositoryName));
    }

    public static List<ContainerImageRepository> getAllRepositories(AmazonECR ecr) throws Exception {
        String nextToken = null;
        List<ContainerImageRepository> imageDetails = new ArrayList<>();
        do {
            DescribeRepositoriesRequest request = new DescribeRepositoriesRequest();
            request.setNextToken(nextToken);
            DescribeRepositoriesResult result = ecr.describeRepositories(request);
            for (Repository id : result.getRepositories()) {
                imageDetails.add(ContainerImageRepository.from(id));
            }
            nextToken = result.getNextToken();
        } while (nextToken != null);
        return imageDetails;
    }

    public static String getAuthorizationToken(AmazonECR ecr) throws Exception {
        GetAuthorizationTokenResult authorizationToken = ecr
                .getAuthorizationToken(new GetAuthorizationTokenRequest());
        List<AuthorizationData> authorizationData = authorizationToken.getAuthorizationData();
        String encodedToken = authorizationData.get(0).getAuthorizationToken();
        return encodedToken;
    }

    public static List<ImageDetail> describeImagesByRepoName(AmazonECR ecr, String repoName, Long size)
            throws Exception {
        String nextToken = null;
        TreeSet<ImageDetail> imageDetails = new TreeSet<>(Comparator.comparing(ImageDetail::getImagePushedAt));
        do {
            DescribeImagesRequest request = new DescribeImagesRequest();
            request.setRepositoryName(repoName);
            request.setNextToken(nextToken);
            DescribeImagesResult result = ecr.describeImages(request);
            for (ImageDetail id : result.getImageDetails()) {
                if (imageDetails.size() >= size) {
                    imageDetails.pollFirst();
                }
                imageDetails.add(id);
            }
            nextToken = result.getNextToken();
        } while (nextToken != null);
        return new ArrayList<>(imageDetails);

    }

    public static List<ImageDetail> describeImagesByRepoNameAndTag(AmazonECR ecr, String repoName, Long size,
            String tag) throws Exception {
        String nextToken = null;
        TreeSet<ImageDetail> imageDetails = new TreeSet<>(Comparator.comparing(ImageDetail::getImagePushedAt));
        do {
            DescribeImagesRequest request = new DescribeImagesRequest();
            request.setRepositoryName(repoName);
            request.setNextToken(nextToken);
            DescribeImagesResult result = ecr.describeImages(request);
            for (ImageDetail id : result.getImageDetails()) {
                if (imageDetails.size() >= size) {
                    imageDetails.pollFirst();
                }
                if (id.getImageTags().stream().anyMatch(s -> s.contains(tag))) {
                    imageDetails.add(id);
                }
            }
            nextToken = result.getNextToken();
        } while (nextToken != null);
        return new ArrayList<>(imageDetails);

    }

    public static ImageDetail getLatestImageByRepoNameTag(AmazonECR ecr, String repoName, String tag)
            throws Exception {
        List<ImageDetail> imageDetails = describeImagesByRepoNameAndTag(ecr, repoName, 10L, tag);
        imageDetails.sort(Collections.reverseOrder(Comparator.comparing(ImageDetail::getImagePushedAt)));
        if (imageDetails.size() > 0) {
            return imageDetails.get(0);
        }
        throw new RuntimeException("Image details Not found");
    }

    public static ImageDetail getLatestImageByRepoName(AmazonECR ecr, String repoName) throws Exception {
        List<ImageDetail> imageDetails = describeImagesByRepoName(ecr, repoName, 10L);
        imageDetails.sort(Collections.reverseOrder(Comparator.comparing(ImageDetail::getImagePushedAt)));
        if (imageDetails.size() > 0) {
            return imageDetails.get(0);
        }
        throw new RuntimeException("Image details Not found");
    }

    public static List<ContainerImage> getImages(AmazonECR ecr, String repoName, Long size) throws Exception {
        ContainerImageRepository repository = getRepository(ecr, repoName);
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, repoName, size);
        return imageDetails.stream().map(imageDetail -> ContainerImage.from(imageDetail, repository.uri))
                .sorted(Collections.reverseOrder(Comparator.comparing(x -> x.createdAt)))
                .collect(Collectors.toList());
    }

    public static ContainerImage getImageByBuildNumber(AmazonECR ecr, String repoName, Long buildNumber)
            throws Exception {
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, repoName, 100L);
        ContainerImageRepository repository = getRepository(ecr, repoName);

        List<ContainerImage> images = imageDetails.stream()
                .filter(imageDetail -> Objects.nonNull(imageDetail.getImageTags()) &&
                        imageDetail.getImageTags().size() > 0 &&
                        imageDetail.getImageTags().get(0).contains("-" + buildNumber + "-"))
                .map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).collect(Collectors.toList());
        if (images.size() > 0) {
            return images.get(0);
        }
        throw new RuntimeException("Image not found for this build");
    }

    public static List<ContainerImage> getImagesByBuildNumber(AmazonECR ecr, String repoName, Long buildNumber)
            throws Exception {
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, repoName, 100L);
        ContainerImageRepository repository = getRepository(ecr, repoName);

        return imageDetails.stream()
                .filter(imageDetail -> Objects.nonNull(imageDetail.getImageTags()) &&
                        imageDetail.getImageTags().size() > 0 &&
                        imageDetail.getImageTags().get(0).contains(buildNumber + ""))
                .map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).collect(Collectors.toList());
    }

    public static ContainerImage getImageByTag(AmazonECR ecr, String name, String tag) throws Exception {
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, name, 50L);
        ContainerImageRepository repository = getRepository(ecr, name);

        List<ContainerImage> images = imageDetails.stream()
                .filter(imageDetail -> Objects.nonNull(imageDetail.getImageTags()) &&
                        imageDetail.getImageTags().size() > 0 && imageDetail.getImageTags().contains(tag))
                .map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).collect(Collectors.toList());
        if (!images.isEmpty()) {
            return images.get(0);
        }
        throw new RuntimeException("Image not found for this build");
    }

    public static List<ContainerImage> getImagesByTag(AmazonECR ecr, String name, String tag)
            throws Exception {
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, name, 50L);
        ContainerImageRepository repository = getRepository(ecr, name);

        return imageDetails.stream()
                .filter(imageDetail -> Objects.nonNull(imageDetail.getImageTags()) &&
                        imageDetail.getImageTags().size() > 0 && imageDetail.getImageTags().contains(tag))
                .map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).collect(Collectors.toList());
    }

}