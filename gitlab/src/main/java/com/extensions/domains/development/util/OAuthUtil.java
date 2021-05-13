package com.extensions.domains.development.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class OAuthUtil {

    public static final String ACCESS_TOKEN = "access_token";
    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String CALLBACK_URI = "callbackUri";
    public static final String HOST_URL = "Host Url";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String GITLab_URL = "https://gitlab.com";

    private final Map<String, Object> extensionAttributes;
    private final OAuth20Service oAuthService;

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
                .build(GitlabApi20.instance(getHostUrl()));
    }

    public String getHostUrl() {
        Object hostUrl = (extensionAttributes.get(HOST_URL));
        if (hostUrl == null || String.valueOf(hostUrl).isBlank()) {
            return GITLab_URL;
        }
        return String.valueOf(hostUrl);
    }

    public String getHostUrlPath() {
        return getHostUrl() + "/api/v4/";
    }

    public String getValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) {
            throw new RuntimeException("Please provide correct " + key);
        }
        return String.valueOf(value);
    }

    public String getAccessToken() {
        Object refreshToken = (extensionAttributes.get(ACCESS_TOKEN));
        if (refreshToken == null || String.valueOf(refreshToken).isBlank()) {
            throw new RuntimeException("Refresh Token not found. Please re authorize yourself");
        }
        return String.valueOf(refreshToken);
    }

    public OAuth2AccessToken getGitlabTokenByRefreshToken() throws InterruptedException,
            ExecutionException, IOException {
        Object refreshToken = (extensionAttributes.get(REFRESH_TOKEN));
        if (refreshToken == null || String.valueOf(refreshToken).isBlank()) {
            throw new RuntimeException("Refresh Token not found. Please re authorize yourself");
        }
        OAuth2AccessToken auth2AccessToken = oAuthService.refreshAccessToken(String.valueOf(refreshToken));
        System.out.println(GitlabUtil.gson.toJson(auth2AccessToken));
        return auth2AccessToken;
    }

    public HashMap getAccessTokenByCode() throws InterruptedException, ExecutionException, IOException {
        HashMap resp = new HashMap();
        try {
            OAuth2AccessToken accessToken = oAuthService.getAccessToken(getValue("code"));
            if (accessToken == null) {
                throw new RuntimeException("Authorization error occurred as the response is empty");
            } else {
                resp.put(ACCESS_TOKEN, accessToken.getAccessToken());
                resp.put("expires_in", accessToken.getExpiresIn());
                resp.put("scope", accessToken.getScope());
                resp.put("token_type", accessToken.getTokenType());
                resp.put(REFRESH_TOKEN, accessToken.getRefreshToken());
            }
        } catch (OAuthException e) {
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        }
        return resp;
    }

    public String getAuthorizationUrl() {
        return oAuthService.getAuthorizationUrl() + "&grant_type=authorization_code&access_type=offline&prompt=consent";
    }

    public static String get(OAuthUtil authUtil, String path, Map<String, String> queryParams)
            throws IOException, ExecutionException, InterruptedException {
        String url = authUtil.getHostUrlPath() + path;
        // OAuth2AccessToken salesforceToken = authUtil.getGitlabTokenByRefreshToken();
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            request.addQuerystringParameter(entry.getKey(), entry.getValue());
        }
        request.addHeader("Authorization", "Bearer " + authUtil.getAccessToken());
        authUtil.getoAuthService().signRequest(authUtil.getAccessToken(), request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException(
                        "Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

    public static String post(OAuthUtil authUtil, String path, Map<String, Object> body)
            throws IOException, ExecutionException, InterruptedException {
        String url = authUtil.getHostUrlPath() + path;
        final OAuthRequest request = new OAuthRequest(Verb.POST, url);
        request.setPayload(GitlabUtil.gson.toJson(body));
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + authUtil.getAccessToken());
        authUtil.getoAuthService().signRequest(authUtil.getAccessToken(), request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException(
                        "Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

    public static String put(OAuthUtil authUtil, String path, Map<String, Object> body)
            throws IOException, ExecutionException, InterruptedException {
        String url = authUtil.getHostUrlPath() + path;
        final OAuthRequest request = new OAuthRequest(Verb.PUT, url);
        request.setPayload(GitlabUtil.gson.toJson(body));
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + authUtil.getAccessToken());
        authUtil.getoAuthService().signRequest(authUtil.getAccessToken(), request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException(
                        "Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

}