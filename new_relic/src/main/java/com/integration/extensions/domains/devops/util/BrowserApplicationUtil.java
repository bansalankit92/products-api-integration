package com.integration.extensions.domains.devops.util;

import com.integration.extensions.domains.devops.BrowserApplication;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrowserApplicationUtil {

    public static List<BrowserApplication> getAll(RestClient restClient) throws JSONException {
        JSONObject response = restClient.get("browser_applications.json", Collections.emptyMap());
        JSONArray applicationsJson = response.getJSONArray("browser_applications");
        List<BrowserApplication> applications = new ArrayList<>(applicationsJson.length());
        for (int i = 0; i < applicationsJson.length(); i++) {
            applications.add(parseBrowserApplication(applicationsJson.getJSONObject(i)));
        }
        return applications;
    }

    public static BrowserApplication get(RestClient restClient, String applicationId) throws JSONException {
        JSONObject response = restClient.get("/browser_applications/" + applicationId + ".json", Collections.emptyMap());
        return parseBrowserApplication(response.getJSONObject("browser_application"));
    }

    private static BrowserApplication parseBrowserApplication(JSONObject json) throws JSONException {
        BrowserApplication browserApp = new BrowserApplication();
        browserApp.applicationId = json.getString("id");
        browserApp.name = json.getString("name");
        browserApp.monitoringKey = json.getString("browser_monitoring_key");
        browserApp.loaderScript = json.getString("loader_script");
        return browserApp;
    }
}
