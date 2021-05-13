package com.integration.extensions.domains.sales.util;

import com.integration.extensions.domains.sales.Lead;
import com.integration.extensions.domains.sales.model.Me;
import com.integration.extensions.domains.sales.model.SLeads;
import com.integration.util.DatePlus;
import com.integration.util.RestClient;

import java.io.IOException;
import java.util.List;

public class LeadUtil {
    public static final String LEADS = "Leads";

    public static List<Lead> getLeadByName(SugarcrmUtil util, String opportunityName) throws IOException {
        String res = util.search(LEADS, "name", opportunityName);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();
    }

    public static List<Lead> getLeadByName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(LEADS, "name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();
    }

    public static List<Lead> getLeadByDescription(SugarcrmUtil util, String opportunityDescription, long size, long page) throws IOException {
        String res = util.search(LEADS, "description", opportunityDescription, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();
    }

    public static List<Lead> getLeads(SugarcrmUtil util, long size, long page) throws IOException {
        String res = util.get(LEADS, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();
    }

    public static List<Lead> getLeadByStatus(SugarcrmUtil util, String opportunityStatus, long size, long page) throws IOException {
        String res = util.search(LEADS, "sales_stage", opportunityStatus, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();
    }

    public static List<Lead> getLeadByOpportunityName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(LEADS, "opportunity_name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();
    }

    public static List<Lead> getLeadByStatus(SugarcrmUtil util, String opportunityStatus) throws IOException {
        String res = util.search(LEADS, "sales_stage", opportunityStatus);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();
    }

    public static List<Lead> getLeadByOwnerID(SugarcrmUtil util, String ownerID, long size, long page) throws IOException {
        String res = util.search(LEADS, "created_by", ownerID, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();

    }

    public static List<Lead> getLeadByAccountId(SugarcrmUtil util, String accountId, long size, long page) throws IOException {
        String res = util.search(LEADS, "account_id", accountId, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();

    }

    public static List<Lead> getLeadByAssignedUser(SugarcrmUtil util, String assignedUserId, long size, long page) throws IOException {
        String res = util.search(LEADS, "assigned_user_id", assignedUserId, page, size);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();

    }

    public static List<Lead> getLeadByAssignedUser(SugarcrmUtil util, String assignedUserId) throws IOException {
        String res = util.search(LEADS, "assigned_user_id", assignedUserId);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();

    }

    public static List<Lead> getLeadByTime(SugarcrmUtil util, long startTime) throws IOException {
        String res = util.greaterThen(LEADS, "date_entered", DatePlus.getISODate(startTime));
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();

    }


    public static List<Lead> getMyLead(SugarcrmUtil util) throws IOException {
        Me.CurrentUser c = RestClient.gson.fromJson(util.getMe(), Me.CurrentUser.class);
        String res = util.search(LEADS, "assigned_user_id", c.currentUser.id);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();

    }

    public static List<Lead> getLeadByAccountId(SugarcrmUtil util, String accountId) throws IOException {
        String res = util.search(LEADS, "account_id", accountId);
        return RestClient.gson.fromJson(res, SLeads.Records.class).to();

    }

    public static Lead getLeadById(SugarcrmUtil util, String id) throws IOException {
        return SLeads.to(RestClient.gson.fromJson(util.getById(LEADS, id), SLeads.class));
    }

    public static Lead addLead(SugarcrmUtil util, Lead opportunity) {
        return SLeads.to(RestClient.gson.fromJson(util.post(LEADS, RestClient.gson.toJson(SLeads.from(opportunity))), SLeads.class));
    }

    public static Lead updateLead(SugarcrmUtil util, Lead updatedLead) throws IOException, IllegalAccessException {
        if (updatedLead.id == null || updatedLead.id.isEmpty())
            throw new RuntimeException("Lead Id cant be empty");
        SLeads updatedopportunity = SLeads.from(updatedLead);
        return SLeads.to(RestClient.gson.fromJson(util.put(LEADS, updatedopportunity.getId(), RestClient.gson.toJson(updatedopportunity)), SLeads.class));

    }

}