package com.hubspot;

import com.google.gson.annotations.SerializedName;

public final class Deal {

    @SerializedName("Contact Email")
    public String contactEmail;

    @SerializedName("Stage")
    public String stage;

    @SerializedName("Id")
    public String id;

    @SerializedName("Amount")
    public Double amount;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
