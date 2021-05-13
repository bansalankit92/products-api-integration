package com.integration.extensions.domains.sumologic;

import com.google.gson.annotations.SerializedName;

public final class SearchJobRecord {

    @SerializedName("Source category")
    public String sourceCategory;

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
