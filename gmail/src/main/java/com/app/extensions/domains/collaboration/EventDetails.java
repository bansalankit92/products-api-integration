package com.app.extensions.domains.collaboration;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class EventDetails {
  @SerializedName("Details")
  public String details;

  @SerializedName("Date To")
  public String dateTo;

  @SerializedName("Contacts")
  public List contacts;

  @SerializedName("Title")
  public String title;

  @SerializedName("Event Id")
  public String eventId;

  @SerializedName("Date From")
  public String dateFrom;

  @SerializedName("Location")
  public String location;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return "";
  }
}
