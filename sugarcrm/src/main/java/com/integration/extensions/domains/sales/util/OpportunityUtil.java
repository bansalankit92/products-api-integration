package com.integration.extensions.domains.sales.util;

import com.integration.extensions.domains.sales.Opportunity;
import com.integration.extensions.domains.sales.model.Me;
import com.integration.extensions.domains.sales.model.SOpportunities;
import com.integration.util.RestClient;

import java.io.IOException;
import java.util.List;

public class OpportunityUtil {
    public static final String OPPORTUNITY = "Opportunities";

    public static List<Opportunity> getOpportunityByName(SugarcrmUtil util, String opportunityName) throws IOException {
        String res = util.search(OPPORTUNITY, "name", opportunityName);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();
    }

    public static List<Opportunity> getOpportunityByName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(OPPORTUNITY, "name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();
    }

    public static List<Opportunity> getOpportunityByDescription(SugarcrmUtil util, String opportunityDescription, long size, long page) throws IOException {
        String res = util.search(OPPORTUNITY, "description", opportunityDescription, page, size);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();
    }

    public static List<Opportunity> getOpportunities(SugarcrmUtil util, long size, long page) throws IOException {
        String res = util.get(OPPORTUNITY, page, size);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();
    }

    public static List<Opportunity> getOpportunityByStatus(SugarcrmUtil util, String opportunityStatus, long size, long page) throws IOException {
        String res = util.search(OPPORTUNITY, "sales_stage", opportunityStatus, page, size);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();
    }

    public static List<Opportunity> getOpportunityByStatus(SugarcrmUtil util, String opportunityStatus) throws IOException {
        String res = util.search(OPPORTUNITY, "sales_stage", opportunityStatus);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();
    }

    public static List<Opportunity> getOpportunityByOwnerID(SugarcrmUtil util, String ownerID, long size, long page) throws IOException {
        String res = util.search(OPPORTUNITY, "created_by", ownerID, page, size);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();

    }

    public static List<Opportunity> getOpportunityByAccountId(SugarcrmUtil util, String accountId, long size, long page) throws IOException {
        String res = util.search(OPPORTUNITY, "account_id", accountId, page, size);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();

    }

    public static List<Opportunity> getOpportunityByAssignedUser(SugarcrmUtil util, String assignedUserId) throws IOException {
        String res = util.search(OPPORTUNITY, "assigned_user_id", assignedUserId);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();

    }


    public static List<Opportunity> getMyOpportunity(SugarcrmUtil util) throws IOException {
        Me.CurrentUser c = RestClient.gson.fromJson(util.getMe(), Me.CurrentUser.class);
        String res = util.search(OPPORTUNITY, "assigned_user_id", c.currentUser.id);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();

    }

    public static List<Opportunity> getOpportunityByAccountId(SugarcrmUtil util, String accountId) throws IOException {
        String res = util.search(OPPORTUNITY, "account_id", accountId);
        return RestClient.gson.fromJson(res, SOpportunities.Records.class).to();

    }

    public static Opportunity getOpportunityById(SugarcrmUtil util, String id) throws IOException {
        return RestClient.gson.fromJson(util.getById(OPPORTUNITY, id), SOpportunities.class).toOpportunity();
    }

    public static Opportunity addOpportunity(SugarcrmUtil util, Opportunity opportunity) {
        return RestClient.gson.fromJson(util.post(OPPORTUNITY, RestClient.gson.toJson(SOpportunities.from(opportunity))), SOpportunities.class).toOpportunity();
    }

    public static Opportunity updateOpportunity(SugarcrmUtil util, Opportunity updatedOpportunity) throws IOException, IllegalAccessException {
        if (updatedOpportunity.id == null || updatedOpportunity.id.isEmpty())
            throw new RuntimeException("Opportunity Id cant be empty");
        SOpportunities sOpportunities = SOpportunities.from(updatedOpportunity);
        sOpportunities.salesStageCasacde = sOpportunities.salesStage;
        String res = util.put(OPPORTUNITY, updatedOpportunity.id, RestClient.gson.toJson(sOpportunities));
        return RestClient.gson.fromJson(res, SOpportunities.class).toOpportunity();

    }

}