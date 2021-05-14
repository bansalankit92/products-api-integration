package com.app.extensions.domains.cloudstorage;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class FileDetails {
    @SerializedName("Last Modified")
    public Long lastModified;

    @SerializedName("Owner")
    public String owner;

    @SerializedName("Bucket Name")
    public String bucketName;

    @SerializedName("Tag")
    public String tag;

    @SerializedName("Size")
    public Long size;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name + " | " + size;
    }

    public FileDetails(S3ObjectSummary o) {
        this.lastModified = o.getLastModified().getTime();
        this.owner = o.getOwner() != null ? o.getOwner().getDisplayName() : "NA";
        this.bucketName = o.getBucketName();
        this.tag = o.getETag();
        this.size = o.getSize();
        this.name = o.getKey();

    }
}
