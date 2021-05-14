package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class StorageSummary {

    @SerializedName("Repository")
    public String repository;

    @SerializedName("Total Items")
    public Long totalItems;

    @SerializedName("Total Folders")
    public Long totalFolders;

    @SerializedName("Total Space Used")
    public String totalSpaceUsed;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
