package com.integration.extensions.domains.devops.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.integration.extensions.domains.devops.ProjectBuild;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ProjectUtil {

    public static List<String> getAll(RestClient client) throws JSONException {
        JSONObject responseJson = client.get("projects", Collections.emptyMap());
        List<String> projectList = new ArrayList<>();
        JSONArray projectsJson = responseJson.optJSONArray("project");
        if (projectsJson != null) {
            for (int index = 0; index < projectsJson.length(); index++) {
                String id = projectsJson.getJSONObject(index).getString("id");
                if (!id.equalsIgnoreCase("_Root")) {
                    String name = projectsJson.getJSONObject(index).getString("name");
                    projectList.add(name);
                }
            }
        }
        return projectList;
    }

    public static ProjectBuild get(RestClient client, String projectName) throws JSONException {
        return parseProject(client.get("projects/name:" + projectName, Collections.emptyMap()));
    }

    private static ProjectBuild parseProject(JSONObject json) throws JSONException {
        ProjectBuild project = new ProjectBuild();
        project.projectId = json.getString("id");
        project.name = json.getString("name");
        JSONObject buildTypesJson = json.optJSONObject("buildTypes");
        if (buildTypesJson != null) {
            List<String> buildTypes = new ArrayList<>();
            JSONArray buildType = buildTypesJson.optJSONArray("buildType");
            if (buildType != null) {
                for (int i = 0; i < buildType.length(); i++) {
                    String buildTypeId = buildType.getJSONObject(i).optString("id", null);
                    if (buildTypeId != null && !buildTypeId.isEmpty()) {
                        buildTypes.add(buildTypeId);
                    }
                }
            }
            project.buildTypes = buildTypes;
        }
        return project;
    }

}
