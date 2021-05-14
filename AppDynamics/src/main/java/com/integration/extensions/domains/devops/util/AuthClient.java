package com.integration.extensions.domains.devops.util;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AuthClient {

    public final String hostUrl;
    private final String clientId;
    private final String clientSecret;
    private final WebTarget webTarget;

    public AuthClient(String hostUrl, String accountName, String apiClientName, String clientSecret) {
        this.hostUrl = hostUrl;
        this.clientSecret = clientSecret;
        clientId = apiClientName + "@" + accountName;
        webTarget = ClientBuilder.newClient().target(hostUrl);
    }

    public String getAccessToken() throws JSONException {
        Invocation.Builder request = webTarget.path("controller/api/oauth/access_token").request(MediaType.WILDCARD);
        String body = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret;
        return handleResponse(request.post(Entity.entity(body, MediaType.TEXT_PLAIN)))
                .getString("access_token");
    }

    public static JSONObject handleResponse(Response response) throws JSONException {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return new JSONObject(response.readEntity(String.class));
        } else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        } else {
            throw new ClientErrorException(response);
        }
    }

}
