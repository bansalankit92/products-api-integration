package com.extensions.domains.sales.util;

import com.github.scribejava.apis.SalesforceApi;
import com.github.scribejava.apis.salesforce.SalesforceToken;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class OAuthUtil {
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String CALLBACK_URI = "callbackUri";

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
                .build(SalesforceApi.instance());
    }

    public String getValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) throw new RuntimeException("Please provide correct " + key);
        return String.valueOf(value);
    }

    public SalesforceToken getSalesforceToken() throws InterruptedException,
            ExecutionException, IOException {
        Object refreshToken = (extensionAttributes.get(REFRESH_TOKEN));
        if (refreshToken == null || String.valueOf(refreshToken).isBlank()) {
            throw new  RuntimeException("Refresh Token not found. Please re authorize yourself");
        }
        return getSalesforceToken(oAuthService.refreshAccessToken(String.valueOf(refreshToken)));
    }

    public static SalesforceToken getSalesforceToken(OAuth2AccessToken accessToken) {
        final SalesforceToken salesforceAccessToken;
        if (accessToken instanceof SalesforceToken) {
            salesforceAccessToken = (SalesforceToken) accessToken;
        } else {
            throw new  RuntimeException("Salesforce didn't return the correct token. Please Reauthorize");
        }
        return salesforceAccessToken;
    }



}