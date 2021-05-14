package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class DeploymentCluster {

    @SerializedName("Cluster Id")
    public String clusterId;

    @SerializedName("Description")
    public String description;

    @SerializedName("State")
    public String state;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

    public Pair<String, String> pair() {
        return new Pair<>(clusterId, toString());
    }

}
