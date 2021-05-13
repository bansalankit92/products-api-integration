package com.extensions.domains.development;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class TicketStatus {
  @SerializedName("Description")
  public String description;

  @SerializedName("Id")
  public String id;

  @SerializedName("Name")
  public String name;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return name;
  }
}
