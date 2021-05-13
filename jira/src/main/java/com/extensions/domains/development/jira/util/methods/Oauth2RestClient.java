package com.extensions.domains.development.jira.util.methods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class Oauth2RestClient implements RestClient {

    private final OAuthUtil oAuthUtil;
    private OAuthUtil.AccessibleResources accessibleResources = null;

    public Oauth2RestClient(Map<String, Object> attributes) {
        oAuthUtil = new OAuthUtil(attributes);
    }

    public WebTarget getWebTarget() throws InterruptedException, ExecutionException, IOException {
        Client client = ClientBuilder.newClient();
        return client.target("https://api.atlassian.com/ex/jira/" + getAccessibleResources().getId() + "/rest/api/3/");

    }

    public OAuthUtil.AccessibleResources getAccessibleResources()
            throws InterruptedException, ExecutionException, IOException {
        if (accessibleResources == null) {
            accessibleResources = oAuthUtil.getAccessibleResources();
        }
        return accessibleResources;
    }

    @Override
    public Invocation.Builder getResourceInvoker(String resource, Map<String, Object> queryParams) throws Exception {
        WebTarget resourceTarget = getWebTarget().path(resource);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        return resourceTarget.request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + oAuthUtil.getJiraToken());
    }

    @Override
    public <T> T fetch(String resource, Map<String, Object> queryParams, Class<T> type) throws Exception {
        WebTarget resourceTarget = getWebTarget().path(resource);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder invoker = resourceTarget.request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + oAuthUtil.getJiraToken());
        javax.ws.rs.core.Response response = invoker.get();
        return response.readEntity(type);
    }

    @Override
    public String getAuthorizationUrl() {
        return oAuthUtil.getAuthorizationUrl();
    }

    @Override
    public HashMap getAuthTokenResponse() throws InterruptedException, ExecutionException, IOException {
        return oAuthUtil.getAuthAccessTokenByCode();
    }

}
