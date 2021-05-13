package com.extensions.domains.development;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Priority {
  @SerializedName("Description")
  public String description;

  @SerializedName("Id")
  public String id;

  @SerializedName("Name")
  public String name;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return name;
  }

  public Priority() {
  }

  public Priority(String name) {
    this.name = name;
  }
}
