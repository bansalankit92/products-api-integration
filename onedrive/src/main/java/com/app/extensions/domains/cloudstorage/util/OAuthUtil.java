package com.app.extensions.domains.cloudstorage.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.github.scribejava.apis.MicrosoftAzureActiveDirectory20Api;
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
    public static final String MEDIA_ID = "Krista Media URI";

    public static final String HOST_URL = "https://graph.microsoft.com/v1.0";

    public static final Gson GSON = new Gson();

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
                .build(MicrosoftAzureActiveDirectory20Api.instance());
    }

    public String getValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) {
            throw new RuntimeException("Please provide correct " + key);
        }
        return String.valueOf(value);
    }

    public OAuth2AccessToken getMicrosoftToken() throws InterruptedException,
            ExecutionException, IOException {
        Object refreshToken = (extensionAttributes.get(REFRESH_TOKEN));
        if (refreshToken == null || String.valueOf(refreshToken).isBlank()) {
            throw new RuntimeException("Refresh Token not found. Please re authorize yourself");
        }
        return (oAuthService.refreshAccessToken(String.valueOf(refreshToken)));
    }

    public Map getAccessToken() throws InterruptedException, ExecutionException, IOException {
        Map resp = new HashMap();
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
            throw new RuntimeException("Authorization error reauthorize the resource" + e.getMessage());
        }
        return resp;
    }

    public static String get(OAuthUtil authUtil, String path, Map<String, String> queryParams)
            throws IOException, ExecutionException, InterruptedException {
        OAuth2AccessToken salesforceToken = authUtil.getMicrosoftToken();
        String url = OAuthUtil.HOST_URL + path;
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        queryParams.forEach(request::addQuerystringParameter);
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException(
                        "Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

    public static String putFile(OAuthUtil authUtil, String path, File file)
            throws IOException, ExecutionException, InterruptedException {
        OAuth2AccessToken salesforceToken = authUtil.getMicrosoftToken();
        return MediaClient.upload(path, file, salesforceToken.getAccessToken());
    }

    public static String post(OAuthUtil authUtil, String path, String jsonBody)
            throws IOException, ExecutionException, InterruptedException {
        OAuth2AccessToken salesforceToken = authUtil.getMicrosoftToken();
        String url = OAuthUtil.HOST_URL + path;
        final OAuthRequest request = new OAuthRequest(Verb.POST, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        request.setPayload(jsonBody);
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException(
                        "Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

}