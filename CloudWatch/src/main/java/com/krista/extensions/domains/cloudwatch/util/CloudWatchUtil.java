package com.krista.extensions.domains.cloudwatch.util;

import java.util.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.*;
import com.google.gson.Gson;
import com.krista.action.ExtensionErrorAction;
import com.krista.exception.ExtensionException;
import com.krista.extensions.domains.cloudwatch.Alarm;

public class CloudWatchUtil {

    public static final String AWS_KEY = "AWS Key";
    public static final String AWS_SECRET = "AWS SECRET";
    public static final String AWS_REGION = "REGION";
    public static final String NA = "NA";

    private static Gson gson = new Gson();

    public static AmazonCloudWatch getCloudWatch(Map<String, Object> connectionAttributes) throws ExtensionException {
        Object key = connectionAttributes.get(AWS_KEY);
        Object secret = connectionAttributes.get(AWS_SECRET);
        Object region = connectionAttributes.get(AWS_REGION);

        if (key == null || secret == null || region == null) {
            throw new ExtensionException(new Exception("Some of the connection attributes are empty")
                    , new ExtensionErrorAction("Some of the connection attributes are empty", true));
        }
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                String.valueOf(key), String.valueOf(secret));

        AmazonCloudWatch amazonCloudWatch = AmazonCloudWatchClientBuilder.standard().withRegion(String.valueOf(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
        return amazonCloudWatch;
    }

    public static Set<String> listNamespaces(AmazonCloudWatch amazonCloudWatch) {
        Set<String> namespaces = new HashSet<>();
        ListMetricsRequest request = new ListMetricsRequest();

        boolean done = false;

        while (!done) {
            ListMetricsResult response = amazonCloudWatch.listMetrics(request);

            for (Metric metric : response.getMetrics()) {
                namespaces.add(metric.getNamespace());
            }
            request.setNextToken(response.getNextToken());
            if (response.getNextToken() == null) {
                done = true;
            }
        }
        return namespaces;
    }

    public static List<String> getMetricsWithinNameSpace(AmazonCloudWatch amazonCloudWatch, String namespace) {
        List<String> metricsList = new ArrayList<>();
        ListMetricsRequest request = new ListMetricsRequest()
                .withNamespace(namespace);

        boolean done = false;

        while (!done) {
            ListMetricsResult response = amazonCloudWatch.listMetrics(request);

            for (Metric metric : response.getMetrics()) {
                metricsList.add(metric.getMetricName());
            }
            request.setNextToken(response.getNextToken());
            if (response.getNextToken() == null) {
                done = true;
            }
        }
        return metricsList;
    }

    //public static List<String> listMetricsDimensions(AmazonCloudWatch amazonCloudWatch, String name,
    //        String namespace) {
    //    List<String> metricsList = new ArrayList<>();
    //    ListMetricsRequest request = new ListMetricsRequest()
    //            .withMetricName(name)
    //            .withNamespace(namespace);
    //
    //    boolean done = false;
    //
    //    while (!done) {
    //        ListMetricsResult response = amazonCloudWatch.listMetrics(request);
    //
    //        Map<String, String> dimensions = new HashMap<>();
    //        for (Metric metric : response.getMetrics()) {
    //            metric.getDimensions().stream()
    //                    .forEach(dimension -> dimensions.put(dimension.getName(), dimension.getValue()));
    //            metricsList.add(metric.getMetricName());
    //        }
    //        request.setNextToken(response.getNextToken());
    //        if (response.getNextToken() == null) {
    //            done = true;
    //        }
    //    }
    //    return metricsList;
    //}

    public static void putMetricAlarm(AmazonCloudWatch cloudWatch, String alarmName, String metricName,
            String nameSpace, String dimensionKey, String dimensionValue, boolean actionsEnabled,
            String alarmDescription, String comparisonOperator, String statistic, Long period, Long threshold,
            String unit) {

        PutMetricAlarmRequest request = new PutMetricAlarmRequest()
                .withAlarmName(alarmName)
                .withComparisonOperator(comparisonOperator)
                .withEvaluationPeriods(1)
                .withMetricName(metricName)
                .withNamespace(nameSpace)
                .withPeriod(period.intValue())
                .withStatistic(statistic)
                .withThreshold(threshold.doubleValue())
                .withActionsEnabled(actionsEnabled)
                .withAlarmDescription(alarmDescription)
                .withUnit(unit);

        //TODO: Gaurav, currently Map is not suported
        //if (dimensions != null && !dimensions.isEmpty()) {
        //    for (Map.Entry<String, String> dimension : dimensions.entrySet()) {
        //        request.withDimensions(new Dimension().withName(dimension.getKey()).withValue(dimension.getValue()));
        //    }
        //}

        request.withDimensions(new Dimension().withName(dimensionKey).withValue(dimensionValue));

        PutMetricAlarmResult response = cloudWatch.putMetricAlarm(request);
    }

    public static Alarm getAlarm(AmazonCloudWatch amazonCloudWatch, String alarmName) {
        DescribeAlarmsRequest request = new DescribeAlarmsRequest().withAlarmNames(alarmName);
        boolean done = false;
        Alarm alarm = null;
        while (!done) {

            DescribeAlarmsResult response = amazonCloudWatch.describeAlarms(request);
            System.out.println(new Gson().toJson(response.getMetricAlarms()));

            for (MetricAlarm alarmEntry : response.getMetricAlarms()) {
                alarm = Alarmutil.getAlarm(alarmEntry);
            }

            request.setNextToken(response.getNextToken());
            if (response.getNextToken() == null) {
                done = true;
            }
        }
        return alarm;
    }

    public static List<String> getAlarms(AmazonCloudWatch amazonCloudWatch) {
        List<String> alarms = new ArrayList<>();
        boolean done = false;
        DescribeAlarmsRequest request = new DescribeAlarmsRequest();

        while (!done) {

            DescribeAlarmsResult response = amazonCloudWatch.describeAlarms(request);

            for (MetricAlarm alarm : response.getMetricAlarms()) {
                alarms.add(alarm.getAlarmName());
            }

            request.setNextToken(response.getNextToken());
            if (response.getNextToken() == null) {
                done = true;
            }
        }
        return alarms;
    }

    public static void deleteAlarm(AmazonCloudWatch amazonCloudWatch, String alarmName) {
        DeleteAlarmsRequest request = new DeleteAlarmsRequest()
                .withAlarmNames(alarmName);

        DeleteAlarmsResult response = amazonCloudWatch.deleteAlarms(request);
    }

}
