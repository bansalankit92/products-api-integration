package com.integration.extensions.domains.devops.util;

import java.lang.reflect.Type;
import java.util.*;
import javax.ws.rs.NotFoundException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.integration.extensions.domains.devops.CheckHostHealthStatusResponse;
import com.integration.extensions.domains.devops.HostMetrics;
import com.integration.extensions.domains.devops.HostMonitoringData;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InfrastructureUtil {

    public static List<HostMonitoringData> getInfrastructureList(RestClient client) throws JSONException {
        Map<String, Object> query = new LinkedHashMap<>();
        query.put("with_apps", true);
        query.put("with_sources", true);
        query.put("with_mute_status", true);

        JSONObject response = client.getJson("reports/v2/overview", query);
        return parseHostList(response.getJSONArray("rows"));
    }

    public static List<HostMonitoringData> getAllHost(RestClient client) throws JSONException {
        JSONObject response = client.getJson("api/v1/hosts", Collections.emptyMap());
        return parseHostList(response.getJSONArray("host_list"));
    }

    public static HostMonitoringData getHostByName(RestClient client, String hostName) throws JSONException {
        JSONObject response = client.getJson("api/v1/hosts", Collections.singletonMap("filter", hostName));
        List<HostMonitoringData> hosts = parseHostList(response.getJSONArray("host_list"));
        Optional<HostMonitoringData> search = hosts.stream().filter(host -> host.hostName.equals(hostName)).findFirst();
        if (search.isPresent()) return search.get();
        else throw new NotFoundException("HostMonitoringData not found");
    }

    public static CheckHostHealthStatusResponse checkHostHealthStatus(RestClient restClient, String hostName,
                                                                      Long cPUThreshold, Long systemLoadThreshold) throws JSONException {
        HostMetrics metrics = (HostMetrics) getHostByName(restClient, hostName).metrics;
        boolean healthStatus = metrics.getCPU() <= cPUThreshold && metrics.getLoad() <= systemLoadThreshold;

        CheckHostHealthStatusResponse response = new CheckHostHealthStatusResponse();
        response.put(CheckHostHealthStatusResponse.healthStatus, healthStatus);
        response.put(CheckHostHealthStatusResponse.metrics, metrics);
        return response;
    }

    private static List<HostMonitoringData> parseHostList(JSONArray host_list) throws JSONException {
        List<HostMonitoringData> hosts = new ArrayList<>(host_list.length());
        for (int i = 0; i < host_list.length(); i++) {
            hosts.add(parseHost(host_list.getJSONObject(i)));
        }
        return hosts;
    }

    private static HostMonitoringData parseHost(JSONObject json) throws JSONException {
        HostMonitoringData host = new HostMonitoringData();
        host.hostId = json.getString("id");
        host.hostName = json.getString("host_name");
        host.isMuted = json.optBoolean("is_muted");

        String mute_timeout = json.optString("mute_timeout");
        host.mutedTimeout = mute_timeout == null ? null : Long.parseLong(mute_timeout);

        host.isUp = json.optBoolean("up");
        host.lastReportedAt = json.optLong("last_reported_time");
        host.metrics = HostMetrics.create(json.optJSONObject("metrics"));

        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        JSONArray appsJson = json.optJSONArray("apps");
        if (appsJson != null) {
            host.apps = gson.<List<String>>fromJson(appsJson.toString(), type);
        }

        JSONArray sourcesJson = json.optJSONArray("sources");
        if (sourcesJson != null) {
            host.sources = gson.<List<String>>fromJson(sourcesJson.toString(), type);
        }

        return host;
    }
}
