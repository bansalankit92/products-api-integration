package com.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class Lead {

    @SerializedName("Status")
    public String status;

    @SerializedName("Last Modified Date")
    public Long lastModifiedDate;

    @SerializedName("Company")
    public String company;

    @SerializedName("Converted Contact Id")
    public String convertedContactId;

    @SerializedName("Email")
    public String email;

    @SerializedName("Description")
    public String description;

    @SerializedName("Created Date")
    public Long createdDate;

    @SerializedName("Rating")
    public String rating;

    @SerializedName("Title")
    public String title;

    @SerializedName("Website")
    public String website;

    @SerializedName("Annual Revenue")
    public String annualRevenue;

    @SerializedName("Converted Opportunity Id")
    public String convertedOpportunityId;

    @SerializedName("MobilePhone")
    public String mobilePhone;

    @SerializedName("Name")
    public String name;

    @SerializedName("Converted Date")
    public Long convertedDate;

    @SerializedName("Converted Account Id")
    public String convertedAccountId;

    @SerializedName("Industry")
    public String industry;

    @SerializedName("Is Converted")
    public Boolean isConverted;

    @SerializedName("Owner Id")
    public String ownerId;

    @SerializedName("LeadSource")
    public String leadSource;

    @SerializedName("Clean Status")
    public String cleanStatus;

    @SerializedName("Phone")
    public String phone;

    @SerializedName("Id")
    public String id;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
