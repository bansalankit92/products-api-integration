package com.extensions.domains.development;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Subtask {
  @SerializedName("Status")
  public String status;

  @SerializedName("Task Type")
  public String taskType;

  @SerializedName("Assignee Name")
  public String assigneeName;

  @SerializedName("Description")
  public String description;

  @SerializedName("Project Key")
  public String projectKey;

  @SerializedName("Comments")
  public List comments;

  @SerializedName("Reporter Name")
  public String reporterName;

  @SerializedName("Priority")
  public String priority;

  @SerializedName("Summary")
  public String summary;

  @SerializedName("Id")
  public String id;

  @SerializedName("Parent Key")
  public String parentKey;

  @SerializedName("Key")
  public String key;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return key + " | "+ summary;
  }
}
