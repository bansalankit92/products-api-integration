package com.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class Opportunity {

    @SerializedName("Last Modified Date")
    public Long lastModifiedDate;

    @SerializedName("Description")
    public String description;

    @SerializedName("Owner Id")
    public String ownerId;

    @SerializedName("Close Date")
    public Long closeDate;

    @SerializedName("Created Date")
    public Long createdDate;

    @SerializedName("Amount")
    public String amount;

    @SerializedName("Probability")
    public String probability;

    @SerializedName("Stage Name")
    public String stageName;

    @SerializedName("Id")
    public String id;

    @SerializedName("Contact Id")
    public String contactId;

    @SerializedName("Account Id")
    public String accountId;

    @SerializedName("Expected Revenue")
    public String expectedRevenue;

    @SerializedName("Name")
    public String name;

    @SerializedName("Pricebook Id")
    public String Pricebook2Id;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name + " | " + stageName;
    }

}
