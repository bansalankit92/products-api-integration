package com.krista.extensions.domains.cloudwatch.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.krista.extensions.domains.cloudwatch.Alarm;
import com.krista.extensions.domains.cloudwatch.util.CloudWatchUtil;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class CloudwatchExtensionImpl  {

    private Map<String, Object> attributes = new HashMap<>();

    /**
     * Entity Selector For Log
     */
    
    public List entitySelectorForLog(String matchPattern, String selector, Long fetchSize,
            Long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search ForLog
     */
    
    public List fetchFieldsSupportingSearchForLog() {
        throw new UnsupportedOperationException();
    }

    /**
     * Entity Selector For Alarm
     */
    
    public List entitySelectorForAlarm(String matchPattern, String selector, Long fetchSize,
            Long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Alarm By Primary Key
     */
    
    public Alarm fetchAlarmByPrimaryKey(String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search ForAlarm
     */
    
    public List fetchFieldsSupportingSearchForAlarm() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get alarm by name
     */
    
    public Alarm getAlarmByName(String name) throws Exception {
        return CloudWatchUtil.getAlarm(getCloudWatch(), name);
    }

    /**
     * Get metrics within namespace
     *
     * @return
     */
    
    public Object getMetricsWithinNamespace(String namespace) throws Exception {
        return Map.of("Metrics", CloudWatchUtil.getMetricsWithinNameSpace(getCloudWatch(), namespace));
    }

    /**
     * Get namespaces
     *
     * @return
     */
    
    public Object getNamespaces() throws Exception {
        return Map.of("Namespaces", CloudWatchUtil.listNamespaces(getCloudWatch()));
    }

    /**
     * Get alarms
     *
     * @return
     */
    
    public Object getAlarms() throws Exception {
        return Map.of("Alarms", CloudWatchUtil.getAlarms(getCloudWatch()));
    }

    /**
     * Delete alarm
     */
    
    public void deleteAlarm(String name) throws Exception {
        CloudWatchUtil.deleteAlarm(getCloudWatch(), name);
    }

    private AmazonCloudWatch getCloudWatch() throws Exception {
        return CloudWatchUtil.getCloudWatch(attributes);
    }

}
