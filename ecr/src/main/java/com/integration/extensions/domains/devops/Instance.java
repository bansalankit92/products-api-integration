package com.integration.extensions.domains.devops;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class Instance {

    @SerializedName("Image Launch Index")
    public String imageLaunchIndex;

    @SerializedName("Key Name")
    public String keyName;

    @SerializedName("Architecture")
    public String architecture;

    @SerializedName("State Transition Reason")
    public String stateTransitionReason;

    @SerializedName("Private Ip Address")
    public String privateIpAddress;

    @SerializedName("Vpc Id")
    public String vpcId;

    @SerializedName("Subnet Id")
    public String subnetId;

    @SerializedName("Reservation Id")
    public String reservationId;

    @SerializedName("EBS Optimised")
    public String eBSOptimised;

    @SerializedName("Owner Id")
    public String ownerId;

    @SerializedName("Capacity Reservation Preference")
    public String capacityReservationPreference;

    @SerializedName("Launch Time")
    public Long launchTime;

    @SerializedName("State")
    public String state;

    @SerializedName("Instance Type")
    public String instanceType;

    @SerializedName("Instance Id")
    public String instanceId;

    @SerializedName("Pubilc Dns Name")
    public String pubilcDnsName;

    @SerializedName("Image Id")
    public String imageId;

    @SerializedName("Public Ip Address")
    public String publicIpAddress;

    @SerializedName("Threads Per Core")
    public Long threadsPerCore;

    @SerializedName("Private Dns Name")
    public String privateDnsName;

    @SerializedName("Monitoring")
    public String monitoring;

    @SerializedName("Availability Zone")
    public String availabilityZone;

    @SerializedName("Number of Cores")
    public Long numberOfCores;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return keyName + " | " + instanceType;
    }

}
