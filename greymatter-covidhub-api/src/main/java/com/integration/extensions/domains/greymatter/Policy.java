package com.integration.extensions.domains.greymatter;

import com.google.gson.annotations.SerializedName;

public final class Policy {

    @SerializedName("Policy Name")
    public String policyName;

    @SerializedName("Original Policy")
    public String originalPolicy;

    @SerializedName("Policy template")
    public String policyTemplate;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return policyName + " | " + originalPolicy;
    }

    public Policy(String policyName, String originalPolicy, String policyTemplate) {
        this.policyName = policyName;
        this.originalPolicy = originalPolicy;
        this.policyTemplate = policyTemplate;
    }

    public Policy() {
    }

}
