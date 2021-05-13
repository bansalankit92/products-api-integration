package com.extensions.domains.development.util;

import com.extensions.domains.development.model.GBranches;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BranchUtil {


    public static List<GBranches> getBranches(OAuthUtil authUtil, String fullName, String branchName)
            throws IOException, ExecutionException, InterruptedException {

        Map<String, String> request = new HashMap<>();
        request.put("search", branchName);
        String path = "projects/" + GitlabUtil.getFullName(fullName) + "/repository/branches";
        String branches = OAuthUtil.get(authUtil, path, request);
        return Arrays.asList(GitlabUtil.gson.fromJson(branches, GBranches[].class));
    }

    public static List<GBranches> getAllBranches(OAuthUtil authUtil, String fullName)
            throws IOException, ExecutionException, InterruptedException {
        return getBranches(authUtil, fullName, "");
    }


    public static GBranches getBranch(OAuthUtil authUtil, String fullName, String branchName)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> request = new HashMap<>();
        String path = "projects/" + GitlabUtil.getFullName(fullName) + "/repository/branches/"+branchName;
        return GitlabUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GBranches.class);
    }


    public static GBranches createBranch(OAuthUtil authUtil, String fullName, String oldBranchName, String newBranchName)
            throws IOException, ExecutionException, InterruptedException {
        String path = "projects/" + GitlabUtil.getFullName(fullName) + "/repository/branches";
        Map<String, Object> body = new HashMap<>();
        body.put("ref",  oldBranchName);
        body.put("branch",newBranchName);
        return GitlabUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GBranches.class);
    }
}