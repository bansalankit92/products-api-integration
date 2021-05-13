package com.extensions.domains.development.util;

import com.extensions.domains.development.model.GUser;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class GitlabUtil {
    public static final String APPLICATION_VND_GITHUB_V_3_JSON = "application/vnd.github.v3+json";
    public static Gson gson = new Gson();

    public static String getOrganisations(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        OAuth2AccessToken salesforceToken = authUtil.getGitlabTokenByRefreshToken();
        String url = OAuthUtil.GITLab_URL + "/organisations";
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Accept", APPLICATION_VND_GITHUB_V_3_JSON);
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return response.getBody();
        }
    }

    public static String getFullName(String fullName){
        return  URLEncoder.encode(fullName, StandardCharsets.UTF_8);
    }

    public static GUser getUser(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        OAuth2AccessToken salesforceToken = authUtil.getGitlabTokenByRefreshToken();
        String url = OAuthUtil.GITLab_URL + "/api/v4/user";
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Accept", APPLICATION_VND_GITHUB_V_3_JSON);
        request.addHeader("Authorization", "Bearer " + salesforceToken.getAccessToken());
        authUtil.getoAuthService().signRequest(salesforceToken, request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return gson.fromJson(response.getBody(), GUser.class);
        }
    }
    


}