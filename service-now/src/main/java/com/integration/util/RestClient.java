package com.integration.util;

import java.util.Map;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import com.google.gson.JsonObject;

import static javax.ws.rs.core.HttpHeaders.*;
import static javax.ws.rs.core.MediaType.*;

public class RestClient {

    private final WebTarget webTarget;
    private final String bearerToken;

    public RestClient(String hostUrl, String accessToken) {
        this.bearerToken = "Bearer " + accessToken;
        webTarget = ClientBuilder.newClient().target(hostUrl);
    }

    public String post(String url, JsonObject body) {
        Invocation.Builder request = webTarget.path(url).request(APPLICATION_JSON);
        request.header(AUTHORIZATION, bearerToken);
        return handleResponse(request.post(Entity.entity(body.toString(), APPLICATION_JSON)));
    }

    public String get(String url, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(APPLICATION_JSON);
        request.header(AUTHORIZATION, bearerToken);
        return handleResponse(request.get());
    }

    public String put(String url, JsonObject body) {
        Invocation.Builder request = webTarget.path(url).request(APPLICATION_JSON);
        request.header(AUTHORIZATION, bearerToken);
        return handleResponse(request.put(Entity.entity(body.toString(), APPLICATION_JSON)));
    }

    public String delete(String url, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(APPLICATION_JSON);
        request.header(AUTHORIZATION, bearerToken);
        return handleResponse(request.delete());
    }

    // region Internal

    private static String handleResponse(Response response) {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return response.readEntity(String.class);
        } else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        } else {
            throw new ClientErrorException(response);
        }
    }

    // endregion
}
