package com.integration.extensions.domains.sumologic;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public final class HostedSources {

    @SerializedName("Multiline Processing Enabled")
    public Boolean multilineProcessingEnabled;

    @SerializedName("Automatic Date Parsing")
    public Boolean automaticDateParsing;

    @SerializedName("Time Zone")
    public String timeZone;

    @SerializedName("Filters")
    public List filters;

    @SerializedName("Category")
    public String category;

    @SerializedName("Source Type")
    public String sourceType;

    @SerializedName("Collector Id")
    public String collectorId;

    @SerializedName("Id")
    public String id;

    @SerializedName("Alive")
    public Boolean alive;

    @SerializedName("URL")
    public String uRL;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
