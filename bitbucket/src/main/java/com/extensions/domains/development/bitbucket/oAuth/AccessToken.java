package com.extensions.domains.development.bitbucket.oAuth;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AccessToken {

    public final String access_token;
    public final String scopes;
    public final Long expires_in;
    public final String token_type;
    public final String refresh_token;
    public final String state;

    public AccessToken(String access_token, String scopes, Long expires_in, String token_type, String refresh_token, String state) {
        this.access_token = access_token;
        this.scopes = scopes;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.refresh_token = refresh_token;
        this.state = state;
    }

    public static AccessToken create(JSONObject json) throws JSONException {
        return new AccessToken(json.getString("access_token"),
                json.getString("scopes"),
                json.getLong("expires_in"),
                json.getString("token_type"),
                json.getString("refresh_token"),
                json.getString("state"));
    }
}
