package com.integration.extensions.domains.sumologic;

import com.google.gson.annotations.SerializedName;

public final class HistogramBuckets {

    @SerializedName("Length")
    public Double length;

    @SerializedName("Start Timestamp")
    public Long startTimestamp;

    @SerializedName("Count")
    public Double count;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
