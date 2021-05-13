package com.extensions.domains.development;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Story {
  @SerializedName("Status")
  public String status;

  @SerializedName("Assignee Name")
  public String assigneeName;

  @SerializedName("Description")
  public String description;

  @SerializedName("Project Key")
  public String projectKey;

  @SerializedName("Story Type")
  public String storyType;

  @SerializedName("Comments")
  public List comments;

  @SerializedName("Reporter Name")
  public String reporterName;

  @SerializedName("Priority")
  public String priority;

  @SerializedName("Summary")
  public String summary;

  @SerializedName("Story Key")
  public String storyKey;

  @SerializedName("Id")
  public String id;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return storyKey + " | "+ summary;
  }
}
