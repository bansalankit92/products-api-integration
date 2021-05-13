package com.extensions.domains.development;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class TransitionStatus {
    @SerializedName("From Name")
    public String fromName;

    @SerializedName("To Category Name")
    public String toCategoryName;

    @SerializedName("To Id")
    public String toId;

    @SerializedName("From Id")
    public String fromId;

    @SerializedName("To Name")
    public String toName;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "From " + fromName + " To " + toName;
    }
}
