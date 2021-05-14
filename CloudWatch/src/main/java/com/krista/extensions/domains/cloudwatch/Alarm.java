package com.krista.extensions.domains.cloudwatch;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Alarm {
  @SerializedName("Configuration Updated Timestamp")
  public String configurationUpdatedTimestamp;

  @SerializedName("Comparison Operator")
  public String comparisonOperator;

  @SerializedName("Description")
  public String description;

  @SerializedName("Actions Enabled")
  public Boolean actionsEnabled;

  @SerializedName("Statsistics")
  public String statsistics;

  @SerializedName("Period")
  public String period;

  @SerializedName("Dimensions")
  public Object dimensions;

  @SerializedName("Metric Name")
  public String metricName;

  @SerializedName("State Reason")
  public String stateReason;

  @SerializedName("Unit")
  public String unit;

  @SerializedName("Evaluation Period")
  public String evaluationPeriod;

  @SerializedName("Namespace")
  public String namespace;

  @SerializedName("Name")
  public String name;

  @SerializedName("State Updated Timestamp")
  public String stateUpdatedTimestamp;

  @SerializedName("ARN")
  public String aRN;

  @SerializedName("State Value")
  public String stateValue;

  @SerializedName("Threshold")
  public String threshold;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return "";
  }
}
