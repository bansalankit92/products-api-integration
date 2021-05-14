package com.integration.extensions.domains.devops.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.NotFoundException;
import com.integration.extensions.domains.devops.DeploymentCluster;
import com.integration.extensions.domains.devops.Pair;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ClusterUtil {

    public static final String CLUSTER_ID = "Id";
    public static final String CLUSTER_NAME = "Name";

    protected static final String CLUSTERS = "clusters";

    public static List<DeploymentCluster> getAll(RestClient client) throws JSONException {
        return getAll(client, Collections.emptyMap());
    }

    public static DeploymentCluster getById(RestClient client, String clusterId) throws JSONException {
        return parseCluster(client.get(CLUSTERS + "/" + clusterId, Collections.emptyMap()));
    }

    public static DeploymentCluster getByName(RestClient client, String clusterName) throws JSONException {
        List<DeploymentCluster> clusters = getAll(client, Collections.singletonMap("name", clusterName));
        if (clusters.size() > 0) {
            return clusters.get(0);
        }
        throw new NotFoundException("DeploymentCluster not found");
    }

    public static List<Pair<String, String>> search(RestClient client, String matchPattern, String selector,
                                                    Long size, Long pageNumber) throws JSONException {
        List<DeploymentCluster> clusters = getAll(client);
        if (clusters.size() > 0) {
            String searchStr = matchPattern.toLowerCase();
            switch (selector) {
                case CLUSTER_ID:
                    return clusters.stream().filter(cluster -> cluster.clusterId.toLowerCase().contains(searchStr)).
                            map(DeploymentCluster::pair).collect(Collectors.toList());
                case CLUSTER_NAME:
                    return clusters.stream().filter(cluster -> cluster.name.toLowerCase().contains(searchStr)).
                            map(DeploymentCluster::pair).collect(Collectors.toList());
                default:
                    throw new UnsupportedOperationException("Invalid Selector");
            }
        }
        return Collections.emptyList();
    }

    public static List<String> searchableFields() {
        return List.of(CLUSTER_ID, CLUSTER_NAME);
    }

    // region Internal

    public static List<DeploymentCluster> getAll(RestClient client, Map<String, Object> query) throws JSONException {
        JSONObject response = client.get(CLUSTERS, query);
        JSONArray clustersJson = response.getJSONArray("data");
        List<DeploymentCluster> clusters = new ArrayList<>(clustersJson.length());
        for (int index = 0; index < clustersJson.length(); index++) {
            clusters.add(parseCluster(clustersJson.getJSONObject(index)));
        }
        return clusters;
    }

    // endregion

    // region Parser

    private static DeploymentCluster parseCluster(JSONObject responseJson) throws JSONException {
        DeploymentCluster cluster = new DeploymentCluster();
        cluster.clusterId = responseJson.getString("id");
        cluster.name = responseJson.getString("name");
        cluster.description = responseJson.getString("description");
        cluster.state = responseJson.getString("state");
        return cluster;
    }

    // endregion
}
