package com.extensions.domains.development.jira.util.vos;

import com.extensions.domains.development.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraUser {

    public String accountId;
    public String displayName;
    public String accountType;
    public String emailId;

    public JiraUser(String accountId, String displayName, String accountType, String emailId) {
        this.accountId = accountId;
        this.displayName = displayName;
        this.accountType = accountType;
        this.emailId = emailId;
    }

    public static JiraUser create(JSONObject projectObject) throws JSONException {
        return new JiraUser(
                (String)projectObject.get("accountId"),
                (String)projectObject.get("displayName"),
                (String)projectObject.get("accountType"),
                projectObject.has("emailAddress") ?(String)projectObject.get("emailAddress"):""
        );
    }

    public String summary() {
        return displayName;
    }

    public User getUser() {
        User userFinal = new User();
        userFinal.accountId = this.accountId;
        userFinal.accountType = this.accountType;
        userFinal.email = this.emailId;
        userFinal.name = this.displayName;
        return userFinal;
    }

}
