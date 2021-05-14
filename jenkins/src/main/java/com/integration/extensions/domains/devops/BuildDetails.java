package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class BuildDetails {
  @SerializedName("Build Version")
  public String buildVersion;

  @SerializedName("Jenkins Version")
  public String jenkinsVersion;

  @SerializedName("Build Name")
  public String buildName;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return "";
  }
}
