package com.krista.extensions.domains.cloudwatch.util;

import com.amazonaws.services.cloudwatch.model.MetricAlarm;
import com.krista.extensions.domains.cloudwatch.Alarm;

public class Alarmutil {

    public static Alarm getAlarm(MetricAlarm metricAlarm) {
        Alarm alarm = new Alarm();
        alarm.configurationUpdatedTimestamp = metricAlarm.getAlarmConfigurationUpdatedTimestamp().toString();
        alarm.comparisonOperator = metricAlarm.getComparisonOperator();
        alarm.description = metricAlarm.getAlarmDescription();
        alarm.actionsEnabled = metricAlarm.getActionsEnabled();
        alarm.statsistics = metricAlarm.getStatistic();
        alarm.period = metricAlarm.getPeriod().toString();
        alarm.dimensions = metricAlarm.getDimensions();
        alarm.metricName = metricAlarm.getMetricName();
        alarm.stateReason = metricAlarm.getStateReason();
        alarm.unit = metricAlarm.getUnit();
        alarm.evaluationPeriod = metricAlarm.getEvaluationPeriods().toString();
        alarm.namespace = metricAlarm.getNamespace();
        alarm.name = metricAlarm.getAlarmName();
        alarm.stateUpdatedTimestamp = metricAlarm.getStateUpdatedTimestamp().toString();
        alarm.aRN = metricAlarm.getAlarmArn();
        alarm.stateValue = metricAlarm.getStateValue();
        alarm.threshold = metricAlarm.getThresholdMetricId();
        return alarm;
    }

}