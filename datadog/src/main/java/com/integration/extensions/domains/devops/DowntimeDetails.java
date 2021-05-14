package com.integration.extensions.domains.devops;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class DowntimeDetails {
    @SerializedName("Timezone")
    public String timezone;

    @SerializedName("Downtime Type")
    public String downtimeType;

    @SerializedName("Recurrence")
    public Object recurrence;

    @SerializedName("Active")
    public Boolean active;

    @SerializedName("Message")
    public String message;

    @SerializedName("Scope")
    public List scope;

    @SerializedName("Start")
    public Long start;

    @SerializedName("Downtime Id")
    public String downtimeId;

    @SerializedName("End")
    public Long end;

    @SerializedName("Canceled")
    public Long canceled;

    @SerializedName("Disabled")
    public Boolean disabled;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }
}
