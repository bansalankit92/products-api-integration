package com.extensions.domains.development;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class User {
  @SerializedName("Account Id")
  public String accountId;

  @SerializedName("Email")
  public String email;

  @SerializedName("Account Type")
  public String accountType;

  @SerializedName("Name")
  public String name;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return name + " | " + email;
  }
}
