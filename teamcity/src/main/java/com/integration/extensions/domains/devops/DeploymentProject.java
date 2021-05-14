package com.integration.extensions.domains.devops;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class DeploymentProject {

    @SerializedName("Deployment Cluster Id")
    public String deploymentClusterId;

    @SerializedName("Description")
    public String description;

    @SerializedName("Deployment Project Id")
    public String deploymentProjectId;

    @SerializedName("State")
    public String state;

    @SerializedName("Build Types")
    public List buildTypes;

    @SerializedName("Name")
    public String name;

    @SerializedName("Deployment Cluster Name")
    public String deploymentClusterName;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
