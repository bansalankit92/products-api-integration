package com.integration.extensions.domains.devops;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class InstanceType {

    @SerializedName("Supported Virtualization Types")
    public List supportedVirtualizationTypes;

    @SerializedName("Default Number of Threads Per Core")
    public Long defaultNumberOfThreadsPerCore;

    @SerializedName("Instance Storage Supported")
    public Boolean instanceStorageSupported;

    @SerializedName("Supported Usage Classes")
    public List supportedUsageClasses;

    @SerializedName("Default Number of Cores")
    public Long defaultNumberOfCores;

    @SerializedName("Auto Recovery Supported")
    public Boolean autoRecoverySupported;

    @SerializedName("Free Tier Eligible")
    public Boolean freeTierEligible;

    @SerializedName("Default Number of VCpus")
    public Long defaultNumberOfVCpus;

    @SerializedName("Instance Type")
    public String instanceType;

    @SerializedName("Supported Root Device Types")
    public List supportedRootDeviceTypes;

    @SerializedName("RAM in MBs")
    public Long rAMInMBs;

    @SerializedName("Current Generation")
    public Boolean currentGeneration;

    @SerializedName("Hibernation Supported")
    public Boolean hibernationSupported;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return instanceType;
    }

}
