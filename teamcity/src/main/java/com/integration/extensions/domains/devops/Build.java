package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Build {

    @SerializedName("Status")
    public String status;

    @SerializedName("Build Number")
    public String buildNumber;

    @SerializedName("Deployment Project Name")
    public String deploymentProjectName;

    @SerializedName("State")
    public String state;

    @SerializedName("Build Id")
    public String buildId;

    @SerializedName("Build Type Id")
    public String buildTypeId;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return deploymentProjectName + " | " + buildNumber;
    }

}
