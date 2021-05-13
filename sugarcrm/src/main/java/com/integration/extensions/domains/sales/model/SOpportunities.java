package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sales.Opportunity;
import com.integration.util.DatePlus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SOpportunities {

    @SerializedName("id")

    public String id;
    @SerializedName("name")

    public String name;
    @SerializedName("date_entered")

    public String dateEntered;
    @SerializedName("date_modified")

    public String dateModified;
    @SerializedName("modified_user_id")

    public String modifiedUserId;
    @SerializedName("modified_by_name")

    public String modifiedByName;
    @SerializedName("modified_user_link")

    public ModifiedUserLink modifiedUserLink;
    @SerializedName("created_by")

    public String createdBy;
    @SerializedName("created_by_name")

    public String createdByName;
    @SerializedName("created_by_link")

    public CreatedByLink createdByLink;
    @SerializedName("description")

    public String description;
    @SerializedName("deleted")

    public Boolean deleted;
    @SerializedName("opportunity_type")

    public String opportunityType;
    @SerializedName("account_name")

    public String accountName;
    @SerializedName("accounts")

    public Accounts accounts;
    @SerializedName("account_id")

    public String accountId;
    @SerializedName("campaign_id")

    public String campaignId;
    @SerializedName("campaign_name")

    public String campaignName;
    @SerializedName("campaign_opportunities")

    public CampaignOpportunities campaignOpportunities;
    @SerializedName("lead_source")

    public String leadSource;
    @SerializedName("amount")

    public String amount;
    @SerializedName("amount_usdollar")

    public String amountUsdollar;
    @SerializedName("date_closed")

    public String dateClosed;
    @SerializedName("date_closed_timestamp")

    public Long dateClosedTimestamp;
    @SerializedName("next_step")

    public String nextStep;
    @SerializedName("sales_stage")

    public String salesStage;

    @SerializedName("sales_stage_cascade")
    public String salesStageCasacde;

    @SerializedName("sales_status")
    public String salesStatus;
    @SerializedName("probability")

    public Long probability;
    @SerializedName("best_case")

    public String bestCase;
    @SerializedName("worst_case")

    public String worstCase;
    @SerializedName("commit_stage")

    public String commitStage;
    @SerializedName("service_start_date")

    public String serviceStartDate;
    @SerializedName("service_open_revenue_line_items")

    public Integer serviceOpenRevenueLineItems;
    @SerializedName("total_revenue_line_items")

    public Integer totalRevenueLineItems;
    @SerializedName("closed_revenue_line_items")

    public Integer closedRevenueLineItems;
    @SerializedName("included_revenue_line_items")

    public Integer includedRevenueLineItems;
    @SerializedName("assigned_user_id")

    public String assignedUserId;
    @SerializedName("assigned_user_name")

    public String assignedUserName;
    @SerializedName("assigned_user_link")

    public AssignedUserLink assignedUserLink;


    public static class Accounts {

        @SerializedName("name")

        public String name;
        @SerializedName("id")

        public String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }


    public static class AssignedUserLink {

        @SerializedName("full_name")

        public String fullName;
        @SerializedName("id")

        public String id;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public static class CampaignOpportunities {

        @SerializedName("name")

        public String name;
        @SerializedName("id")

        public String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public static class CreatedByLink {

        @SerializedName("full_name")

        public String fullName;
        @SerializedName("id")

        public String id;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public static class ModifiedUserLink {

        @SerializedName("full_name")

        public String fullName;
        @SerializedName("id")

        public String id;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public static class Records {
        public SOpportunities[] records;
        public int next_offset;

        public List<Opportunity> to() {
            return Arrays.stream(records).map(SOpportunities::to).collect(Collectors.toList());
        }
    }

    public Opportunity toOpportunity() {
        Opportunity opportunity = new Opportunity();
        opportunity.id = this.id;
        if (this.dateEntered != null) {
            Date d = DatePlus.fromISO(this.dateEntered);
            opportunity.createdDate = d != null ? d.getTime() : null;
        }
        if (this.dateModified != null) {
            Date d = DatePlus.fromISO(this.dateModified);
            opportunity.lastModifiedDate = d != null ? d.getTime() : null;
        }
        opportunity.description = this.description;
        opportunity.expectedRevenue = this.bestCase;
        opportunity.ownerId = this.createdBy;
        opportunity.stageName = this.salesStage;
        opportunity.amount = this.amount;
        opportunity.probability = this.probability;
        opportunity.contactId = this.assignedUserId;
        opportunity.closeDate = this.dateClosedTimestamp;
        opportunity.name = this.name;
        return opportunity;
    }

    public static Opportunity to(SOpportunities sfOpportunity) {
        Opportunity opportunity = new Opportunity();
        opportunity.id = sfOpportunity.id;
        if (sfOpportunity.dateEntered != null) {
            Date d = DatePlus.fromISO(sfOpportunity.dateEntered);
            opportunity.createdDate = d != null ? d.getTime() : null;
        }
        if (sfOpportunity.dateModified != null) {
            Date d = DatePlus.fromISO(sfOpportunity.dateModified);
            opportunity.lastModifiedDate = d != null ? d.getTime() : null;
        }
        opportunity.description = sfOpportunity.description;
        opportunity.expectedRevenue = sfOpportunity.bestCase;
        opportunity.ownerId = sfOpportunity.createdBy;
        opportunity.stageName = sfOpportunity.salesStage;
        opportunity.amount = sfOpportunity.amount;
        opportunity.probability = sfOpportunity.probability;
        opportunity.contactId = sfOpportunity.assignedUserId;
        opportunity.closeDate = sfOpportunity.dateClosedTimestamp;
        opportunity.name = sfOpportunity.name;
        return opportunity;
    }

    public static SOpportunities from(Opportunity sfOpportunity) {
        SOpportunities opportunity = new SOpportunities();
        opportunity.id = sfOpportunity.id;
        if (sfOpportunity.lastModifiedDate != null)
            opportunity.dateModified = DatePlus.getISODate(new Date(sfOpportunity.lastModifiedDate));
        if (sfOpportunity.createdDate != null)
            opportunity.dateEntered = DatePlus.getISODate(new Date(sfOpportunity.createdDate));
        opportunity.name = sfOpportunity.name;
        opportunity.description = sfOpportunity.description;
        opportunity.bestCase = sfOpportunity.expectedRevenue;
        opportunity.createdBy = sfOpportunity.ownerId;
        opportunity.salesStage = sfOpportunity.stageName;
        opportunity.amount = sfOpportunity.amount;
        if(sfOpportunity.probability!=null)
        opportunity.probability = sfOpportunity.probability;
        opportunity.assignedUserId = sfOpportunity.contactId;
        if (sfOpportunity.closeDate!=null)
            opportunity.dateClosed = DatePlus.getISODate(new Date(sfOpportunity.closeDate));

        return opportunity;
    }

}