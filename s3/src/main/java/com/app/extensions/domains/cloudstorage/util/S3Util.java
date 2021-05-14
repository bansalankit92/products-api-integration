package com.app.extensions.domains.cloudstorage.util;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.app.extensions.domains.cloudstorage.FileDetails;
import com.app.extensions.domains.cloudstorage.StorageBucket;
import com.google.gson.Gson;

public class S3Util {

    public static final String AWS_KEY = "AWS Key";
    public static final String AWS_SECRET = "AWS Secret";
    public static final String AWS_REGION = "Aws Region";
    public static final String MEDIA_URL = "mediaUrl";

    public static final String NA = "NA";

    private static Gson gson = new Gson();

    public static AmazonS3 getS3(Map<String, Object> connectionAttributes) throws Exception {
        Object key = connectionAttributes.get(AWS_KEY);
        Object secret = connectionAttributes.get(AWS_SECRET);
        Object region = connectionAttributes.get(AWS_REGION);

        AWSCredentials awsCredentials = new BasicAWSCredentials(
                String.valueOf(key), String.valueOf(secret));

        return AmazonS3ClientBuilder.standard().withRegion(String.valueOf(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }

    public static void uploadFile(AmazonS3 s3Client, MediaClient mediaClient, String bucketName,
            com.app.extensions.domains.cloudstorage.File file)
            throws IOException {
        // Upload a file as a new object with ContentType and title specified.
        File downloadedfile = parse(mediaClient, file);
        String ct = Files.probeContentType(downloadedfile.toPath());
        PutObjectRequest request = new PutObjectRequest(bucketName, file.fileName, downloadedfile);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(ct);

        request.setMetadata(metadata);
        s3Client.putObject(request);
    }

    public static List<com.app.extensions.domains.cloudstorage.File> downloadFile(AmazonS3 s3, MediaClient mediaClient,
            String bucketName, String fileName) throws IOException {
        S3Object obj = s3.getObject(bucketName, fileName);
        String filePath = MediaClient.TEMP_DIR + fileName;
        File fileObj = new File(filePath);
        try (InputStream reader = new BufferedInputStream(obj.getObjectContent());
             OutputStream writer = new BufferedOutputStream(new FileOutputStream(fileObj))) {
            int read = -1;
            while ((read = reader.read()) != -1) {
                writer.write(read);
            }
            writer.flush();
            String mediaId = MediaClient.nextMediaId(fileName);
            File nfileObj = new File(filePath);
            mediaClient.upload(createMediaUrl(mediaId), nfileObj);

            com.app.extensions.domains.cloudstorage.File file = new com.app.extensions.domains.cloudstorage.File();
            file.length = nfileObj.length();
            file.fileName = nfileObj.getName();
            file.extension = getFileExtension(nfileObj);
            file.mediaId = mediaId;
            return List.of(file);
        } finally {
            if (fileObj != null) {
                fileObj.delete();
            }
        }
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }

    private static File parse(MediaClient mediaClient, com.app.extensions.domains.cloudstorage.File file) throws
            IOException {
        return mediaClient.download(createMediaUrl(file.mediaId), file.mediaId);
    }

    public static List<StorageBucket> getBuckets(AmazonS3 s3) {
        List<Bucket> buckets = s3.listBuckets();
        List<StorageBucket> bucketNames = new ArrayList<>();
        for (Bucket b : buckets) {
            bucketNames
                    .add(new StorageBucket(b.getName(), b.getCreationDate().getTime(), b.getOwner().getDisplayName()));
        }
        return bucketNames;
    }

    public static List<FileDetails> getFiles(AmazonS3 s3, String bucketName) {
        ListObjectsV2Result result;
        result = s3.listObjectsV2(bucketName);
        List<FileDetails> fileDetails = new ArrayList();
        for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
            fileDetails.add(new FileDetails(objectSummary));
        }
        return fileDetails;
    }

    public static List<FileDetails> getFiles(AmazonS3 s3, String bucketName, String prefix) {
        ListObjectsV2Result result;
        result = s3.listObjectsV2(bucketName, prefix);
        List<FileDetails> fileDetails = new ArrayList();
        for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
            fileDetails.add(new FileDetails(objectSummary));
        }
        return fileDetails;
    }

    public static void deleteBucket(AmazonS3 s3, String bucketName) {
        s3.deleteBucket(bucketName);
    }

    public static void deleteBucket(AmazonS3 s3, String bucketName, String fileName) {
        s3.deleteObject(bucketName, fileName);
    }

    private static String createMediaUrl(String mediaId) {
        return "/media/public/" + mediaId;
    }

}