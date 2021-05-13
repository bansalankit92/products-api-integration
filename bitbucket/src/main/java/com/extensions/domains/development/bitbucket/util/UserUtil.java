package com.extensions.domains.development.bitbucket.util;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserUtil {

    static class User {
        public String uuid, account_id, displayName, nickname;

        public User(String uuid, String account_id, String displayName, String nickname) {
            this.uuid = uuid;
            this.account_id = account_id;
            this.displayName = displayName;
            this.nickname = nickname;
        }
    }

    public static List<User> getDefaultReviewers(RestClient client, String repositoryFullName) throws JSONException {
        List<User> users = new ArrayList<>();

        String url = RepositoryUtil.prepareUrl(repositoryFullName) + "/" + "default-reviewers";
        JSONObject res = (client.get(url, Collections.emptyMap()));
        JSONArray values = res.optJSONArray("values");
        try {
            for (int i = 0; i < values.length(); i++) {
                users.add(parseUser(values.getJSONObject(i)));
            }
        }catch (Exception ignore){}
        return users;
    }

    private static User parseUser(JSONObject json) throws JSONException {
        return new User(json.getString("uuid"),
                json.getString("account_id"),
                json.getString("display_name"),
                json.getString("nickname"));
    }

}