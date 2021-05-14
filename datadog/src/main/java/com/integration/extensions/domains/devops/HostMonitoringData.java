package com.integration.extensions.domains.devops;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class HostMonitoringData {
    @SerializedName("Muted Timeout")
    public Long mutedTimeout;

    @SerializedName("Metrics")
    public Object metrics;

    @SerializedName("Is Muted")
    public Boolean isMuted;

    @SerializedName("Host Id")
    public String hostId;

    @SerializedName("Is Up")
    public Boolean isUp;

    @SerializedName("Host Name")
    public String hostName;

    @SerializedName("Last Reported At")
    public Long lastReportedAt;

    @SerializedName("Apps")
    public List apps;

    @SerializedName("Sources")
    public List sources;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }
}
