package com.extensions.domains.development.bitbucket.oAuth;

import org.codehaus.jettison.json.JSONException;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import com.extensions.domains.development.bitbucket.util.RestClient;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OAuthClient {

    private final WebTarget webTarget;
    private final String clientId;

    public OAuthClient(String clientId, String clientSecret) {
        this.clientId = clientId;
        webTarget = ClientBuilder.newClient()
                .register(HttpAuthenticationFeature.basic(clientId, clientSecret))
                .target("https://bitbucket.org/site/oauth2/");
    }

    public String getOAuthUrl() {
        WebTarget authorize = webTarget.path("authorize");
        authorize = authorize.queryParam("client_id", clientId);
        authorize = authorize.queryParam("response_type", "code");
        return authorize.getUri().toString();
    }

    public AccessToken getAccessToken(String code) throws JSONException {
        return getAccessToken(new Form()
                .param("grant_type", "authorization_code")
                .param("code", code));
    }

    public AccessToken refreshAccessToken(String refresh_token) throws JSONException {
        return getAccessToken(new Form()
                .param("grant_type", "refresh_token")
                .param("refresh_token", refresh_token));
    }

    private AccessToken getAccessToken(Form body) throws JSONException {
        Response response = webTarget.path("access_token")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.form(body));
        return AccessToken.create(RestClient.handleResponse(response) );
    }
}
