package com.integration.extensions.domains.devops.util;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.glassfish.jersey.client.ClientProperties;

public class RestClient {

    private final WebTarget webTarget;
    private final String accessToken;

    public RestClient(String hostUrl, String accessToken) {
        this.accessToken = accessToken;

        Client client;
        try {
            client = ignoreSSLClient();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            client = ClientBuilder.newClient();
            e.printStackTrace();
        }

        webTarget = client.target(hostUrl);
    }

    public JSONObject get(String url, Map<String, Object> queryParams) throws JSONException {
        WebTarget resourceTarget = webTarget.path(url);
        resourceTarget.property(ClientProperties.FOLLOW_REDIRECTS, Boolean.TRUE);
        for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
            resourceTarget = resourceTarget.queryParam(entrySet.getKey(), entrySet.getValue());
        }
        Invocation.Builder request = resourceTarget.request(MediaType.WILDCARD);
        request.header("Authorization", "Bearer " + accessToken);
        return handleResponse(request.get());
    }

    public JSONObject post(String url, JSONObject body) throws JSONException {
        WebTarget resourceTarget = webTarget.path(url);
        resourceTarget.property(ClientProperties.FOLLOW_REDIRECTS, Boolean.TRUE);
        Invocation.Builder request = resourceTarget.request(MediaType.WILDCARD);
        request.header("Authorization", "Bearer " + accessToken);
        return handleResponse(request.post(Entity.entity(body.toString(), MediaType.APPLICATION_JSON)));
    }

    public JSONObject put(String url, JSONObject body) throws JSONException {
        WebTarget resourceTarget = webTarget.path(url);
        resourceTarget.property(ClientProperties.FOLLOW_REDIRECTS, Boolean.TRUE);
        Invocation.Builder request = resourceTarget.request(MediaType.WILDCARD);
        request.header("Authorization", "Bearer " + accessToken);
        return handleResponse(request.put(Entity.entity(body.toString(), MediaType.APPLICATION_JSON)));
    }

    private static JSONObject handleResponse(Response response) throws JSONException {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return new JSONObject(response.readEntity(String.class));
        } else if (response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
            throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        } else {
            throw new ClientErrorException(response);
        }
    }

    // TODO: Need good solution to avoid this.
    private static Client ignoreSSLClient() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new java.security.SecureRandom());

        return ClientBuilder.newBuilder()
                .sslContext(sslcontext)
                .hostnameVerifier((s1, s2) -> true)
                .build();
    }

}
