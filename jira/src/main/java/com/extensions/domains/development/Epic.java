package com.extensions.domains.development;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Epic {
  @SerializedName("Status")
  public String status;

  @SerializedName("Assignee Name")
  public String assigneeName;

  @SerializedName("Type")
  public String type;

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

  @SerializedName("Epic Key")
  public String epicKey;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return epicKey + " | "+ summary;
  }
}
