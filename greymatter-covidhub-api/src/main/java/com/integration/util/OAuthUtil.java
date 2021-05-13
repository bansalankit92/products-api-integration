package com.integration.util;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.integration.exception.AuthException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class OAuthUtil {
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String CALLBACK_URI = "callbackUri";
    public static final String HOST_URL = "Host Url";
    public static final String MEDIA_ID = "Krista Media URI";

    public static List<String> scopes = List.of("openid profile email");

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
                .defaultScope(String.join(" ", scopes))
                .build(GoogleApi20.instance());
    }

    public String getValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) throw new RuntimeException("Please provide correct " + key);
        return String.valueOf(value);
    }

    public OAuth2AccessToken getJiraAccessToken() throws InterruptedException,
            ExecutionException, IOException {
        Object refreshToken = (extensionAttributes.get(REFRESH_TOKEN));
        if (refreshToken == null) {
            throw new AuthException("Refresh Token not found. Please re authorize yourself");
        }
        try {
            return (oAuthService.refreshAccessToken(String.valueOf(refreshToken)));
        } catch (OAuthException e) {
            throw new AuthException("Authorization error reauthorize the resource" + e.getMessage());
        }
    }

    public String getGoogleToken() throws InterruptedException,
            ExecutionException, IOException {
        Object refreshToken = (extensionAttributes.get(REFRESH_TOKEN));
        if (refreshToken == null) {
            throw new AuthException("Refresh Token not found. Please re authorize yourself");
        }
        try {
            return oAuthService.refreshAccessToken(String.valueOf(refreshToken)).getAccessToken();
        } catch (OAuthException e) {
            throw new AuthException("Authorization error reauthorize the resource" + e.getMessage());
        }
    }


    public com.integration.extensions.Response getAuthAccessTokenByCode() throws InterruptedException, ExecutionException, IOException {
        com.integration.extensions.Response resp = new com.integration.extensions.Response();
        try {
            OAuth2AccessToken accessToken = oAuthService.getAccessToken(getValue("code"));
            if (accessToken == null) {
                throw new AuthException("Authorization error occurred as the response is empty");
            } else {
                resp.put("access_token", accessToken.getAccessToken());
                resp.put("expires_in", accessToken.getExpiresIn());
                resp.put("scope", accessToken.getScope());
                resp.put("token_type", accessToken.getTokenType());
                resp.put(REFRESH_TOKEN, accessToken.getRefreshToken());
            }
        } catch (OAuthException e) {
            throw new AuthException("Authorization error, please reauthorize the resource" + e.getMessage());
        }
        return resp;
    }

    public String getAuthorizationUrl() {
        final Map<String, String> additionalParams = new HashMap<>();
        additionalParams.put("access_type", "offline");
        additionalParams.put("prompt", "consent");
        return oAuthService.createAuthorizationUrlBuilder()
                .additionalParams(additionalParams)
                .build();
    }


}