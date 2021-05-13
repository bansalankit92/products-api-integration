package com.integration.extensions.domains.sonarqube;

import com.google.gson.annotations.SerializedName;

public final class Project {

    @SerializedName("Organization")
    public String organization;

    @SerializedName("Description")
    public String description;

    @SerializedName("Need Issue Sync")
    public Boolean needIssueSync;

    @SerializedName("Analysis Date")
    public Long analysisDate;

    @SerializedName("Qualifier")
    public String qualifier;

    @SerializedName("Visibility")
    public String visibility;

    @SerializedName("Key")
    public String key;

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
