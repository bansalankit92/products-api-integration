package com.integration.extensions.domains.sumologic;

import com.google.gson.annotations.SerializedName;

public final class Collectors {

    @SerializedName("Last Seen Alive")
    public Long lastSeenAlive;

    @SerializedName("Time Zone")
    public String timeZone;

    @SerializedName("Description")
    public String description;

    @SerializedName("Category")
    public String category;

    @SerializedName("Collector Type")
    public String collectorType;

    @SerializedName("Id")
    public String id;

    @SerializedName("Alive")
    public Boolean alive;

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
