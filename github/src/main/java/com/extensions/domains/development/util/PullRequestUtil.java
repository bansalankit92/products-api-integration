package com.extensions.domains.development.util;

import com.extensions.domains.development.PullRequest;
import com.extensions.domains.development.model.GPR;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class PullRequestUtil {

    public static List<GPR> getPRs(OAuthUtil authUtil, String fullName, int page, int size)
            throws IOException, ExecutionException, InterruptedException {

        Map<String, String> request = new HashMap<>();
        request.put("per_page", String.valueOf(size));
        request.put("page", String.valueOf(page));
        request.put("sort", "created");
        request.put("state", "open");
        String path = "/repos/" + fullName + "/pulls";
        return Arrays.asList(GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GPR[].class));
    }

    public static GPR getPR(OAuthUtil authUtil, String fullName, int prNumber)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> request = new HashMap<>();
        String path = "/repos/" + fullName + "/pulls/" + prNumber;
        return GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GPR.class);
    }

    public static GPR createPR(OAuthUtil authUtil, String repofullName, String title, String fromBranchName, String toBranchName, String desc)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("title", title);
        body.put("head", fromBranchName);
        body.put("base", toBranchName);
        body.put("body", desc);
        String path = "/repos/" + repofullName + "/pulls";
        return GithubUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GPR.class);
    }


    public static GPR.Response mergePR(OAuthUtil authUtil, String repoFullName, int prNumber, String commitMessage)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("commit_title", commitMessage);
        String path = "/repos/" + repoFullName + "/pulls/" + prNumber + "/merge";
        return GithubUtil.gson.fromJson(OAuthUtil.put(authUtil, path, body), GPR.Response.class);
    }

    public static List<PullRequest> getPRs(OAuthUtil authUtil, String fullName)
            throws IOException, ExecutionException, InterruptedException {

        Map<String, String> request = new HashMap<>();
        request.put("sort", "created");
        request.put("state", "open");
        String path = "/repos/" + fullName + "/pulls";
        return Arrays.stream(GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GPR[].class)).map(GPR::to).collect(Collectors.toList());
    }

    public static GPR.Response approvePR(OAuthUtil authUtil, String repoFullName, int prNumber, String commitMessage)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("body", commitMessage);
        body.put("event", "APPROVE");
        String path = "/repos/" + repoFullName + "/pulls/" + prNumber + "/reviews";
        return GithubUtil.gson.fromJson(OAuthUtil.put(authUtil, path, body), GPR.Response.class);
    }

    public static GPR.Response declinePR(OAuthUtil authUtil, String repoFullName, int prNumber, String commitMessage)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("event", "REQUEST_CHANGES");
        body.put("body", commitMessage);
        String path = "/repos/" + repoFullName + "/pulls/" + prNumber + "/reviews";
        return GithubUtil.gson.fromJson(OAuthUtil.put(authUtil, path, body), GPR.Response.class);
    }


}