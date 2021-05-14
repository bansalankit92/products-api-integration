package com.integration.extensions.domains.devops.ec2util;

import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.ec2.model.InstanceTypeInfo;
import com.amazonaws.services.ec2.model.Reservation;
import com.integration.extensions.domains.devops.Instance;
import com.integration.extensions.domains.devops.InstanceType;

public class InstanceUtil {


    public static List<Instance> from(Reservation reservation) {
        List<Instance> instances = new ArrayList<>();

        for (com.amazonaws.services.ec2.model.Instance inst : reservation.getInstances()) {
            Instance instance = getInstance(reservation, inst);
            instances.add(instance);
        }

        return instances;

    }

    public static Instance getInstance(Reservation reservation, com.amazonaws.services.ec2.model.Instance inst) {
        Instance instance = new Instance();
        instance.ownerId = reservation.getOwnerId();
        instance.reservationId = reservation.getReservationId();
        instance.instanceId = inst.getInstanceId();
        instance.imageLaunchIndex = String.valueOf(inst.getAmiLaunchIndex());
        instance.architecture = inst.getArchitecture();
        instance.imageId = inst.getImageId();
        instance.instanceType = inst.getInstanceType();
        instance.keyName = inst.getKeyName();
        instance.launchTime = inst.getLaunchTime().getTime();
        instance.monitoring = inst.getMonitoring().getState();
        instance.availabilityZone = inst.getPlacement().getAvailabilityZone();
        instance.privateDnsName = inst.getPrivateDnsName();
        instance.privateIpAddress = inst.getPrivateIpAddress();
        instance.pubilcDnsName = inst.getPublicDnsName();
        instance.state = inst.getState().getName();
        instance.stateTransitionReason = inst.getStateTransitionReason();
        instance.subnetId = inst.getSubnetId();
        instance.vpcId = inst.getVpcId();
        instance.architecture = inst.getArchitecture();
        instance.eBSOptimised = inst.isEbsOptimized().toString();
        instance.numberOfCores = inst.getCpuOptions().getCoreCount()!=null ?inst.getCpuOptions().getCoreCount().longValue(): null;
        instance.threadsPerCore = inst.getCpuOptions().getThreadsPerCore()!=null?inst.getCpuOptions().getThreadsPerCore().longValue():null;
        instance.capacityReservationPreference = inst.getCapacityReservationSpecification().getCapacityReservationPreference();
        return instance;
    }

    public static Instance getInstance(com.amazonaws.services.ec2.model.Instance inst) {
        Instance instance = new Instance();
        instance.ownerId = EC2Util.NA;
        instance.reservationId = EC2Util.NA;
        instance.imageLaunchIndex = String.valueOf(inst.getAmiLaunchIndex());
        instance.architecture = inst.getArchitecture();
        instance.imageId = inst.getImageId();
        instance.instanceType = inst.getInstanceType();
        instance.keyName = inst.getKeyName();
        instance.launchTime = inst.getLaunchTime().getTime();
        instance.monitoring = inst.getMonitoring().getState();
        instance.availabilityZone = inst.getPlacement().getAvailabilityZone();
        instance.privateDnsName = inst.getPrivateDnsName();
        instance.privateIpAddress = inst.getPrivateIpAddress();
        instance.pubilcDnsName = inst.getPublicDnsName();
        instance.publicIpAddress = inst.getPublicIpAddress();
        instance.state = inst.getState().getName();
        instance.stateTransitionReason = inst.getStateTransitionReason();
        instance.subnetId = inst.getSubnetId();
        instance.vpcId = inst.getVpcId();
        instance.architecture = inst.getArchitecture();
        instance.eBSOptimised = inst.isEbsOptimized().toString();
        instance.numberOfCores = inst.getCpuOptions().getCoreCount()!=null ?inst.getCpuOptions().getCoreCount().longValue(): null;
        instance.threadsPerCore = inst.getCpuOptions().getThreadsPerCore()!=null?inst.getCpuOptions().getThreadsPerCore().longValue():null;
        instance.capacityReservationPreference = inst.getCapacityReservationSpecification().getCapacityReservationPreference();
        return instance;
    }

    public static InstanceType getInstanceType(InstanceTypeInfo type) {
        InstanceType instanceType = new InstanceType();
        instanceType.instanceType = type.getInstanceType();
        instanceType.currentGeneration = type.getCurrentGeneration();
        instanceType.freeTierEligible = type.getFreeTierEligible();
        instanceType.supportedUsageClasses = type.getSupportedUsageClasses();
        instanceType.supportedRootDeviceTypes = type.getSupportedRootDeviceTypes();
        instanceType.supportedVirtualizationTypes = type.getSupportedVirtualizationTypes();
        instanceType.defaultNumberOfVCpus = type.getVCpuInfo().getDefaultVCpus() != null ? type.getVCpuInfo().getDefaultVCpus().longValue() : null;
        instanceType.defaultNumberOfCores = type.getVCpuInfo().getDefaultCores() != null ? Long.valueOf(type.getVCpuInfo().getDefaultCores()) : null;
        instanceType.defaultNumberOfThreadsPerCore = type.getVCpuInfo().getDefaultThreadsPerCore() != null ? type.getVCpuInfo().getDefaultThreadsPerCore().longValue() : null;
        instanceType.rAMInMBs = type.getMemoryInfo().getSizeInMiB();
        instanceType.instanceStorageSupported = type.getInstanceStorageSupported();
        instanceType.hibernationSupported = type.getHibernationSupported();
        instanceType.autoRecoverySupported = type.getAutoRecoverySupported();
        return instanceType;
    }
}