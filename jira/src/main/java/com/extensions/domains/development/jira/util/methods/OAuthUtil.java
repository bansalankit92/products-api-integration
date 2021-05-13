package com.extensions.domains.development.jira.util.methods;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.Gson;

public class OAuthUtil {

    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String CALLBACK_URI = "callbackUri";
    public static List<String> scopes =
            List.of("read:jira-user", "read:jira-work", "write:jira-work", "manage:jira-data-provider",
                    "manage:jira-project");

    private Map<String, Object> extensionAttributes;
    private OAuth20Service oAuthService;

    public OAuthUtil(Map<String, Object> attributes) {
        this.extensionAttributes = attributes;
        this.oAuthService = getOauthService();
    }

    public OAuth20Service getoAuthService() {
        return oAuthService;
    }

    private OAuth20Service getOauthService() {
        return new ServiceBuilder(getValue(CLIENT_ID))
                .apiSecret(getValue(CLIENT_SECRET))
                .callback(getValue(CALLBACK_URI))
                .defaultScope(String.join(" ", scopes) + " offline_access")
                .build(JiraApi20.instance());
    }

    public String getValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) {
            throw new RuntimeException("Please provide correct " + key);
        }
        return String.valueOf(value);
    }

    public OAuth2AccessToken getJiraAccessToken() throws InterruptedException,
            ExecutionException, IOException {
        Object refreshToken = (extensionAttributes.get(REFRESH_TOKEN));
        if (refreshToken == null) {
            throw new RuntimeException("Refresh Token not found. Please re authorize yourself");
        }
        try {
            return (oAuthService.refreshAccessToken(String.valueOf(refreshToken)));
        } catch (OAuthException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        }
    }

    public String getJiraToken() throws InterruptedException,
            ExecutionException, IOException {
        Object refreshToken = (extensionAttributes.get(REFRESH_TOKEN));
        if (refreshToken == null) {
            throw new RuntimeException("Refresh Token not found. Please re authorize yourself");
        }
        try {
            return oAuthService.refreshAccessToken(String.valueOf(refreshToken)).getAccessToken();
        } catch (OAuthException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        }
    }

    public HashMap getAuthAccessTokenByCode() throws InterruptedException, ExecutionException, IOException {
        HashMap resp = new HashMap();
        try {
            OAuth2AccessToken accessToken = oAuthService.getAccessToken(getValue("code"));
            if (accessToken == null) {
                throw new RuntimeException("Authorization error occurred as the response is empty");
            } else {
                resp.put("access_token", accessToken.getAccessToken());
                resp.put("expires_in", accessToken.getExpiresIn());
                resp.put("scope", accessToken.getScope());
                resp.put("token_type", accessToken.getTokenType());
                resp.put(REFRESH_TOKEN, accessToken.getRefreshToken());
            }
        } catch (OAuthException e) {
            throw new RuntimeException("Authorization error, please reauthorize the resource" + e.getMessage());
        }
        return resp;
    }

    public String getAuthorizationUrl() {
        return oAuthService.getAuthorizationUrl() + "&audience=api.atlassian.com&prompt=consent";
    }

    public AccessibleResources getAccessibleResources() throws InterruptedException, ExecutionException, IOException {
        OAuth2AccessToken jiraToken = getJiraAccessToken();
        String url = "https://api.atlassian.com/oauth/token/accessible-resources";
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + jiraToken.getAccessToken());
        oAuthService.signRequest(jiraToken, request);
        try (com.github.scribejava.core.model.Response response = oAuthService.execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException(
                        "Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            AccessibleResources[] accessibleResources =
                    new Gson().fromJson(response.getBody(), AccessibleResources[].class);
            if (accessibleResources.length == 0) {
                throw new RuntimeException("We didn't found any resources to fulfill your requests.");
            } else if (accessibleResources.length == 1) {
                return accessibleResources[0];
            } else {
                for (AccessibleResources accessibleResource : accessibleResources) {
                    boolean isScopeFulfilled = true;
                    for (String scope : scopes) {
                        if (!accessibleResource.scopes.contains(scope)) {
                            isScopeFulfilled = false;
                            break;
                        }
                    }
                    if (isScopeFulfilled) {
                        return accessibleResource;
                    }
                }
                throw new RuntimeException("None of the accessible resources has all the scopes required by this app.");
            }
        }
    }

    public static class AccessibleResources {

        private String id, url, name, avatarUrl;
        private List<String> scopes;

        public AccessibleResources(String id, String url, String name, String avatarUrl, List<String> scopes) {
            this.id = id;
            this.url = url;
            this.name = name;
            this.avatarUrl = avatarUrl;
            this.scopes = scopes;
        }

        public String getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public List<String> getScopes() {
            return scopes;
        }

    }

}