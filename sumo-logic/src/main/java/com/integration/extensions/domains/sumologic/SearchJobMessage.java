package com.integration.extensions.domains.sumologic;

import com.google.gson.annotations.SerializedName;

public final class SearchJobMessage {

    @SerializedName("Source Name")
    public String sourceName;

    @SerializedName("Source category")
    public String sourceCategory;

    @SerializedName("Size")
    public Double size;

    @SerializedName("Raw")
    public String raw;

    @SerializedName("Collector Id")
    public String collectorId;

    @SerializedName("Message time")
    public Long messageTime;

    @SerializedName("Source host")
    public String sourceHost;

    @SerializedName("Message count")
    public String messageCount;

    @SerializedName("Source")
    public String source;

    @SerializedName("Block Id")
    public String blockId;

    @SerializedName("Source Id")
    public String sourceId;

    @SerializedName("Collector")
    public String collector;

    @SerializedName("Receipt time")
    public Long receiptTime;

    @SerializedName("Message Id")
    public String messageId;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
