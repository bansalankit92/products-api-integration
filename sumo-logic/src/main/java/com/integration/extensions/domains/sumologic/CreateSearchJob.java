package com.integration.extensions.domains.sumologic;

import com.google.gson.annotations.SerializedName;

public final class CreateSearchJob {

    @SerializedName("Id")
    public String id;

    @SerializedName("From")
    public Long from;

    @SerializedName("To")
    public Long to;

    @SerializedName("Query")
    public String query;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
