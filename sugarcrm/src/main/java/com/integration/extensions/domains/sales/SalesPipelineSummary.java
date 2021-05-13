package com.integration.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

public final class SalesPipelineSummary {

    @SerializedName("Status")
    public String status;

    @SerializedName("Average")
    public String average;

    @SerializedName("Total")
    public String total;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
