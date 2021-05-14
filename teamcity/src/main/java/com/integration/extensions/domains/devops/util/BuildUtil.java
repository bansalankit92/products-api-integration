package com.integration.extensions.domains.devops.util;

import com.integration.extensions.domains.devops.Build;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BuildUtil {

    public static final String STATE_FINISHED = "finished";
    public static final String STATUS_SUCCESS = "SUCCESS";

    public static Build getById(RestClient client, String buildId) throws JSONException {
        return parseBuild(client.get("builds/id:" + buildId, Collections.emptyMap()));
    }

    public static Build get(RestClient client, String projectName, String buildNumber) throws JSONException {
        Map<String, Object> query = Collections.singletonMap("locator", "project:name:" + projectName + ",number:" + buildNumber);
        JSONArray builds = client.get("builds", query).getJSONArray("build");
        if (builds.length() > 0) {
            return getById(client, builds.getJSONObject(0).getString("id"));
        }
        return null;
    }

    public static List<Build> ongoingBuilds(RestClient client) throws JSONException {
        return getBuilds(client, client.get("builds", Collections.singletonMap("locator", "state:running")));
    }

    public static List<Build> queuedBuilds(RestClient client) throws JSONException {
        return getBuilds(client, client.get("buildQueue", Collections.emptyMap()));
    }

    public static Build trigger(RestClient client, String buildTypeId) throws JSONException, InterruptedException {
        return trigger(client, buildTypeId, new JSONArray());
    }

    public static Build trigger(RestClient client, String buildTypeId, String environmentUrl) throws JSONException, InterruptedException {
        JSONArray properties = new JSONArray()
                .put(new JSONObject()
                        .put("name", "env.ENVIRONMENT_URL")
                        .put("value", environmentUrl));
        return trigger(client, buildTypeId, properties);
    }

    // region Internal

    private static Build trigger(RestClient client, String buildTypeId, JSONArray properties) throws JSONException, InterruptedException {
        JSONObject buildJson = new JSONObject()
                .put("buildType", new JSONObject().put("id", buildTypeId))
                .put("properties", new JSONObject().put("property", properties))
                .put("comment", new JSONObject().put("text", "Build initiated from Krista."));

        BuildCheckTimer buildCheckTimer = new BuildCheckTimer(client, parseBuild(client.post("buildQueue", buildJson)));
        buildCheckTimer.waitTillFinish();
        return buildCheckTimer.build;
    }

    private static List<Build> getBuilds(RestClient client, JSONObject response) throws JSONException {
        JSONArray buildsJson = response.getJSONArray("build");
        List<Build> builds = new ArrayList<>(buildsJson.length());
        for (int i = 0; i < buildsJson.length(); i++) {
            builds.add(getById(client, buildsJson.getJSONObject(0).getString("id")));
        }
        return builds;
    }

    // endregion

    // region Parser

    private static Build parseBuild(JSONObject json) throws JSONException {
        Build build = new Build();
        build.buildId = json.getString("id");
        build.buildNumber = json.optString("number");
        build.status = json.optString("status");
        build.state = json.optString("state");

        JSONObject buildType = json.getJSONObject("buildType");
        build.buildTypeId = buildType.getString("id");
        build.deploymentProjectName = buildType.getString("projectName");

        return build;
    }

    // endregion
}
