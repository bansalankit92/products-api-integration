package com.integration.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

public final class Event {

    @SerializedName("Account Id")
    public String accountId;

    @SerializedName("Last Modified Date")
    public Long lastModifiedDate;

    @SerializedName("Owner Id")
    public String ownerId;

    @SerializedName("Is Private")
    public Boolean isPrivate;

    @SerializedName("Created Date")
    public Long createdDate;

    @SerializedName("Lead Id")
    public String leadId;

    @SerializedName("Start Date Time")
    public Long startDateTime;

    @SerializedName("End Date Time")
    public Long endDateTime;

    @SerializedName("Id")
    public String id;

    @SerializedName("Is Group Event")
    public Boolean isGroupEvent;

    @SerializedName("Subject")
    public String subject;

    @SerializedName("Location")
    public String location;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return subject;
    }

}
