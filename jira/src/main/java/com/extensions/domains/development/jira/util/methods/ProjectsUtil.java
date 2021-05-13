package com.extensions.domains.development.jira.util.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.extensions.domains.development.TicketingProject;
import com.extensions.domains.development.jira.util.vos.JiraProject;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ProjectsUtil {
    public static List<TicketingProject> getAllProjects(RestClient client) throws Exception {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxResults", 150);
        String jsonResponse = client.fetch("project", queryParams, String.class);
        List<TicketingProject> finalResponse = new ArrayList<>();
        try {
            JSONArray projectArray = new JSONArray(jsonResponse);
            for (int i = 0; i < projectArray.length(); i++) {
                JiraProject jiraProject = JiraProject.create(projectArray.getJSONObject(i));
                finalResponse.add(jiraProject.getProject());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return finalResponse;
    }

    public static JiraProject getProjectByKey(String key, RestClient client) throws Exception {
        String jsonResponse = client.fetch("project", new HashMap<>(), String.class);
        try {
            JSONArray projects = new JSONArray(jsonResponse);
            for (int i = 0; i < projects.length(); i++) {
                JiraProject jiraProject = JiraProject.create(projects.getJSONObject(i));
                if (jiraProject.key.equals(key)) {
                    return jiraProject;
                }
            }
            throw new Exception("Invalid Key");
        } catch (JSONException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static JiraProject getProjectById(String id, RestClient client) throws Exception {
        String jsonResponse = client.fetch("project/" + id, new HashMap<>(), String.class);
        try {
            return JiraProject.create(new JSONObject(jsonResponse));
        } catch (JSONException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static TicketingProject getProjectByIdOrKey(String id, RestClient client) throws Exception {
        return getProjectById(id, client).getProject();
    }
}
