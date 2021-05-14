package utils.methods;

import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClient {

    private final WebTarget webTarget;
    private final String authHeader;

    public RestClient(String accessToken, String hostUrl) {
        Client client = ClientBuilder.newClient();
        webTarget
                = client.target(hostUrl);
        this.authHeader = "Bearer "+accessToken;
    }

    public Invocation.Builder getResourceInvoker(String resource, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(resource);
        for(Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        return resourceTarget.request(MediaType.APPLICATION_JSON).header("Authorization", authHeader);
    }

    public <T> T fetch(String resource, Map<String, Object> queryParams, Class<T> type) {
        WebTarget resourceTarget = webTarget.path(resource);
        for(Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder invoker = resourceTarget.request(MediaType.APPLICATION_JSON).header("Authorization", authHeader);
        javax.ws.rs.core.Response response = invoker.get();
        return response.readEntity(type);
    }

    public String getAuthHeader() {
        return authHeader;
    }

}
