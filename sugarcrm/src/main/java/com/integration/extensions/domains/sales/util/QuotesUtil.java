package com.integration.extensions.domains.sales.util;

import com.integration.extensions.domains.sales.Quote;
import com.integration.extensions.domains.sales.model.Me;
import com.integration.extensions.domains.sales.model.SQuotes;
import com.integration.util.RestClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuotesUtil {
    public static final String QUOTES = "Quotes";

    public static List<Quote> getQuoteByName(SugarcrmUtil util, String opportunityName) throws IOException {
        String res = util.search(QUOTES, "name", opportunityName);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuoteByName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(QUOTES, "name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuoteByDescription(SugarcrmUtil util, String opportunityDescription, long size, long page) throws IOException {
        String res = util.search(QUOTES, "description", opportunityDescription, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuotes(SugarcrmUtil util, long size, long page) throws IOException {
        String res = util.get(QUOTES, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuotesByOpportunityName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(QUOTES, "opportunity_name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuotesByNameAndOpportunityName(SugarcrmUtil util, String name, String opportunityName, long size, long page) throws IOException {
        Map<String, String> map = new HashMap<>();
        if (name != null) map.put("name", name);
        if (opportunityName != null) map.put("opportunity_name", opportunityName);
        String res = util.search(QUOTES, map, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuotesByNameAndOpportunityId(SugarcrmUtil util, String name, String opportunityId, long size, long page) throws IOException {
        Map<String, String> map = new HashMap<>();
        if (name != null) map.put("name", name);
        if (opportunityId != null) map.put("opportunity_id", opportunityId);
        String res = util.search(QUOTES, map, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }


    public static List<Quote> getQuoteByStatus(SugarcrmUtil util, String opportunityStatus, long size, long page) throws IOException {
        String res = util.search(QUOTES, "sales_stage", opportunityStatus, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuoteByStatus(SugarcrmUtil util, String opportunityStatus) throws IOException {
        String res = util.search(QUOTES, "sales_stage", opportunityStatus);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();
    }

    public static List<Quote> getQuoteByOwnerID(SugarcrmUtil util, String ownerID, long size, long page) throws IOException {
        String res = util.search(QUOTES, "created_by", ownerID, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();

    }

    public static List<Quote> getQuoteByAccountId(SugarcrmUtil util, String accountId, long size, long page) throws IOException {
        String res = util.search(QUOTES, "account_id", accountId, page, size);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();

    }

    public static List<Quote> getQuoteByAssignedUser(SugarcrmUtil util, String assignedUserId) throws IOException {
        String res = util.search(QUOTES, "assigned_user_id", assignedUserId);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();

    }


    public static List<Quote> getMyQuote(SugarcrmUtil util) throws IOException {
        Me.CurrentUser c = RestClient.gson.fromJson(util.getMe(), Me.CurrentUser.class);
        String res = util.search(QUOTES, "assigned_user_id", c.currentUser.id);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();

    }

    public static List<Quote> getQuoteByAccountId(SugarcrmUtil util, String accountId) throws IOException {
        String res = util.search(QUOTES, "account_id", accountId);
        return RestClient.gson.fromJson(res, SQuotes.Records.class).to();

    }

    public static Quote getQuoteById(SugarcrmUtil util, String id) throws IOException {
        return SQuotes.to(RestClient.gson.fromJson(util.getById(QUOTES, id), SQuotes.class));
    }

    public static Quote addQuote(SugarcrmUtil util, Quote opportunity) {
        return SQuotes.to(RestClient.gson.fromJson(util.post(QUOTES, RestClient.gson.toJson(SQuotes.from(opportunity))), SQuotes.class));
    }

    public static Quote updateQuote(SugarcrmUtil util, Quote updatedQuote) throws IOException, IllegalAccessException {
        if (updatedQuote.id == null || updatedQuote.id.isEmpty())
            throw new RuntimeException("Quote Id cant be empty");
        SQuotes updatedopportunity = SQuotes.from(updatedQuote);
        return SQuotes.to(RestClient.gson.fromJson(util.put(QUOTES, updatedopportunity.id, RestClient.gson.toJson(updatedopportunity)), SQuotes.class));

    }

}