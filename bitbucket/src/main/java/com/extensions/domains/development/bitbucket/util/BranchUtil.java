package com.extensions.domains.development.bitbucket.util;

import com.extensions.domains.development.CodeRepositoryBranch;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.extensions.domains.development.bitbucket.util.RepositoryUtil.REPOSITORIES;

public class BranchUtil {

    public static String getRawBranches(RestClient client, String fullname, Long page) throws JSONException {
        JSONObject responseJson = client.get(prepareUrl(fullname), Collections.singletonMap("page", page));
        return responseJson.toString();
    }

    public static String getRawBranch(RestClient client, String repofullname, String branchName) throws JSONException {
        JSONObject responseJson = client.get(prepareUrl(repofullname, branchName), new HashMap<>());
        return responseJson.toString();
    }

    public static String prepareUrl(String repositoryFullName) {
        return REPOSITORIES + "/" + repositoryFullName + "/refs/branches";
    }

    public static String prepareUrl(String repositoryFullName, String branchName) {
        return REPOSITORIES + "/" + repositoryFullName + "/refs/branches/" + branchName;
    }

    private static CodeRepositoryBranch parseBranch(JSONObject json) throws JSONException {
        CodeRepositoryBranch branch = new CodeRepositoryBranch();
        try {
            branch.name = json.optString("name");
            if (json.has("target")) {
                branch.message = json.optJSONObject("target").optString("message");
                branch.hash = json.optJSONObject("target").optString("hash");
                branch.type = json.optJSONObject("target").optString("type");
                branch.repositoryName = json.optJSONObject("target").optJSONObject("repository").optString("name");
                branch.repositoryFullName = json.optJSONObject("target").optJSONObject("repository").optString("full_name");
                branch.authorNickname = json.optJSONObject("target").optJSONObject("author").optJSONObject("user").optString("nickname");
            }
        } catch (Exception ignore) {

        }
        return branch;
    }

    public static CodeRepositoryBranch createBranch(RestClient restClient, String repoFullName, String fromBranch, String newBranchName) throws JSONException {
        JSONObject target = new JSONObject();
        target.put("hash", fromBranch);
        JSONObject body = new JSONObject();
        body.put("target", target);
        body.put("name", newBranchName);
        JSONObject res = restClient.post(prepareUrl(repoFullName), body);
        return parseBranch(res);
    }

    public static List<CodeRepositoryBranch> getBranches(RestClient restClient, String repositoryFullname, Long page) throws JSONException {
        List<CodeRepositoryBranch> branches = new ArrayList<>();
        JSONArray values = new JSONObject(getRawBranches(restClient, repositoryFullname, page)).getJSONArray("values");
        for (int i = 0; i < values.length(); i++) {
            branches.add(parseBranch(values.optJSONObject(i)));
        }
        return branches;
    }

    public static CodeRepositoryBranch getBranch(RestClient restClient, String repositoryFullname, String branchName) throws JSONException {
        return parseBranch(new JSONObject(getRawBranch(restClient, repositoryFullname, branchName)));
    }
}
