package com.integration.extensions.domains.devops.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.ws.rs.NotFoundException;
import com.integration.extensions.domains.devops.DeploymentCluster;
import com.integration.extensions.domains.devops.DeploymentProject;
import com.integration.extensions.domains.devops.DeploymentWorkload;
import jersey.repackaged.com.google.common.collect.Lists;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class WorkloadUtil {

    public static final String STATE_ACTIVE = "active";

    private static final String WORKLOADS = "workloads";

    public static List<DeploymentWorkload> getAll(RestClient client, String projectId) throws JSONException {
        return parseWorkloadList(getAll(client, projectId, Collections.emptyMap()));
    }

    public static DeploymentWorkload getById(RestClient client, String projectId, String workloadId) throws JSONException {
        return parseWorkload(client.get(prepareWorkloadUrl(projectId) + "/" + workloadId, Collections.emptyMap()));
    }

    public static DeploymentWorkload getByName(RestClient client, String projectId, String workloadName) throws JSONException {
        return parseWorkload(getWorkloadJsonByName(client, projectId, workloadName));
    }

    public static void triggerAction(RestClient client, String projectId, String workloadId, String action) throws JSONException {
        client.get(prepareWorkloadUrl(projectId) + "/" + workloadId, Collections.singletonMap("action", action));
    }

    public static boolean deployBuild(RestClient client, String clusterName, String projectName, String workloadName, String image) throws JSONException, InterruptedException {
        DeploymentCluster cluster = ClusterUtil.getByName(client, clusterName);
        if (cluster == null) {
            throw new NotFoundException("Cluster not found");
        }

        DeploymentProject project = ProjectUtil.getByName(client, cluster.clusterId, projectName);
        if (project == null) {
            throw new NotFoundException("Project not found");
        }

        JSONObject workloadJson = getWorkloadJsonByName(client, project.deploymentProjectId, workloadName);
        JSONArray containers = workloadJson.getJSONArray("containers");
        for (int i = 0; i < containers.length(); i++) {
            JSONObject container = containers.getJSONObject(i);
            if (workloadName.equals(container.getString("name"))) {
                container.put("image", image);
                break;
            }
        }
        DeploymentWorkload workload = parseWorkload(workloadJson);
        WorkloadCheckTimer workloadCheckTimer = new WorkloadCheckTimer(client, parseWorkload(client.put(prepareWorkloadUrl(project.deploymentProjectId) + "/" + workload.workloadId, workloadJson)));
        workloadCheckTimer.waitTillFinish();
        return workloadCheckTimer.workload.state.equals(STATE_ACTIVE);
    }

    // region Internal

    private static JSONArray getAll(RestClient client, String projectId, Map<String, Object> query) throws JSONException {
        return client.get(prepareWorkloadUrl(projectId), query).getJSONArray("data");
    }

    private static JSONObject getWorkloadJsonByName(RestClient client, String projectId, String workloadName) throws JSONException {
        JSONArray data = getAll(client, projectId, Collections.singletonMap("name", workloadName));
        if (data != null && data.length() > 0) {
            return data.getJSONObject(0);
        }
        throw new NotFoundException("DeploymentWorkload not found");
    }

    private static String prepareWorkloadUrl(String projectId) {
        return ProjectUtil.PROJECT + "/" + projectId + "/" + WORKLOADS;
    }

    // endregion

    // region Parser

    private static List<DeploymentWorkload> parseWorkloadList(JSONArray data) throws JSONException {
        List<DeploymentWorkload> workloads = new ArrayList<>(data.length());
        for (int index = 0; index < data.length(); index++) {
            workloads.add(parseWorkload(data.getJSONObject(index)));
        }
        return workloads;
    }

    private static DeploymentWorkload parseWorkload(JSONObject json) throws JSONException {
        DeploymentWorkload workload = new DeploymentWorkload();
        workload.workloadId = json.getString("id");
        workload.deploymentProjectId = json.optString("projectId");
        workload.name = json.getString("name");
        workload.state = json.getString("state");
        workload.actions = Lists.newArrayList(json.getJSONObject("actions").keys());
        return workload;
    }

    // endregion
}
