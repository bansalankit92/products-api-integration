package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;
import com.krista.extensions.Entity;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class ApplicationHealthData {
    @SerializedName("Summary")
    public Object summary;

    @SerializedName("Language")
    public String language;

    @SerializedName("Health Status")
    public String healthStatus;

    @SerializedName("Application Id")
    public String applicationId;

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
