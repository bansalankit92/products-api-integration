package com.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;
import java.lang.Double;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class Contract {
  @SerializedName("Status")
  public String status;

  @SerializedName("Account Id")
  public String accountId;

  @SerializedName("Description")
  public String description;

  @SerializedName("Contract Number")
  public String contractNumber;

  @SerializedName("Created Date")
  public Long createdDate;

  @SerializedName("Activated Date")
  public Long activatedDate;

  @SerializedName("Pricebook Id")
  public String pricebookId;

  @SerializedName("Owner Expiration Notice")
  public String ownerExpirationNotice;

  @SerializedName("Account Name")
  public String accountName;

  @SerializedName("Customer Signed Date")
  public String customerSignedDate;

  @SerializedName("Start Date")
  public Long startDate;

  @SerializedName("Owner Id")
  public String ownerId;

  @SerializedName("Company Signed Date")
  public Long companySignedDate;

  @SerializedName("Contract Term")
  public Double contractTerm;

  @SerializedName("End Date")
  public Long endDate;

  @SerializedName("Owner Name")
  public String ownerName;

  @SerializedName("Id")
  public String id;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return "";
  }
}
