package com.integration.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

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
    public Long probability;

    @SerializedName("Stage Name")
    public String stageName;

    @SerializedName("Id")
    public String id;

    @SerializedName("Contact Id")
    public String contactId;

    @SerializedName("Expected Revenue")
    public String expectedRevenue;

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
