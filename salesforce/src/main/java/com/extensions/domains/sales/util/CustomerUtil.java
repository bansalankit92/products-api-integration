package com.extensions.domains.sales.util;

import com.extensions.domains.sales.Account;
import com.extensions.domains.sales.CreateRecordResponse;
import com.extensions.domains.sales.model.SFAccount;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CustomerUtil {

    private static Gson gson = new Gson();
    private OAuthUtil authUtil;
    private SalesforceUtil salesforceUtil;
    public static final String ACCOUNT = "Account";
    private final String query = "id,createdDate,phone,type,website,Name,ownership,AccountNumber,Industry,NumberOfEmployees";

    public CustomerUtil(Map<String, Object> attributes) {
        this.authUtil = new OAuthUtil(attributes);
        this.salesforceUtil = new SalesforceUtil(attributes);
    }


    public List<Account> getAccountByName(String accountName) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select "+query+" from Account where name LIKE '%" +
                        accountName + "%'");
        SalesforceListResponse<SFAccount> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFAccount>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFAccount::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Account> getAccountByName(String accountName, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select "+query+" from Account where name LIKE '%" +
                        accountName + "%' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFAccount> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFAccount>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFAccount::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Account> getAccounts(long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select "+query+"  from Account  ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFAccount> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFAccount>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFAccount::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public void updateAccount(Account updatedAccount) throws InterruptedException, ExecutionException, IOException, IllegalAccessException {
        if (updatedAccount.id == null || updatedAccount.id.isEmpty())
            throw new RuntimeException("Account Id cant be empty");
        SFAccount updatedopportunity = SFAccount.from(updatedAccount);
        SFAccount oldOpportunity1 = SFAccount.from(getAccountById(updatedopportunity.id));
        Map<String, String> diff = SalesforceUtil.getDifference(oldOpportunity1, updatedopportunity);
        salesforceUtil.updateRecord(updatedopportunity.id, gson.toJson(diff), ACCOUNT);
    }

    public Account getAccountById(String opportunityId) throws InterruptedException, ExecutionException, IOException {
        return SFAccount.to(gson.fromJson(salesforceUtil.getRecordById(opportunityId, ACCOUNT), SFAccount.class));
    }

    public CreateRecordResponse addAccount(Account opportunity) throws InterruptedException, ExecutionException, IOException {
        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(SFAccount.from(opportunity)), ACCOUNT), CreateRecordResponse.class);
    }

}