package com.integration.extensions.domains.devops.util;

import java.util.*;
import java.util.stream.Collectors;
import javax.ws.rs.NotFoundException;
import com.integration.extensions.domains.devops.DeploymentCluster;
import com.integration.extensions.domains.devops.DeploymentProject;
import com.integration.extensions.domains.devops.Pair;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ProjectUtil {

    private static final String PROJECT_ID = "Id";
    private static final String PROJECT_NAME = "Name";

    private static final String PROJECTS = "projects";
    public static final String PROJECT = "project";

    public static List<DeploymentProject> getAll(RestClient client, String clusterId) throws JSONException {
        return getAll(client, Collections.singletonMap("clusterId", clusterId));
    }

    public static List<DeploymentProject> getAll(RestClient client) throws JSONException {
        return getAll(client, Collections.emptyMap());
    }

    public static DeploymentProject getById(RestClient client, String projectId) throws JSONException {
        return parseProject(client, client.get(PROJECTS + "/" + projectId, Collections.emptyMap()));
    }

    public static DeploymentProject getByName(RestClient client, String clusterId, String projectName) throws JSONException {
        List<DeploymentProject> projects = getAll(client, Map.of(
                "clusterId", clusterId,
                "name", projectName));

        if (projects.size() > 0) {
            return projects.get(0);
        }
        throw new NotFoundException("DeploymentProject not found");
    }

    public static List<Pair<String, String>> search(RestClient client, String matchPattern, String selector,
                                                    Long size, Long pageNumber) throws JSONException {
        List<DeploymentProject> projects = getAll(client);
        if (projects.size() > 0) {
            String searchStr = matchPattern.toLowerCase();
            switch (selector) {
                case PROJECT_ID:
                    return projects.stream().filter(project -> project.deploymentProjectId.toLowerCase().contains(searchStr)).
                            map(DeploymentProject::pair).collect(Collectors.toList());
                case PROJECT_NAME:
                    return projects.stream().filter(cluster -> cluster.name.toLowerCase().contains(searchStr)).
                            map(DeploymentProject::pair).collect(Collectors.toList());
                default:
                    throw new UnsupportedOperationException("Invalid Selector");
            }
        }
        return Collections.emptyList();
    }

    public static List<String> searchableFields() {
        return List.of(PROJECT_ID, PROJECT_NAME);
    }

    // region Internal

    private static List<DeploymentProject> getAll(RestClient client, Map<String, Object> query) throws JSONException {
        JSONArray data = client.get(PROJECTS, query).getJSONArray("data");
        List<DeploymentProject> projects = new ArrayList<>(data.length());
        for (int index = 0; index < data.length(); index++) {
            projects.add(parseProject(data.getJSONObject(index), ClusterUtil.getAll(client)));
        }
        return projects;
    }

    // endregion

    // region Parser

    private static DeploymentProject parseProject(JSONObject responseJson, List<DeploymentCluster> clusters) throws JSONException {
        DeploymentProject project = parseProject(responseJson);
        Optional<DeploymentCluster> clusterOptional = clusters.stream().filter(cluster -> cluster.clusterId.equals(project.deploymentClusterId)).findFirst();
        if (clusterOptional.isEmpty()) {
            throw new NotFoundException("Cluster not found for given project");
        }
        project.deploymentClusterName = clusterOptional.get().name;
        return project;
    }

    private static DeploymentProject parseProject(RestClient client, JSONObject json) throws JSONException {
        DeploymentProject project = parseProject(json);
        project.deploymentClusterName = ClusterUtil.getById(client, project.deploymentClusterId).name;
        return project;
    }

    private static DeploymentProject parseProject(JSONObject json) throws JSONException {
        DeploymentProject project = new DeploymentProject();
        project.deploymentProjectId = json.getString("id");
        project.name = json.getString("name");
        project.description = json.getString("description");
        project.state = json.getString("state");
        project.deploymentClusterId = json.getString("clusterId");
        return project;
    }

    // endregion
}
