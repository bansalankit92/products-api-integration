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
import com.krista.action.ExtensionErrorAction;
import com.krista.exception.ExtensionException;

import static com.integration.extensions.domains.devops.ec2util.EC2Util.*;

public class ECRUtil {


    public static AmazonECR getECR(Map<String, Object> connectionAttributes) throws ExtensionException {
        Object key = connectionAttributes.get(AWS_KEY);
        Object secret = connectionAttributes.get(AWS_SECRET);
        Object region = connectionAttributes.get(AWS_REGION);

        if (key == null || secret == null || region == null) {
            throw new ExtensionException(new Exception("Some of the connection attributes are empty")
                    , new ExtensionErrorAction("Some of the connection attributes are empty", true));
        }
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                String.valueOf(key), String.valueOf(secret));

        AmazonECR amazonECR = AmazonECRClientBuilder.standard().withRegion(String.valueOf(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
        return amazonECR;
    }

    public static ContainerImageRepository getRepository(AmazonECR ecr, String repositoryName) throws ExtensionException {
        return ECRUtil.getAllRepositories(ecr).stream().filter(repository -> repository.name.toLowerCase().contains(repositoryName.trim().toLowerCase())).findFirst().orElseThrow(() -> new RuntimeException("Container repository not found " + repositoryName));
    }

    public static List<ContainerImageRepository> getAllRepositories(AmazonECR ecr) throws ExtensionException {
        return ecr.describeRepositories(new DescribeRepositoriesRequest()).getRepositories().stream().map(ContainerImageRepository::from).collect(Collectors.toList());
    }

    public static String getAuthorizationToken(AmazonECR ecr) throws ExtensionException {
        GetAuthorizationTokenResult authorizationToken = ecr
                .getAuthorizationToken(new GetAuthorizationTokenRequest());
        List<AuthorizationData> authorizationData = authorizationToken.getAuthorizationData();
        String encodedToken = authorizationData.get(0).getAuthorizationToken();
        return encodedToken;
    }

    public static List<ImageIdentifier> getImagesByRepoName(AmazonECR ecr, String repoName) throws ExtensionException {
        ListImagesRequest request = new ListImagesRequest();
        request.setRepositoryName(repoName);

        ListImagesResult result = ecr.listImages(request);
        return result.getImageIds();

    }

    public static List<ImageIdentifier> getImagesByRegistry(AmazonECR ecr, String registryId) throws ExtensionException {
        ListImagesRequest request = new ListImagesRequest();
        request.setRegistryId(registryId);

        ListImagesResult result = ecr.listImages(request);
        return result.getImageIds();

    }

    public static List<ImageDetail> describeImagesByRepoName(AmazonECR ecr, String repoName) throws ExtensionException {
        DescribeImagesRequest request = new DescribeImagesRequest();
        request.setRepositoryName(repoName);
        DescribeImagesResult result = ecr.describeImages(request);
        return result.getImageDetails();
    }


    public static ImageDetail getLatestImageByRepoName(AmazonECR ecr, String repoName) throws ExtensionException {
        List<ImageDetail> imageDetails = describeImagesByRepoName(ecr, repoName);
        imageDetails.sort(Collections.reverseOrder(Comparator.comparing(ImageDetail::getImagePushedAt)));
        if (imageDetails.size() > 0)
            return imageDetails.get(0);
        throw new RuntimeException("Image details Not found");
    }


    public static List<ContainerImage> getImages(AmazonECR ecr, String repoName, int size) throws ExtensionException {
        ContainerImageRepository repository = getRepository(ecr, repoName);
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, repoName);
        return imageDetails.stream().map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).sorted(Collections.reverseOrder(Comparator.comparing(x -> x.createdAt)))
                .collect(Collectors.toList()).subList(0, Math.min(size, imageDetails.size()));
    }

    public static ContainerImage getImageByBuildNumber(AmazonECR ecr, String repoName, Long buildNumber) throws ExtensionException {
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, repoName);
        ContainerImageRepository repository = getRepository(ecr, repoName);

        List<ContainerImage> images = imageDetails.stream()
                .filter(imageDetail -> Objects.nonNull(imageDetail.getImageTags()) && imageDetail.getImageTags().size() > 0 && imageDetail.getImageTags().get(0).contains("-" + buildNumber + "-"))
                .map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).collect(Collectors.toList());
        if (images.size() > 0) return images.get(0);
        throw new RuntimeException("Image not found for this build");
    }

    public static List<ContainerImage> getImagesByBuildNumber(AmazonECR ecr, String repoName, Long buildNumber) throws ExtensionException {
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, repoName);
        ContainerImageRepository repository = getRepository(ecr, repoName);

        return imageDetails.stream()
                .filter(imageDetail -> Objects.nonNull(imageDetail.getImageTags()) && imageDetail.getImageTags().size() > 0 && imageDetail.getImageTags().get(0).contains(buildNumber + ""))
                .map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).collect(Collectors.toList());
    }

    public static ContainerImage getImageByTag(AmazonECR ecr, String name, String tag) throws ExtensionException {
        List<ImageDetail> imageDetails = ECRUtil.describeImagesByRepoName(ecr, name);
        ContainerImageRepository repository = getRepository(ecr, name);

        List<ContainerImage> images = imageDetails.stream()
                .filter(imageDetail -> Objects.nonNull(imageDetail.getImageTags()) && imageDetail.getImageTags().size() > 0 && imageDetail.getImageTags().contains(tag))
                .map(imageDetail -> ContainerImage.from(imageDetail, repository.uri)).collect(Collectors.toList());
        if (!images.isEmpty()) return images.get(0);
        throw new RuntimeException("Image not found for this build");
    }
}