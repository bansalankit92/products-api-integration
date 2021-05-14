package com.app.extensions.domains.cloudstorage;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class StorageBucket {

  @SerializedName("Name")
  public String name;

  @SerializedName("Created Date")
  public Long createdDate;

  @SerializedName("Owner")
  public String owner;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return name;
  }

  public StorageBucket(String name, Long createdDate, String owner) {
    this.name = name;
    this.createdDate = createdDate;
    this.owner = owner;
  }
}
