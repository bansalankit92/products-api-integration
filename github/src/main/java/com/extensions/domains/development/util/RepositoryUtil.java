package com.extensions.domains.development.util;

import com.extensions.domains.development.CodeRepository;
import com.extensions.domains.development.model.GRepo;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class RepositoryUtil {

    public static List<GRepo> getUserRepositories(OAuthUtil authUtil, int page, int size)
            throws IOException, ExecutionException, InterruptedException {
        //OAuth2AccessToken salesforceToken = authUtil.getGithubTokenByRefreshToken();
        String url = OAuthUtil.GITHUB_URL + "/user/repos";
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addQuerystringParameter("Accept", GithubUtil.APPLICATION_VND_GITHUB_V_3_JSON);
        request.addQuerystringParameter("visibility", "all");
        // request.addHeader("affiliation","owner");
        request.addQuerystringParameter("sort", "updated");
        request.addQuerystringParameter("direction", "desc");
        request.addQuerystringParameter("per_page", String.valueOf(size));
        request.addQuerystringParameter("page", String.valueOf(page));
        request.addQuerystringParameter("Authorization", "Bearer " + authUtil.getAccessToken());
        authUtil.getoAuthService().signRequest(authUtil.getAccessToken(), request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return Arrays.asList(GithubUtil.gson.fromJson(response.getBody(), GRepo[].class));
        }
    }

    public static List<GRepo> getAllUserRepositories(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        //OAuth2AccessToken salesforceToken = authUtil.getGithubTokenByRefreshToken();
        String url = OAuthUtil.GITHUB_URL + "/user/repos";
        final OAuthRequest request = new OAuthRequest(Verb.GET, url);
        request.addHeader("Content-Type", "application/json");
        request.addQuerystringParameter("Accept", GithubUtil.APPLICATION_VND_GITHUB_V_3_JSON);
        request.addQuerystringParameter("Authorization", "Bearer " + authUtil.getAccessToken());
        authUtil.getoAuthService().signRequest(authUtil.getAccessToken(), request);
        try (com.github.scribejava.core.model.Response response = authUtil.getoAuthService().execute(request)) {
            if (response.getCode() == 400) {
                throw new RuntimeException("Bad Request, Please enter correct required data. The response is " + response.getBody());
            }
            return Arrays.asList(GithubUtil.gson.fromJson(response.getBody(), GRepo[].class));
        }
    }

    public static List<CodeRepository> getRepo(OAuthUtil authUtil, String name) throws InterruptedException, ExecutionException, IOException {
        return getAllUserRepositories(authUtil).stream().filter(r -> r.name.toLowerCase().contains(name.trim().toLowerCase())).map(GRepo::to).collect(Collectors.toList());
    }

    public static List<CodeRepository> searchRepoByFullName(OAuthUtil authUtil, String fullName) throws InterruptedException, ExecutionException, IOException {
        return getAllUserRepositories(authUtil).stream().filter(r -> r.fullName.toLowerCase().contains(fullName.trim().toLowerCase())).map(GRepo::to).collect(Collectors.toList());
    }


    public static CodeRepository getRepoByFullName(OAuthUtil authUtil, String fullName) throws InterruptedException, ExecutionException, IOException {
        Map<String, String> request = new HashMap<>();
        String path = "/repos/" + fullName;
        return GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GRepo.class).to();
    }


    public static GRepo createRepository(OAuthUtil authUtil, CodeRepository repository)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("name", repository.name);
        body.put("description", repository.description);
        body.put("auto_init", true);
        body.put("delete_branch_on_merge", true);
        String path = "/user/repos";
        return GithubUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GRepo.class);
    }

    public static GRepo updateRepository(OAuthUtil authUtil, CodeRepository repository)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("name", repository.name);
        body.put("description", repository.description);
        body.put("auto_init", true);
        body.put("delete_branch_on_merge", true);
        String path = "/repos/" + repository.fullName;
        return GithubUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GRepo.class);
    }
}