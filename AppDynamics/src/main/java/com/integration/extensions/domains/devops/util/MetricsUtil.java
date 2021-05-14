package com.integration.extensions.domains.devops.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import static com.integration.extensions.domains.devops.util.ApplicationUtil.*;

public class MetricsUtil {
    public static final String OVERALL_APPLICATION_PERFORMANCE = "Overall Application Performance";
    public static final String ERRORS_PER_MINUTE = "Errors per Minute";
    public static final String EXCEPTIONS_PER_MINUTE = "Exceptions per Minute";

    private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final long HOUR_IN_MILLISECONDS = 60 * 60 * 1000;

    public static List<Metrics> getMetrics(RestClient client, String applicationName) throws JSONException {
        String response = client.get(createUrl(applicationName) + "metrics", Collections.emptyMap());
        return parseMetrics(new JSONArray(response));
    }

    public static List<Metrics> getMetrics(RestClient client, String applicationName, String metricPath) throws JSONException {
        Map<String, Object> queryParams = Map.of("metric-path", metricPath);
        String response = client.get(createUrl(applicationName) + "metrics", queryParams);
        return parseMetrics(new JSONArray(response));
    }

    public static MetricsData getMetricsData(RestClient client, String applicationName, String metricPath) throws JSONException {
        Map<String, Object> queryParams = Map.of("metric-path", metricPath,
                "time-range-type", "BEFORE_NOW",
                "duration-in-mins", 60);

        String response = client.get(createUrl(applicationName) + "metric-data", queryParams);
        List<MetricsData> metricsData = parseMetricsData(new JSONArray(response));
        return metricsData.isEmpty() ? null : metricsData.get(0);
    }

    public static Map<String, Object> getMetricsData(RestClient client, String applicationName) throws JSONException {
        List<Metrics> appMetrics = getMetrics(client, applicationName);
        Metrics metrics = appMetrics.stream()
                .filter(item -> OVERALL_APPLICATION_PERFORMANCE.equalsIgnoreCase(item.name) && item.type.equalsIgnoreCase("folder"))
                .findAny().orElse(null);
        if (metrics == null) {
            return null;
        }

        List<Metrics> metricsList = getMetrics(client, applicationName, OVERALL_APPLICATION_PERFORMANCE);
        Map<String, Object> metricsData = new LinkedHashMap<>(metricsList.size());
        for (Metrics item : metricsList) {
            if (item.type.equalsIgnoreCase("leaf")) {
                MetricsData metricData = getMetricsData(client, applicationName, OVERALL_APPLICATION_PERFORMANCE + "|" + item.name);
                if (metricData != null) {
                    metricsData.put(item.name, metricData.value);
                }
            }
        }
        return metricsData;
    }

    public static String getAuditHistory(RestClient client) {
        long now = System.currentTimeMillis();
        Map<String, Object> query = Map.of("startTime", formatter.format(now - HOUR_IN_MILLISECONDS),
                "endTime", formatter.format(now));

        return client.get("/controller/ControllerAuditHistory", query);
    }

    // region Parser

    private static List<Metrics> parseMetrics(JSONArray jsonArray) throws JSONException {
        List<Metrics> metricsList = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Metrics metrics = new Metrics();
            metrics.type = json.getString("type");
            metrics.name = json.getString("name");
            metricsList.add(metrics);
        }
        return metricsList;
    }

    private static List<MetricsData> parseMetricsData(JSONArray jsonArray) throws JSONException {
        if (jsonArray != null && jsonArray.length() > 0) {
            JSONArray metricValues = jsonArray.getJSONObject(0).optJSONArray("metricValues");
            List<MetricsData> metricsData = new ArrayList<>(metricValues.length());
            for (int i = 0; i < metricValues.length(); i++) {
                metricsData.add(parseMetricsData(metricValues.getJSONObject(i)));
            }
            return metricsData;
        }
        return Collections.emptyList();
    }

    private static MetricsData parseMetricsData(JSONObject json) throws JSONException {
        MetricsData metricsData = new MetricsData();
        metricsData.startTimeInMillis = json.has("startTimeInMillis") ? json.getLong("startTimeInMillis") : null;
        metricsData.value = json.has("value") ? json.getLong("value") : null;
        metricsData.min = json.has("min") ? json.getLong("min") : null;
        metricsData.max = json.has("max") ? json.getLong("max") : null;
        metricsData.count = json.has("count") ? json.getLong("count") : null;
        metricsData.sum = json.has("sum") ? json.getLong("sum") : null;
        return metricsData;
    }

    // endregion

    private static class Metrics {
        public String type;
        public String name;
    }

    static class MetricsData {
        public Long startTimeInMillis;
        public Long value;
        public Long min;
        public Long max;
        public Long count;
        public Long sum;
    }
}
