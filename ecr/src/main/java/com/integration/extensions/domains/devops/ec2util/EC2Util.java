package com.integration.extensions.domains.devops.ec2util;

import java.util.*;
import java.util.stream.Collectors;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.*;
import com.google.gson.Gson;

public class EC2Util {

    public static final String AWS_KEY = "AWS Key";
    public static final String AWS_SECRET = "AWS Secret";
    public static final String AWS_REGION = "Aws Region";
    public static final String NA = "NA";

    public static final String INSTANCE_TYPE = "Instance Type";
    public static final String INSTANCE_ID = "Instance Id";
    public static final String KEY_NAME = "Key Name";
    public static final String DEFAULT = "default";

    private static Gson gson = new Gson();

    public static AmazonEC2 getEC2(Map<String, Object> connectionAttributes) throws Exception {
        Object key = connectionAttributes.get(AWS_KEY);
        Object secret = connectionAttributes.get(AWS_SECRET);
        Object region = connectionAttributes.get(AWS_REGION);

        AWSCredentials awsCredentials = new BasicAWSCredentials(
                String.valueOf(key), String.valueOf(secret));

        AmazonEC2 amazonECR = AmazonEC2ClientBuilder.standard().withRegion(String.valueOf(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
        return amazonECR;
    }

    public static com.integration.extensions.domains.devops.Instance createInstance(AmazonEC2 ec2, String amiId) {
        // TagSpecification tagSpecification = new TagSpecification().withResourceType()
        if (amiId == null || DEFAULT.equalsIgnoreCase(amiId.trim()) || !amiId.contains("ami-")) {
            amiId = "ami-003634241a8fcdec0";
        }
        RunInstancesRequest run_request = new RunInstancesRequest()
                .withImageId(amiId)
                .withInstanceType(com.amazonaws.services.ec2.model.InstanceType.T1Micro)
                .withMaxCount(1)
                .withMinCount(1);
        // .withKeyName("Created via Krista "+ new Date().toString());

        RunInstancesResult resp = ec2.runInstances(run_request);

        for (com.amazonaws.services.ec2.model.Instance inst : resp.getReservation().getInstances()) {
            return InstanceUtil.getInstance(resp.getReservation(), inst);
        }
        return null;
    }

    public static void startInstance(AmazonEC2 ec2, String instanceId, String additionalInfo) {
        StartInstancesRequest req = new StartInstancesRequest();
        req.setInstanceIds(Collections.singleton(instanceId));
        req.setAdditionalInfo(additionalInfo);
        ec2.startInstances(req);
    }

    public static void stopInstance(AmazonEC2 ec2, String instanceId, boolean force, boolean hibernate) {
        StopInstancesRequest request = new StopInstancesRequest();
        request.setInstanceIds(Collections.singleton(instanceId));
        request.setForce(force);
        request.setHibernate(hibernate);
        ec2.stopInstances(request);
    }

    public static void rebootInstance(AmazonEC2 ec2, String instanceId) {
        RebootInstancesRequest request = new RebootInstancesRequest();
        request.setInstanceIds(Collections.singleton(instanceId));
        ec2.rebootInstances(request);
    }

    public static void monitorInstance(AmazonEC2 ec2, String instanceId) {
        MonitorInstancesRequest request = new MonitorInstancesRequest();
        request.setInstanceIds(Collections.singleton(instanceId));
        ec2.monitorInstances(request);
    }

    public static List<com.integration.extensions.domains.devops.Instance> describeInstances(AmazonEC2 ec2) {
        String nextToken = null;
        List<com.integration.extensions.domains.devops.Instance> instances = new ArrayList<>();
        do {
            DescribeInstancesResult response = ec2.describeInstances();
            for (Reservation r : response.getReservations()) {
                instances.addAll(InstanceUtil.from(r));
            }
            nextToken = response.getNextToken();
        } while (nextToken != null);
        return instances;
    }

    public static List<String> getInstanceIds(AmazonEC2 ec2) {
        return describeInstances(ec2).stream().map(instance -> instance.instanceId).collect(Collectors.toList());
    }

    public static com.integration.extensions.domains.devops.Instance getInstanceById(AmazonEC2 ec2, String instanceId) {
        return describeInstances(ec2).stream()
                .filter(instance -> instance.instanceId.toLowerCase().contains(instanceId.toLowerCase())).findFirst()
                .orElse(null);
    }

    public static List<com.integration.extensions.domains.devops.Instance> getInstancesById(AmazonEC2 ec2,
            String instanceId) {
        return describeInstances(ec2).stream()
                .filter(instance -> instance.instanceId.toLowerCase().contains(instanceId.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<com.integration.extensions.domains.devops.Instance> getInstancesByName(AmazonEC2 ec2,
            String name) {
        return describeInstances(ec2).stream()
                .filter(instance -> instance.keyName.toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static com.integration.extensions.domains.devops.Instance getInstanceByName(AmazonEC2 ec2, String name) {
        return getInstancesByName(ec2, name).stream().findFirst().orElse(null);
    }

    public static void changeInstanceType(AmazonEC2 ec2, String instanceId, String instanceType) {
        ModifyInstanceAttributeRequest req = new ModifyInstanceAttributeRequest()
                .withInstanceId(instanceId)
                .withInstanceType(instanceType);
        ec2.modifyInstanceAttribute(req);
    }

    public static List<com.integration.extensions.domains.devops.InstanceType> getInstanceTypes(AmazonEC2 ec2,
            List<String> instanceType, long size) {
        String nextToken = null;
        List<com.integration.extensions.domains.devops.InstanceType> instances = new ArrayList<>();

        do {
            DescribeInstanceTypesRequest request = new DescribeInstanceTypesRequest()
                    .withInstanceTypes(instanceType)
                    .withNextToken(nextToken);
            if (instanceType == null || instanceType.size() == 0) {
                request.withMaxResults(Math.toIntExact(size));
            }
            DescribeInstanceTypesResult response = ec2.describeInstanceTypes(request);
            for (InstanceTypeInfo info : response.getInstanceTypes()) {
                instances.add(InstanceUtil.getInstanceType(info));
            }
            nextToken = response.getNextToken();
        } while (nextToken != null);

        return instances;
    }

    public static List<String> getInstanceTypesByName(String name) {
        return getInstanceTypes().stream().filter(instanceType -> instanceType.toLowerCase().contains(name))
                .collect(Collectors.toList());
    }

    public static List<String> getInstanceTypes() {
        return Arrays.stream(com.amazonaws.services.ec2.model.InstanceType.values())
                .map(com.amazonaws.services.ec2.model.InstanceType::toString).collect(Collectors.toList());
    }

    public static com.integration.extensions.domains.devops.InstanceType getInstanceTypes(AmazonEC2 ec2, String name) {
        List<String> types = getInstanceTypesByName(name);
        return getInstanceTypes(ec2, types, 5).stream().findFirst().orElse(null);
    }

}