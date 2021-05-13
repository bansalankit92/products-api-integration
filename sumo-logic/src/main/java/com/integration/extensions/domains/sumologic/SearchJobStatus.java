package com.integration.extensions.domains.sumologic;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public final class SearchJobStatus {

    @SerializedName("Pending Warnings")
    public List pendingWarnings;

    @SerializedName("Pending Errors")
    public List pendingErrors;

    @SerializedName("Histogram Buckets")
    public List histogramBuckets;

    @SerializedName("Record")
    public Double record;

    @SerializedName("Message Count")
    public Double messageCount;

    @SerializedName("State")
    public String state;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return state;
    }

}
