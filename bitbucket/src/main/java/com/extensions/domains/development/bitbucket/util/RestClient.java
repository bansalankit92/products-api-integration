package com.extensions.domains.development.bitbucket.util;

import java.util.Map;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class RestClient {

    private final WebTarget webTarget;
    private final String accessToken;

    public RestClient(String accessToken) {
        this.accessToken = accessToken;
        webTarget = ClientBuilder.newClient().target("https://api.bitbucket.org/2.0/");
    }

    public JSONObject get(String url, Map<String, Object> queryParams) throws JSONException {
        WebTarget resourceTarget = webTarget.path(url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(MediaType.APPLICATION_JSON);
        request.header("Authorization", "Bearer " + accessToken);
        return handleResponse(request.get());
    }

    public JSONObject post(String url, JSONObject body) throws JSONException {
        Invocation.Builder request = webTarget.path(url).request(MediaType.APPLICATION_JSON);
        request.header("Authorization", "Bearer " + accessToken);
        return handleResponse(request.post(Entity.entity(body.toString(), MediaType.APPLICATION_JSON)));
    }

    public static JSONObject handleResponse(Response response) throws JSONException {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return new JSONObject(response.readEntity(String.class));
        } else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        } else {
            throw new RuntimeException(
                    "Status code: " + response.getStatus() + " Message: " + response.readEntity(String.class));
        }
    }

}
