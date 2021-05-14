package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class ContainerImageRepository {

    public static ContainerImageRepository from(com.amazonaws.services.ecr.model.Repository awsRepo) {
        return new ContainerImageRepository(awsRepo.getRepositoryArn(),
                awsRepo.getRegistryId(),
                awsRepo.getRepositoryName(),
                awsRepo.getRepositoryUri(),
                awsRepo.getCreatedAt().getTime(),
                awsRepo.getImageTagMutability());
    }
    @SerializedName("Arn")
    public String arn;
    @SerializedName("Registry Id")
    public String registryId;
    @SerializedName("Uri")
    public String uri;
    @SerializedName("Tag Mutability")
    public String tagMutability;
    @SerializedName("Created At")
    public Long createdAt;
    @SerializedName("Name")
    public String name;

    public ContainerImageRepository(String repositoryArn, String registryId, String repositoryName,
            String repositoryUri, Long createdAt, String imageTagMutability) {
        this.arn = repositoryArn;
        this.registryId = registryId;
        this.name = repositoryName;
        this.uri = repositoryUri;
        this.createdAt = createdAt;
        this.tagMutability = imageTagMutability;
    }

    public ContainerImageRepository() {
    }

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
