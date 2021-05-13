package com.integration.extensions.domains.sumologic.util;

import com.google.gson.Gson;
import com.integration.util.RestClient;

import java.util.HashMap;
import java.util.Map;

public class AlertUtil {
    public static final String PATH = "/v1/metricsAlertMonitors";
       public static final Gson GSON = new Gson();

       public static String getMonitorAlerts(RestClient restClient) {
           String res = restClient.get(PATH, new HashMap<>());
         //  SlCollectors.CList status = GSON.fromJson(res, SlCollectors.CList.class);
           return res;//status.to();
       }

       public static String getMonitorAlertsById(RestClient restClient, String collectorId) {
           Map<String, Object> qp = new HashMap<>();
           String res = restClient.get(PATH + "/" + collectorId, qp);
          // SlCollectors.SingleCollector status = GSON.fromJson(res, SlCollectors.SingleCollector.class);
           return res;//status.to();
       }
}