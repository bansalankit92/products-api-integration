package com.integration.extensions.domains.usersupport;

import com.google.gson.annotations.SerializedName;

public final class Asset {

    @SerializedName("Display Name")
    public String displayName;

    @SerializedName("Assigned To")
    public String assignedTo;

    @SerializedName("Asset Tag")
    public String assetTag;

    @SerializedName("Model")
    public String model;

    @SerializedName("Sys Id")
    public String sysId;

    @SerializedName("Model Category")
    public String modelCategory;

    @SerializedName("Assigned To Email")
    public String assignedToEmail;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
