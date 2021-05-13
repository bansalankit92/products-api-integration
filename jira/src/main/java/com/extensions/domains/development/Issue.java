package com.extensions.domains.development;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Issue {
  @SerializedName("Status")
  public String status;

  @SerializedName("Comment")
  public List comment;

  @SerializedName("Description")
  public String description;

  @SerializedName("Priority")
  public String priority;

  @SerializedName("Parent Key")
  public String parentKey;

  @SerializedName("Name")
  public String name;

  @SerializedName("Assignee Name")
  public String assigneeName;

  @SerializedName("Issue Type")
  public String issueType;

  @SerializedName("Project Key")
  public String projectKey;

  @SerializedName("Reporter Name")
  public String reporterName;

  @SerializedName("Summary")
  public String summary;

  @SerializedName("Id")
  public String id;

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
