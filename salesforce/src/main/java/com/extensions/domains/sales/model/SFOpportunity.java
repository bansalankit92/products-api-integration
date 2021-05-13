package com.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.extensions.domains.sales.Opportunity;
import com.extensions.domains.sales.util.DatePlus;

import java.util.Date;

public class SFOpportunity {
    @SerializedName("LastModifiedDate")
    public Date lastModifiedDate;

    @SerializedName("Description")
    public String description;

    @SerializedName("ExpectedRevenue")
    public String expectedRevenue;

    @SerializedName("OwnerId")
    public String ownerId;

    @SerializedName("StageName")
    public String stageName;

    @SerializedName("Amount")
    public String amount;

    @SerializedName("Probability")
    public String probability;

    @SerializedName("CreatedDate")
    public Date createdDate;

    @SerializedName("Id")
    public String id;

    @SerializedName("ContactId")
    public String contactId;

    @SerializedName("AccountId")
      public String accountId;

    @SerializedName("CloseDate")
    public String closeDate;

    @SerializedName("Name")
    public String name;

    @SerializedName("Pricebook2Id")
    public String Pricebook2Id;

    public static Opportunity to(SFOpportunity sfOpportunity) {
        Opportunity opportunity = new Opportunity();
        opportunity.id = sfOpportunity.id;
        opportunity.lastModifiedDate = sfOpportunity.lastModifiedDate.getTime();
        opportunity.description = sfOpportunity.description;
        opportunity.expectedRevenue = sfOpportunity.expectedRevenue;
        opportunity.ownerId = sfOpportunity.ownerId;
        opportunity.stageName = sfOpportunity.stageName;
        opportunity.amount = sfOpportunity.amount;
        opportunity.probability = sfOpportunity.probability;
        opportunity.accountId = sfOpportunity.accountId;
        opportunity.createdDate = sfOpportunity.createdDate.getTime();
        opportunity.contactId = sfOpportunity.contactId;
        opportunity.Pricebook2Id = sfOpportunity.Pricebook2Id;
        Date cd = DatePlus.fromYYYYMMDD(sfOpportunity.closeDate);
        opportunity.closeDate = cd != null ? cd.getTime() : null;
        opportunity.name = sfOpportunity.name;
        return opportunity;
    }

    public static SFOpportunity from(Opportunity sfOpportunity) {
        SFOpportunity opportunity = new SFOpportunity();
        opportunity.id = sfOpportunity.id;
        if (sfOpportunity.lastModifiedDate != null)
            opportunity.lastModifiedDate = new Date(sfOpportunity.lastModifiedDate);
        opportunity.description = sfOpportunity.description;
        opportunity.expectedRevenue = sfOpportunity.expectedRevenue;
        opportunity.ownerId = sfOpportunity.ownerId;
        opportunity.stageName = sfOpportunity.stageName;
        opportunity.amount = sfOpportunity.amount;
        opportunity.accountId = sfOpportunity.accountId;
        opportunity.Pricebook2Id = sfOpportunity.Pricebook2Id;
        opportunity.probability = sfOpportunity.probability;
        if (sfOpportunity.createdDate != null)
            opportunity.createdDate = new Date(sfOpportunity.createdDate);
        opportunity.contactId = sfOpportunity.contactId;
        if (sfOpportunity.closeDate > 0)
            opportunity.closeDate = DatePlus.getYYYYMMDD(sfOpportunity.closeDate);
        opportunity.name = sfOpportunity.name;
        return opportunity;
    }
}