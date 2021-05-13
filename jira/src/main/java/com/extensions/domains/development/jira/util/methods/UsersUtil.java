package com.extensions.domains.development.jira.util.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.extensions.domains.development.User;
import com.extensions.domains.development.jira.util.vos.JiraUser;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class UsersUtil {
    public static List<User> getAllUsers(RestClient client) throws Exception {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("maxResults", 150);
        String jsonResponse = client.fetch("users", queryParams, String.class);
        List<User> finalResponse = new ArrayList<>();
        try {
            JSONArray userArray = new JSONArray(jsonResponse);
            for (int i = 0; i < userArray.length(); i++) {
                JiraUser user = JiraUser.create(userArray.getJSONObject(i));
                finalResponse.add(user.getUser());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return finalResponse;
    }

    public static List<JiraUser> searchUser(RestClient client, String query) throws Exception {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("query", query);
        String jsonResponse = client.fetch("user/search", queryParams, String.class);
        try {
            List<JiraUser> users = new ArrayList<>();
            JSONArray userArray = new JSONArray(jsonResponse);
            for (int i = 0; i < userArray.length(); i++) {
                users.add(JiraUser.create(userArray.getJSONObject(i)));
            }
            return users;
        } catch (JSONException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static JiraUser getUser(RestClient client, String query) throws Exception {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("query", query);
        String jsonResponse = client.fetch("user/search", queryParams, String.class);
        try {
            JSONArray userArray = new JSONArray(jsonResponse);
            return JiraUser.create(userArray.getJSONObject(0));
        } catch (JSONException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static User searchUserFinal(RestClient client, String query) throws Exception {
        JiraUser user = getUser(client, query);
        return user.getUser();
    }

    public static List<User> getUsersByQuery(RestClient client, String query) throws Exception {
        return searchUser(client, query).stream().map(JiraUser::getUser).collect(Collectors.toList());
    }

    public static User getUserByAccountId(RestClient client, String accountId) throws Exception {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("accountId", accountId);
        String jsonResponse = client.fetch("user", queryParams, String.class);
        try {
            return JiraUser.create(new JSONObject(jsonResponse)).getUser();
        } catch (JSONException e) {
            throw new Exception(e.getMessage());
        }
    }

}
