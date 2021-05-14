package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class TestResults {
  @SerializedName("Skip Count")
  public long skipCount;

  @SerializedName("Build Number")
  public String buildNumber;

  @SerializedName("Duration")
  public double duration;

  @SerializedName("Fail Count")
  public long failCount;

  @SerializedName("Pass Count")
  public long passCount;

  @SerializedName("Suites")
  public Object suites;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return "";
  }
}
