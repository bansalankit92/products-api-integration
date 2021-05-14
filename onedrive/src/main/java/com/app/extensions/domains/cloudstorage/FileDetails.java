package com.app.extensions.domains.cloudstorage;

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
  public long size;

  @SerializedName("Name")
  public String name;

  @SerializedName("Id")
  public String id;

  @SerializedName("Is Folder")
    public boolean isFolder;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return name;
  }
}
