package com.integration.util;

import com.google.gson.Gson;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Map;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class RestClient {

    private final WebTarget webTarget;
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String USERNAME_PASSWORD = "Username Password Base64";
    public static final String HOST_URL = "Host URL";
    public final Map<String, Object> extensionAttributes;
    public static final Gson gson = new Gson();
    private static final String envApi = "/rest/v11_8";

    public RestClient(Map<String, Object> attributes) {
        this.extensionAttributes = attributes;
        webTarget = ClientBuilder.newClient().target(getValue(HOST_URL));
    }

    public String getValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) throw new RuntimeException("Please provide correct " + key);
        return String.valueOf(value);
    }

    public String getOptionalValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) return "";
        return String.valueOf(value);
    }

    public String getAuthorization() {
        Invocation.Builder request = webTarget.path(envApi+"/oauth2/token").request(APPLICATION_JSON);
        String base64UsernamePassowrd = getValue(USERNAME_PASSWORD);
        Base64Plus.UsernamePassword usernamePassword = Base64Plus.decode(base64UsernamePassowrd);
        Oauth2Password password = new Oauth2Password()
                .withUsername(usernamePassword.getUsername())
                .withPassword(usernamePassword.getPassowrd())
                .withClientId(getValue(CLIENT_ID))
                .withClientSecret(getOptionalValue(CLIENT_SECRET))
                .withGrantType("password");
        String res = handleResponse(request.post(Entity.entity(password.toJson(), APPLICATION_JSON)));
        Oauth2Password.Response response = gson.fromJson(res, Oauth2Password.Response.class);
        return "Bearer " + response.getAccessToken();
    }


    public String post(String url, String body) {
        Invocation.Builder request = webTarget.path(envApi+url).request(APPLICATION_JSON);
        request.header(AUTHORIZATION, getAuthorization());
        return handleResponse(request.post(Entity.entity(body, APPLICATION_JSON)));
    }

    public String get(String url, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(envApi+url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(APPLICATION_JSON);
        request.header(AUTHORIZATION, getAuthorization());
        return handleResponse(request.get());
    }

    public String put(String url, String body) {
        Invocation.Builder request = webTarget.path(envApi+url).request(APPLICATION_JSON);
        request.header(AUTHORIZATION, getAuthorization());
        return handleResponse(request.put(Entity.entity(body, APPLICATION_JSON)));
    }

    public String delete(String url, Map<String, Object> queryParams) {
        WebTarget resourceTarget = webTarget.path(envApi+url);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(APPLICATION_JSON);
        request.header(AUTHORIZATION, getAuthorization());
        return handleResponse(request.delete());
    }

    // region Internal

    private static String handleResponse(Response response) {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL)
            return response.readEntity(String.class);
        else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode())
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        else throw new RuntimeException(response.readEntity(String.class));
    }

    // endregion
}
