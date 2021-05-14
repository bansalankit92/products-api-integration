package com.app.extensions.domains.messaging;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Message {
  @SerializedName("Status")
  public String status;

  @SerializedName("From")
  public String from;

  @SerializedName("To")
  public String to;

  @SerializedName("Id")
  public String id;

  @SerializedName("Date Sent")
  public Long dateSent;

  @SerializedName("Body")
  public String body;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return body;
  }
}
