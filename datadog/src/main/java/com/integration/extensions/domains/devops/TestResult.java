package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class TestResult {
    @SerializedName("Check time")
    public Long checkTime;

    @SerializedName("Result Id")
    public String resultId;

    @SerializedName("Check version")
    public String checkVersion;

    @SerializedName("Location")
    public String location;

    @SerializedName("Result")
    public Object result;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }
}
