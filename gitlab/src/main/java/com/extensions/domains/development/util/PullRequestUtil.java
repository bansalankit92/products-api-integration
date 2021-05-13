package com.extensions.domains.development.util;

import com.extensions.domains.development.PullRequest;
import com.extensions.domains.development.model.GPR;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class PullRequestUtil {

    public static List<GPR> getGPRs(OAuthUtil authUtil, String title)
            throws IOException, ExecutionException, InterruptedException {

        Map<String, String> request = new HashMap<>();
        request.put("search", title);
        request.put("sort", "desc");
        request.put("order_by", "updated_at");
        request.put("state", "opened");
        String path = "merge_requests";
        String pr = OAuthUtil.get(authUtil, path, request);
        return  Arrays.asList(GitlabUtil.gson.fromJson(pr, GPR[].class));
    }

    public static List<GPR> getGPRs(OAuthUtil authUtil,String repoFullname, String title)
                throws IOException, ExecutionException, InterruptedException {

            Map<String, String> request = new HashMap<>();
            request.put("search", title);
            request.put("sort", "desc");
            request.put("order_by", "updated_at");
            request.put("state", "opened");
            String path = "projects/" + GitlabUtil.getFullName(repoFullname)+ "/merge_requests";
            String pr = OAuthUtil.get(authUtil, path, request);
            return  Arrays.asList(GitlabUtil.gson.fromJson(pr, GPR[].class));
        }

    public static GPR getPR(OAuthUtil authUtil, String fullName, int prNumber)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> request = new HashMap<>();
        String path = "projects/" + GitlabUtil.getFullName(fullName)+ "/merge_requests/"+prNumber;
        return GitlabUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GPR.class);
    }

    public static GPR createPR(OAuthUtil authUtil, String repofullName, String title, String fromBranchName, String toBranchName, String desc)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("title", title);
        body.put("source_branch", fromBranchName);
        body.put("target_branch", toBranchName);
        body.put("description", desc);
        String path = "projects/" + GitlabUtil.getFullName(repofullName)+ "/merge_requests";
        return GitlabUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GPR.class);
    }
    
    public static GPR mergePR(OAuthUtil authUtil, String repoFullName, int prNumber, String commitMessage)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("merge_commit_message", commitMessage);
        String path = "projects/" + GitlabUtil.getFullName(repoFullName)+ "/merge_requests/"+prNumber+ "/merge";
        return GitlabUtil.gson.fromJson(OAuthUtil.put(authUtil, path, body), GPR.class);
    }

    public static List<PullRequest> getPRs(OAuthUtil authUtil, String fullName)
            throws IOException, ExecutionException, InterruptedException {
        return getGPRs(authUtil,fullName,"").stream().map(GPR::to).collect(Collectors.toList());
    }




}