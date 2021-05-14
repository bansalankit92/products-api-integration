package com.integration.extensions.domains.devops.util;

import com.integration.extensions.domains.devops.ApplicationHealthData;
import com.integration.extensions.domains.devops.ApplicationSummary;
import com.integration.extensions.domains.devops.CheckApplicationHealthStatusResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ApplicationUtil {

    public static List<ApplicationHealthData> getAll(RestClient restClient) throws JSONException {
        return getAll(restClient, Collections.emptyMap());
    }

    public static ApplicationHealthData getByName(RestClient restClient, String applicationName) throws JSONException {
        List<ApplicationHealthData> applications = getAll(restClient, Map.of("filter[name]", applicationName));
        ApplicationHealthData application = applications.stream()
                .filter(applicationHealthData -> applicationHealthData.name.equals(applicationName))
                .findAny().orElse(null);
        if (application == null) {
            throw new NotFoundException("Application not found with given name");
        }
        return application;
    }

    public static ApplicationHealthData get(RestClient restClient, String applicationId) throws JSONException {
        JSONObject response = restClient.get("/applications/" + applicationId + ".json", Collections.emptyMap());
        return parseApplication(response.getJSONObject("application"));
    }

    public static CheckApplicationHealthStatusResponse checkHealthStatus(RestClient restClient, String applicationName, Long errorThreshold) throws JSONException {
        ApplicationHealthData application = getByName(restClient, applicationName);
        ApplicationSummary summary = (ApplicationSummary) application.summary;

        boolean healthStatus = true;
        if (summary.getErrorRate() > errorThreshold) {
            healthStatus = false;
        }
        healthStatus = healthStatus && summary.getApdexScore() > summary.getApdexTarget();

        CheckApplicationHealthStatusResponse response = new CheckApplicationHealthStatusResponse();
        response.put(CheckApplicationHealthStatusResponse.healthStatus, healthStatus);
        response.put(CheckApplicationHealthStatusResponse.errorRate, summary.get(ApplicationSummary.ERROR_RATE));
        response.put(CheckApplicationHealthStatusResponse.aPDEXTarget, summary.get(ApplicationSummary.APDEX_TARGET));
        response.put(CheckApplicationHealthStatusResponse.aPDEXScore, summary.get(ApplicationSummary.APDEX_SCORE));
        return response;
    }

    // region Application

    private static List<ApplicationHealthData> getAll(RestClient restClient, Map<String, Object> queryParams) throws JSONException {
        JSONObject response = restClient.get("applications.json", queryParams);
        JSONArray applicationsJson = response.getJSONArray("applications");
        List<ApplicationHealthData> applications = new ArrayList<>(applicationsJson.length());
        for (int i = 0; i < applicationsJson.length(); i++) {
            applications.add(parseApplication(applicationsJson.getJSONObject(i)));
        }
        return applications;
    }

    private static ApplicationHealthData parseApplication(JSONObject json) throws JSONException {
        ApplicationHealthData application = new ApplicationHealthData();
        application.applicationId = json.getString("id");
        application.name = json.getString("name");
        application.language = json.getString("language");
        application.healthStatus = json.getString("health_status");
        if (json.has("application_summary"))
            application.summary = ApplicationSummary.create(json.getJSONObject("application_summary"));
        return application;
    }

    // endregion
}
