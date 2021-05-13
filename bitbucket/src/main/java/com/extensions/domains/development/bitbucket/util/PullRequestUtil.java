package com.extensions.domains.development.bitbucket.util;

import com.extensions.domains.development.PullRequest;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PullRequestUtil {

    public static List<PullRequest> getAll(RestClient client, String repositoryFullName) throws JSONException {
        return getAll(client, prepareUrl(repositoryFullName), 1);
    }

    public static PullRequest get(RestClient client, String repositoryFullName, String pullRequestId) throws JSONException {
        String url = prepareUrl(repositoryFullName) + "/" + pullRequestId;
        return parsePullRequest(client.get(url, Collections.emptyMap()));
    }

    public static void approve(RestClient client, String repositoryFullName, String pullRequestId) throws JSONException {
        String url = prepareUrl(repositoryFullName) + "/" + pullRequestId + "/approve";
        client.post(url, new JSONObject());
    }

    public static void decline(RestClient client, String repositoryFullName, String pullRequestId) throws JSONException {
        String url = prepareUrl(repositoryFullName) + "/" + pullRequestId + "/decline";
        client.post(url, new JSONObject());
    }

    public static void merge(RestClient client, String repositoryFullName, String pullRequestId) throws JSONException {
        String url = prepareUrl(repositoryFullName) + "/" + pullRequestId + "/merge";
        client.post(url, new JSONObject());
    }

    public static void addComment(RestClient client, String repositoryFullName, String pullRequestId, String comment) throws JSONException {
        String url = prepareUrl(repositoryFullName) + "/" + pullRequestId + "/comments";
        client.post(url, new JSONObject().put("content", new JSONObject().put("raw", comment)));
    }

    private static List<PullRequest> getAll(RestClient client, String path, int page) throws JSONException {
        JSONObject response = client.get(path, Collections.singletonMap("page", page));
        List<PullRequest> pullRequests = new ArrayList<>(response.optInt("size", 10));
        JSONArray values = response.getJSONArray("values");
        for (int i = 0; i < values.length(); i++) {
            pullRequests.add(parsePullRequest(values.getJSONObject(i)));
        }

        if (response.has("next")) {
            pullRequests.addAll(getAll(client, path, ++page));
        }
        return pullRequests;
    }

    private static PullRequest parsePullRequest(JSONObject json) throws JSONException {
        PullRequest pullRequest = new PullRequest();
        pullRequest.pullRequestId = json.getString("id");
        pullRequest.title = json.getString("title");
        pullRequest.description = json.getString("description");
        pullRequest.state = json.getString("state");
        pullRequest.author = json.getJSONObject("author").getString("display_name");

        if (json.has("reviewers")) {
            JSONArray reviewersJson = json.getJSONArray("reviewers");
            List<String> reviewers = new ArrayList<>(reviewersJson.length());
            for (int i = 0; i < reviewersJson.length(); i++) {
                reviewers.add(reviewersJson.getJSONObject(i).getString("display_name"));
            }
            pullRequest.reviewers = reviewers;
        }
        return pullRequest;
    }

    private static String prepareUrl(String repositoryFullName) {
        return RepositoryUtil.prepareUrl(repositoryFullName) + "/" + "pullrequests";
    }


    public static PullRequest createPR(RestClient client, String repositoryFullName, String title, String srcBranchName, String destBranchName) throws JSONException {
        JSONObject body = new JSONObject();
        body.put("title", title);
        body.put("source", getBranchJsonObject(srcBranchName));
        body.put("destination", getBranchJsonObject(destBranchName));
       // addReviewers(client, repositoryFullName, body);
        JSONObject res = client.post(prepareUrl(repositoryFullName), body);
        return parsePullRequest(res);
    }

    public static void addReviewers(RestClient client, String repositoryFullName, JSONObject body) throws JSONException {
        List<UserUtil.User> users = UserUtil.getDefaultReviewers(client, repositoryFullName);
        if (users.size() > 0) {
            JSONArray jsonArray = new JSONArray();
            users.forEach(user -> {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("uuid", user.uuid);
                    jsonArray.put(jsonObject);
                } catch (JSONException e) {
                }
            });
            body.put("reviewers", jsonArray);
        }
    }

    private static JSONObject getBranchJsonObject(String branchName) throws JSONException {
        JSONObject branch = new JSONObject();
        branch.put("name", branchName);
        JSONObject body = new JSONObject();
        body.put("branch", branch);
        return body;
    }
}
