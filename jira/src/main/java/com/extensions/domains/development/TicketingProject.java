package com.extensions.domains.development;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class TicketingProject {
  @SerializedName("Lead Account Id")
  public String leadAccountId;

  @SerializedName("Type")
  public String type;

  @SerializedName("Project Id")
  public String projectId;

  @SerializedName("Style")
  public String style;

  @SerializedName("Assignee Type")
  public String assigneeType;

  @SerializedName("Key")
  public String key;

  @SerializedName("Name")
  public String name;

  @SerializedName("Lead Name")
  public String leadName;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return key + " | "+ name;
  }
}
