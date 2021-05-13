package com.extensions.domains.development.util;

import com.extensions.domains.development.model.GReference;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BranchUtil {


    public static List<GReference> getBranches(OAuthUtil authUtil, String fullName, String branchName, int page, int size)
            throws IOException, ExecutionException, InterruptedException {

        Map<String, String> request = new HashMap<>();
        request.put("per_page", String.valueOf(size));
        request.put("page", String.valueOf(page));
        String path = "/repos/" + fullName + "/git/matching-refs/heads/" + branchName;
        return Arrays.asList(GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GReference[].class));
    }

    public static List<GReference> getTags(OAuthUtil authUtil, String fullName, String branchName, int page, int size)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> request = new HashMap<>();
        request.put("per_page", String.valueOf(size));
        request.put("page", String.valueOf(page));
        String path = "/repos/" + fullName + "/git/matching-refs/tags/" + branchName;
        return Arrays.asList(GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GReference[].class));
    }

    public static List<GReference> getAllBranches(OAuthUtil authUtil, String fullName)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> request = new HashMap<>();
        String path = "/repos/" + fullName + "/git/matching-refs/heads/";
        return Arrays.asList(GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GReference[].class));
    }

    public static List<GReference> getBranches(OAuthUtil authUtil, String fullName, String branchName)
              throws IOException, ExecutionException, InterruptedException {

          Map<String, String> request = new HashMap<>();
          String path = "/repos/" + fullName + "/git/matching-refs/heads/"+branchName;
          return Arrays.asList(GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GReference[].class));

      }

    public static List<GReference> getAllTags(OAuthUtil authUtil, String fullName)
            throws IOException, ExecutionException, InterruptedException {

        Map<String, String> request = new HashMap<>();
        String path = "/repos/" + fullName + "/git/matching-refs/tags/";
        return Arrays.asList(GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GReference[].class));

    }

    public static GReference getBranch(OAuthUtil authUtil, String fullName, String branchName)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> request = new HashMap<>();
        String path = "/repos/" + fullName + "/git/ref/heads/" + branchName;
        return GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GReference.class);
    }

    public static GReference getTag(OAuthUtil authUtil, String fullName, String branchName)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> request = new HashMap<>();
        String path = "/repos/" + fullName + "/git/ref/tags/" + branchName;
        return GithubUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GReference.class);
    }

    public static GReference createBranch(OAuthUtil authUtil, String fullName, String oldBranchName, String newBranchName)
            throws IOException, ExecutionException, InterruptedException {
        String path = "/repos/" + fullName + "/git/refs";
        Map<String, Object> body = new HashMap<>();
        body.put("ref", "refs/heads/"+newBranchName);
        GReference reference = getBranch(authUtil, fullName, oldBranchName);
        body.put("sha", reference.object.sha);
        return GithubUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GReference.class);
    }
}