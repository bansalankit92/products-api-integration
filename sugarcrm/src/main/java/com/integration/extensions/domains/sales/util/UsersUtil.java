package com.integration.extensions.domains.sales.util;

import com.integration.extensions.domains.sales.User;
import com.integration.extensions.domains.sales.model.SUsers;
import com.integration.util.RestClient;

import java.io.IOException;
import java.util.List;

public class UsersUtil {
    public static final String USERS = "Users";

    public static List<User> getUserByName(SugarcrmUtil util, String opportunityName) throws IOException {
        String res = util.search(USERS, "name", opportunityName);
        return RestClient.gson.fromJson(res, SUsers.Records.class).to();
    }

    public static List<User> getUserByName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(USERS, "name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SUsers.Records.class).to();
    }

    public static List<User> getUsers(SugarcrmUtil util, long size, long page) throws IOException {
        String res = util.get(USERS, page, size);
        return RestClient.gson.fromJson(res, SUsers.Records.class).to();
    }

    public static User getUserById(SugarcrmUtil util, String id) throws IOException {
        return SUsers.to(RestClient.gson.fromJson(util.getById(USERS, id), SUsers.class));
    }

    public static User addUser(SugarcrmUtil util, User opportunity) {
        return SUsers.to( RestClient.gson.fromJson(util.post(USERS, RestClient.gson.toJson(SUsers.from(opportunity))), SUsers.class));
    }

    public static User updateUser(SugarcrmUtil util, User updatedUser) throws IOException, IllegalAccessException {
        if (updatedUser.id == null || updatedUser.id.isEmpty())
            throw new RuntimeException("User Id cant be empty");
        SUsers updatedopportunity = SUsers.from(updatedUser);
         return SUsers.to(RestClient.gson.fromJson(util.put(USERS, updatedopportunity.id, RestClient.gson.toJson(updatedopportunity)), SUsers.class));

    }

}