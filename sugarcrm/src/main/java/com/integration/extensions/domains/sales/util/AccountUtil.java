package com.integration.extensions.domains.sales.util;

import com.integration.extensions.domains.sales.Account;
import com.integration.extensions.domains.sales.model.Me;
import com.integration.extensions.domains.sales.model.SAccounts;
import com.integration.util.RestClient;

import java.io.IOException;
import java.util.List;

public class AccountUtil {
    public static final String ACCOUNTS = "Accounts";

    public static List<Account> getAccountByName(SugarcrmUtil util, String opportunityName) throws IOException {
        String res = util.search(ACCOUNTS, "name", opportunityName);
        return RestClient.gson.fromJson(res, SAccounts.Records.class).to();
    }

    public static List<Account> getAccountByName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(ACCOUNTS, "name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SAccounts.Records.class).to();
    }

    public static List<Account> getAccountByDescription(SugarcrmUtil util, String opportunityDescription, long size, long page) throws IOException {
        String res = util.search(ACCOUNTS, "description", opportunityDescription, page, size);
        return RestClient.gson.fromJson(res, SAccounts.Records.class).to();
    }

    public static List<Account> getAccounts(SugarcrmUtil util, long size, long page) throws IOException {
        String res = util.get(ACCOUNTS, page, size);
        return RestClient.gson.fromJson(res, SAccounts.Records.class).to();
    }


    public static List<Account> getAccountByOwnerID(SugarcrmUtil util, String ownerID, long size, long page) throws IOException {
        String res = util.search(ACCOUNTS, "created_by", ownerID, page, size);
        return RestClient.gson.fromJson(res, SAccounts.Records.class).to();

    }

    public static List<Account> getAccountByAssignedUser(SugarcrmUtil util, String assignedUserId,long size, long page) throws IOException {
           String res = util.search(ACCOUNTS, "assigned_user_id", assignedUserId, page, size);
           return RestClient.gson.fromJson(res, SAccounts.Records.class).to();

       }

    public static List<Account> getAccountByAssignedUser(SugarcrmUtil util, String assignedUserId) throws IOException {
        String res = util.search(ACCOUNTS, "assigned_user_id", assignedUserId);
        return RestClient.gson.fromJson(res, SAccounts.Records.class).to();

    }

    public static List<Account> getMyAccount(SugarcrmUtil util) throws IOException {
        Me.CurrentUser c = RestClient.gson.fromJson(util.getMe(), Me.CurrentUser.class);
        String res = util.search(ACCOUNTS, "assigned_user_id", c.currentUser.id);
        return RestClient.gson.fromJson(res, SAccounts.Records.class).to();

    }

   
    public static Account getAccountById(SugarcrmUtil util, String id) throws IOException {
        return RestClient.gson.fromJson(util.getById(ACCOUNTS, id), SAccounts.class).to();
    }

    public static Account addAccount(SugarcrmUtil util, Account opportunity) {
        return RestClient.gson.fromJson(util.post(ACCOUNTS, RestClient.gson.toJson(SAccounts.from(opportunity))), SAccounts.class).to();
    }

    public static Account updateAccount(SugarcrmUtil util, Account updatedAccount) throws IOException, IllegalAccessException {
        if (updatedAccount.id == null || updatedAccount.id.isEmpty())
            throw new RuntimeException("Account Id cant be empty");
        SAccounts updatedopportunity = SAccounts.from(updatedAccount);
       return RestClient.gson.fromJson(util.put(ACCOUNTS, updatedopportunity.getId(), RestClient.gson.toJson(updatedopportunity)), SAccounts.class).to();

    }

}