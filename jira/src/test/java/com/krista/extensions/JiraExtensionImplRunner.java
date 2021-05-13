package com.krista.extensions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.extensions.domains.development.jira.util.methods.*;
import com.extensions.domains.development.jira.util.vos.JiraUser;
import com.google.gson.Gson;

import static com.extensions.domains.development.jira.util.methods.OAuthUtil.*;

//https://developer.atlassian.com/cloud/jira/platform/oauth-2-authorization-code-grants-3lo-for-apps/
// app created via https://developer.atlassian.com/apps/
public class JiraExtensionImplRunner {

    // https://developer.atlassian.com/cloud/jira/platform/rest/v3/#api-rest-api-3-issue-issueIdOrKey-comment-post
    public static void main(String[] args) throws Exception {
        attributes.put(AUTH_TOKEN, "JiHmsSmrA9vHieDOUaGmE1F2");
        attributes.put(USER_NAME, "gaurav@antbrains.com");
        attributes.put(HOST_URL, "https://antbrains.atlassian.net/rest/api/3");
        RestClient restClient;

        //demo2 app by demo user gmail login
        // client id: BpK5UysSPiStnt5PFxXftndSYvtD8v
        // client secret: mE3s-VrjiVVoJBHQxI6PmzCx86U0i8etUZm18GYhiB5FZL3SOfZdSAxTyDs_k8

        // ankit's app
        attributes.put(CLIENT_ID, "gZLNAstJRgV4ZPSQ0y7zkJGePb4Dt3");
        attributes.put(CLIENT_SECRET, "QwY8wuMReTBpJoV3kqd1tLwAS_nlNJaXXsk3cxwSfTWp1toqGyUNb0XAqXX1je");
        attributes.put(CALLBACK_URI, "http://localhost:8081/rpc/v1/extension/oauth");
        // ankit's jira
        attributes.put(REFRESH_TOKEN, "ECaoHvQPkKgT7ndvqPbWqePmU2RTb8yIVkyJGPvJ97_");
        restClient = new Oauth2RestClient(attributes);
         restClient = new AuthRestClient("gaurav@antbrains.com","JiHmsSmrA9vHieDOUaGmE1F2"
                ,"https://atlassian.net/rest/api/3");

        //restClient = new AuthRestClient(getValue(USER_NAME),
        //        getValue(AUTH_TOKEN),
        //        getValue(HOST_URL));

        String projectKey = "DEVSEC";

        System.out.println(DatePlus.getYYYYMMDD(1600680888000l));
        //  impl.addDueDate("EC-98",1600680888000l);

        System.out.println(new Gson().toJson(ProjectsUtil.getAllProjects(restClient)));

        List<JiraUser> u =UsersUtil.searchUser(restClient,"Ankit Bansal");
        System.out.println(new Gson().toJson(u));

//        String jql = new JQLBuilder()
//                       .issueType(null)
//                .orderBy("priority","desc")
//                       .build();
//        System.out.println(jql);

    }


    public static String getValue(String key) {
        Object value = (attributes.get(key));
        if (value == null) throw new RuntimeException("Please provide correct " + key);
        return String.valueOf(value);
    }

    public static String HOST_URL = "hostUrl";
    public static String USER_NAME = "AdminUserName";
    public static String AUTH_TOKEN = "AdminAuthToken";
    public static final String LOGICAL_NAME_FIELD = "logicalName";
    public static Map<String, Object> attributes = new HashMap<>();

}