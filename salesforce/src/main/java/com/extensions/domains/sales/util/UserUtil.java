package com.extensions.domains.sales.util;

import com.extensions.domains.sales.CreateRecordResponse;
import com.extensions.domains.sales.User;
import com.extensions.domains.sales.model.Me;
import com.extensions.domains.sales.model.SFUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class UserUtil {
    private static Gson gson = new Gson();
    private OAuthUtil authUtil;
    public static final String USER = "User";

    private UserUtil(Map<String, Object> attributes) {
        this.authUtil = new OAuthUtil(attributes);
    }


    public static List<User> getUserByName(SalesforceUtil salesforceUtil, String name) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select id, Name, CompanyName, Email, Username, MobilePhone from User where name LIKE '%" +
                        name + "%'");
        SalesforceListResponse<SFUser> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFUser>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFUser::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


    public static List<User> getUsers(SalesforceUtil salesforceUtil, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select id, Name, CompanyName, Email, Username, MobilePhone from User ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFUser> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFUser>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFUser::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<User> getUserByName(SalesforceUtil salesforceUtil, String name, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select id, Name, CompanyName, Email, Username, MobilePhone from User where name LIKE '%" +
                        name + "%' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFUser> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFUser>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFUser::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<User> getUserByUserName(SalesforceUtil salesforceUtil, String userName, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select id, Name, CompanyName, Email, Username, MobilePhone from User where username LIKE '%" +
                        userName + "%' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFUser> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFUser>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFUser::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<User> getUserByEmail(SalesforceUtil salesforceUtil, String email, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select id, Name, CompanyName, Email, Username, MobilePhone from User where Email LIKE '%" +
                        email + "%' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFUser> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFUser>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFUser::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


    public static User getUserById(SalesforceUtil salesforceUtil, String opportunityId) throws InterruptedException, ExecutionException, IOException {
        return SFUser.to(gson.fromJson(salesforceUtil.getRecordById(opportunityId, USER), SFUser.class));
    }

    public static CreateRecordResponse addUser(SalesforceUtil salesforceUtil, User opportunity) throws InterruptedException, ExecutionException, IOException {
        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(opportunity), USER), CreateRecordResponse.class);
    }

    public static User getMe(SalesforceUtil salesforceUtil) throws InterruptedException, ExecutionException, IOException {
        String me = salesforceUtil.getMe();
        return Me.to(gson.fromJson(me, Me.class));
    }

}