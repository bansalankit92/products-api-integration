package com.extensions.domains.development.jira.util.methods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class AuthRestClient implements RestClient {

    private final WebTarget webTarget;

    public AuthRestClient(String userName, String password, String hostUrl) {
        HttpAuthenticationFeature
                feature = HttpAuthenticationFeature.basic(userName, password);
        Client client = ClientBuilder.newClient();
        client.register(feature);
        webTarget
                = client.target(hostUrl);
    }

    @Override
    public Invocation.Builder getResourceInvoker(String resource, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(resource);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        return resourceTarget.request(MediaType.APPLICATION_JSON);
    }

    @Override
    public <T> T fetch(String resource, Map<String, Object> queryParams, Class<T> type) {
        WebTarget resourceTarget = webTarget.path(resource);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder invoker = resourceTarget.request(MediaType.APPLICATION_JSON);
        javax.ws.rs.core.Response response = invoker.get();
        return response.readEntity(type);
    }

    @Override
    public String getAuthorizationUrl() {
        return null;
    }

    @Override
    public HashMap getAuthTokenResponse() throws InterruptedException, ExecutionException, IOException {
        return null;
    }

}
