package com.krista.extensions.domains.cloudwatch.runner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.model.ComparisonOperator;
import com.amazonaws.services.cloudwatch.model.StandardUnit;
import com.amazonaws.services.cloudwatch.model.Statistic;
import com.google.gson.Gson;
import com.krista.extensions.domains.cloudwatch.util.CloudWatchUtil;

import static com.krista.extensions.domains.cloudwatch.util.CloudWatchUtil.*;

public class CloudWatchRunner {

    public static void main(String[] args) {
        String clientId = "AKIATE2C4D6UG5TLBSMH";
        String clientSecret = "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";
        Map<String, Object> conAttr = new HashMap<>();
        conAttr.put(AWS_KEY, clientId);
        conAttr.put(AWS_SECRET, clientSecret);
        conAttr.put(AWS_REGION, "us-west-2");
        Gson gson = new Gson();

        try {
            AmazonCloudWatch cloudWatch = getCloudWatch(conAttr);
            //Set<String> namespaces = listNamespaces(cloudWatch);
            //Map<String, Set<String>> map = Map.of("namespaces", namespaces);
            //String json = gson.toJson(map);
            //System.out.println(json);
            //List<String> metrics = listMetricsWithNameSpace(cloudWatch, "AWS/EC2");
            //System.out.println(metrics);
            //
            //List<String> cpuUtilization = listMetricsWithMetricName(cloudWatch, "CPUUtilization", "AWS/EC2");
            //System.out.println(cpuUtilization);
            //
            //listMetricsWithDimension(cloudWatch, "CPUUtilization", "AWS/EC2",
            //        Map.of("InstanceId", " i-0c37f68b019bc58fd"));

            CloudWatchUtil.putMetricAlarm(cloudWatch, "CPUCreditBalance alarm", "CPUCreditBalance", "AWS/EC2",
                    "InstanceId", " i-0c37f68b019bc58fd", false,
                    "Alarm when server CPU utilization exceeds 70%",
                    ComparisonOperator.LessThanOrEqualToThreshold.toString(), Statistic.Average.toString(), 60L, 70L,
                    StandardUnit.Seconds.toString());

            CloudWatchUtil
                    .putMetricAlarm(cloudWatch, "CPUSurplusCreditBalance alarm", "CPUSurplusCreditBalance", "AWS/EC2",
                            "InstanceId", " i-0c37f68b019bc58fd", false,
                            "Alarm when server CPU utilization exceeds 70%",
                            ComparisonOperator.GreaterThanOrEqualToThreshold.toString(), Statistic.Average.toString(),
                            60L, 70L,
                            StandardUnit.Seconds.toString());
            //
            //List<String> alarms = getAlarms(cloudWatch);
            //System.out.println(alarms);
            //
            //getAlarm(cloudWatch, "CPU utilization alarn");

            //System.out.println("deleting alarm");
            //deleteAlarm(cloudWatch, "CPU utilization alarn");
            //System.out.println("alarm deleted");
            //
            List<String> alarms = getAlarms(cloudWatch);
            System.out.println(alarms);
            //Set<String> namespaces = listNamespaces(cloudWatch);
            //System.out.println(namespaces);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}