package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

public final class Package {

    @SerializedName("Package Type")
    public String packageType;

    @SerializedName("Summary")
    public String summary;

    @SerializedName("Description")
    public String description;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
