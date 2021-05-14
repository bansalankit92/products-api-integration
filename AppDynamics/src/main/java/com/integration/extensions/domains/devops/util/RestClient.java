package com.integration.extensions.domains.devops.util;

import java.util.Map;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;

public class RestClient {

    private final WebTarget webTarget;
    private final String accessToken;

    public RestClient(String hostUrl, String accessToken) {
        this.accessToken = accessToken;
        webTarget = ClientBuilder.newClient().target(hostUrl);
    }

    public String get(String url, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        resourceTarget = resourceTarget.queryParam("output", "JSON");
        Invocation.Builder request = resourceTarget.request(MediaType.APPLICATION_JSON);
        request.header("Authorization", "Bearer " + accessToken);
        return handleResponse(request.get());
    }

    public String post(String url, JSONObject body) {
        Invocation.Builder request = webTarget.path(url).request(MediaType.APPLICATION_JSON);
        request.header("Authorization", "Bearer " + accessToken);
        return handleResponse(request.post(Entity.entity(body.toString(), MediaType.APPLICATION_JSON)));
    }

    public static String handleResponse(Response response) {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return response.readEntity(String.class);
        } else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        } else {
            throw new ClientErrorException(response);
        }
    }

}
