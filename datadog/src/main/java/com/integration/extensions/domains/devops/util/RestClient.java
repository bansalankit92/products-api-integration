package com.integration.extensions.domains.devops.util;

import java.util.Map;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class RestClient {

    private final WebTarget webTarget;
    private final String apiKey;
    private final String applicationKey;

    public RestClient(String apiKey, String applicationKey) {
        this.apiKey = apiKey;
        this.applicationKey = applicationKey;
        webTarget = ClientBuilder.newClient().target("https://api.datadoghq.com/");
    }

    public String get(String url, Map<String, Object> queryParams) throws JSONException {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        return handleResponse(prepareRequest(resourceTarget).get());
    }

    public JSONObject getJson(String url, Map<String, Object> queryParams) throws JSONException {
        return new JSONObject(get(url, queryParams));
    }

    public JSONArray getJsonArray(String url, Map<String, Object> queryParams) throws JSONException {
        return new JSONArray(get(url, queryParams));
    }

    public String delete(String url, Map<String, Object> queryParams) throws JSONException {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        return handleResponse(prepareRequest(resourceTarget).delete());
    }

    public JSONObject post(String url, JSONObject body) throws JSONException {
        String response = handleResponse(prepareRequest(webTarget.path(url))
                .post(Entity.entity(body.toString(), MediaType.APPLICATION_JSON)));
        return new JSONObject(response);
    }

    private Invocation.Builder prepareRequest(WebTarget resourceTarget) {
        return resourceTarget.request(MediaType.APPLICATION_JSON)
                .header("DD-API-KEY", apiKey)
                .header("DD-APPLICATION-KEY", applicationKey);
    }

    private static String handleResponse(Response response) throws JSONException {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return response.readEntity(String.class);
        } else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        } else {
            throw new ClientErrorException(response);
        }
    }

}
