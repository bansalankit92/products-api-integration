package com.integration.extensions.domains.devops.util;

import com.integration.extensions.domains.devops.CrashSummary;
import com.integration.extensions.domains.devops.MobileApplication;
import com.integration.extensions.domains.devops.MobileApplicationSummary;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobileApplicationUtil {

    public static List<MobileApplication> getAll(RestClient restClient) throws JSONException {
        JSONObject response = restClient.get("mobile_applications.json", Collections.emptyMap());
        JSONArray applicationsJson = response.getJSONArray("applications");
        List<MobileApplication> applications = new ArrayList<>(applicationsJson.length());
        for (int i = 0; i < applicationsJson.length(); i++) {
            applications.add(parseMobileApplication(applicationsJson.getJSONObject(i)));
        }
        return applications;
    }

    public static MobileApplication get(RestClient restClient, String applicationId) throws JSONException {
        JSONObject response = restClient.get("/mobile_applications/" + applicationId + ".json", Collections.emptyMap());
        return parseMobileApplication(response.getJSONObject("application"));
    }

    private static MobileApplication parseMobileApplication(JSONObject json) throws JSONException {
        MobileApplication mobileApp = new MobileApplication();
        mobileApp.applicationId = json.getString("id");
        mobileApp.name = json.getString("name");
        mobileApp.healthStatus = json.getString("health_status");
        mobileApp.summary = MobileApplicationSummary.create(json.getJSONObject("mobile_summary"));
        mobileApp.crashSummary = CrashSummary.create(json.getJSONObject("crash_summary"));
        return mobileApp;
    }
}
