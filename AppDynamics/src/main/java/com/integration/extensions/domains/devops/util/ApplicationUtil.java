package com.integration.extensions.domains.devops.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.NotFoundException;
import com.integration.extensions.domains.devops.ApplicationMetricsData;
import com.integration.extensions.domains.devops.CheckApplicationHealthStatusResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ApplicationUtil {

    public static List<ApplicationMetricsData> getAll(RestClient restClient) throws JSONException {
        String response = restClient.get("controller/rest/applications", Collections.emptyMap());
        return parseApplications(new JSONArray(response));
    }

    public static ApplicationMetricsData getByName(RestClient restClient, String applicationName) throws JSONException {
        String response = restClient.get("controller/rest/applications/" + applicationName, Collections.emptyMap());
        List<ApplicationMetricsData> applications = parseApplications(new JSONArray(response));
        ApplicationMetricsData application = applications.stream()
                .filter(app -> applicationName.equalsIgnoreCase(app.name))
                .findAny().orElse(null);
        if (application == null) {
            throw new NotFoundException("Application not found for given name - " + applicationName);
        }

        application.metrics = MetricsUtil.getMetricsData(restClient, applicationName);
        return application;
    }

    public static CheckApplicationHealthStatusResponse checkHealthStatus(RestClient client, String applicationName,
                                                                         Long errorThreshold) throws JSONException {

        MetricsUtil.MetricsData errorMetrics = MetricsUtil
                .getMetricsData(client, applicationName, MetricsUtil.OVERALL_APPLICATION_PERFORMANCE + "|" + MetricsUtil.ERRORS_PER_MINUTE);
        MetricsUtil.MetricsData exceptionMetrics = MetricsUtil
                .getMetricsData(client, applicationName, MetricsUtil.OVERALL_APPLICATION_PERFORMANCE + "|" + MetricsUtil.EXCEPTIONS_PER_MINUTE);

        CheckApplicationHealthStatusResponse response = new CheckApplicationHealthStatusResponse();
        response.put(CheckApplicationHealthStatusResponse.healthStatus, (errorMetrics == null || errorMetrics.value < errorThreshold)
                && (exceptionMetrics == null || exceptionMetrics.value < errorThreshold));
        if (errorMetrics != null) {
            response.put(CheckApplicationHealthStatusResponse.errorRate, errorMetrics.value);
        }
        return response;
    }

    public static String createUrl(String applicationName) {
        return "controller/rest/applications/" + applicationName + "/";
    }

    // region Parser

    private static List<ApplicationMetricsData> parseApplications(JSONArray jsonArray) {
        List<ApplicationMetricsData> applications = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            ApplicationMetricsData application = parseApplication(jsonArray.optJSONObject(i));
            if (application != null) {
                applications.add(application);
            }
        }
        return applications;
    }

    private static ApplicationMetricsData parseApplication(JSONObject json) {
        if (json == null) {
            return null;
        }
        ApplicationMetricsData application = new ApplicationMetricsData();
        application.applicationId = json.optString("id");
        application.name = json.optString("name");
        application.description = json.optString("description");
        return application;
    }

    // endregion
}
