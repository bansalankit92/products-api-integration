package com.integration.extensions.domains.devops;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class DeploymentWorkload {

    @SerializedName("Workload Id")
    public String workloadId;

    @SerializedName("Deployment Project Id")
    public String deploymentProjectId;

    @SerializedName("Actions")
    public List actions;

    @SerializedName("State")
    public String state;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
