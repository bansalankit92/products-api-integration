package com.integration.extensions.domains.devops;

import com.amazonaws.services.ecr.model.ImageDetail;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class ContainerImage {

    public static ContainerImage from(ImageDetail imageDetail, String repoUri) {
        String tag =
                imageDetail.getImageTags() != null && imageDetail.getImageTags().size() > 0 ? imageDetail.getImageTags()
                        .get(0) : "";
        return new ContainerImage(
                imageDetail.getImagePushedAt().getTime(),
                imageDetail.getImageScanStatus().getDescription(),
                imageDetail.getRegistryId(),
                imageDetail.getImageSizeInBytes(),
                imageDetail.getRepositoryName(),
                imageDetail.getImageScanStatus().getStatus(),
                imageDetail.getImageDigest(),
                tag,
                repoUri + ":" + tag
        );
    }
    @SerializedName("Status")
    public String status;
    @SerializedName("Description")
    public String description;
    @SerializedName("Registry Id")
    public String registryId;
    @SerializedName("Digest")
    public String digest;
    @SerializedName("Size")
    public String size;
    @SerializedName("Repository Name")
    public String repositoryName;
    @SerializedName("Tag")
    public String tag;
    @SerializedName("Uri")
    public String uri;
    @SerializedName("Created At")
    public Long createdAt;

    public ContainerImage() {
    }

    public ContainerImage(Long imagePushedAt, String imageDescription, String registryId, Long imageSize,
            String repositoryName, String imageStatus, String imageDigest, String imageTag, String imageUri) {
        this.createdAt = imagePushedAt;
        this.description = imageDescription;
        this.registryId = registryId;
        this.size = String.valueOf(imageSize);
        this.repositoryName = repositoryName;
        this.status = imageStatus;
        this.digest = imageDigest;
        this.tag = imageTag;
        this.uri = imageUri;
    }

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return uri;
    }

}
