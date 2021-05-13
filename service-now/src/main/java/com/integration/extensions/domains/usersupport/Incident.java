package com.integration.extensions.domains.usersupport;

import com.google.gson.annotations.SerializedName;

public final class Incident {

    @SerializedName("Assigned To Id")
    public String assignedToId;

    @SerializedName("Impact")
    public String impact;

    @SerializedName("Assigned To")
    public String assignedTo;

    @SerializedName("Description")
    public String description;

    @SerializedName("Number")
    public String number;

    @SerializedName("Caller")
    public String caller;

    @SerializedName("State")
    public String state;

    @SerializedName("Short Description")
    public String shortDescription;

    @SerializedName("Problem")
    public String problem;

    @SerializedName("Caller Id")
    public String callerId;

    @SerializedName("Urgency")
    public String urgency;

    @SerializedName("Sys Id")
    public String sysId;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
