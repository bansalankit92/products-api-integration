package com.extensions.domains.development.jira.util.methods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.client.Invocation;

public interface RestClient {

    Invocation.Builder getResourceInvoker(String resource, Map<String, Object> queryParams) throws Exception;

    <T> T fetch(String resource, Map<String, Object> queryParams, Class<T> type) throws Exception;

    String getAuthorizationUrl();

    HashMap getAuthTokenResponse() throws InterruptedException, ExecutionException, IOException;

}