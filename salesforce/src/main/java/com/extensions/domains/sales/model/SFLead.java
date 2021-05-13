package com.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.extensions.domains.sales.Lead;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class SFLead {
    @SerializedName("Status")
    public String status;

    @SerializedName("LastModifiedDate")
    public Date lastModifiedDate;

    @SerializedName("Company")
    public String company;

    @SerializedName("ConvertedContactId")
    public String convertedContactId;

    @SerializedName("Email")
    public String email;

    @SerializedName("Description")
    public String description;

    @SerializedName("CreatedDate")
    public Date createdDate;

    @SerializedName("Rating")
    public String rating;

    @SerializedName("Title")
    public String title;

    @SerializedName("Website")
    public String website;

    @SerializedName("AnnualRevenue")
    public String annualRevenue;

    @SerializedName("ConvertedOpportunityId")
    public String convertedOpportunityId;

    @SerializedName("MobilePhone")
    public String mobilePhone;

    @SerializedName("Name")
    public String name;

    @SerializedName("LastName")
    public String lastName;

    @SerializedName("FirstName")
    public String firstName;

    @SerializedName("ConvertedDate")
    public Date convertedDate;

    @SerializedName("ConvertedAccountId")
    public String convertedAccountId;

    @SerializedName("Industry")
    public String industry;

    @SerializedName("IsConverted")
    public Boolean isConverted;

    @SerializedName("OwnerId")
    public String ownerId;

    @SerializedName("LeadSource")
    public String leadSource;

    @SerializedName("CleanStatus")
    public String cleanStatus;

    @SerializedName("Phone")
    public String phone;

    @SerializedName("Id")
    public String id;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

    public static Lead to(SFLead sfLead) {
        Lead lead = new Lead();
        lead.id = sfLead.id;
        lead.lastModifiedDate = sfLead.lastModifiedDate != null ? sfLead.lastModifiedDate.getTime() : null;
        lead.description = sfLead.description;
        lead.ownerId = sfLead.ownerId;
        lead.createdDate = sfLead.createdDate != null ? sfLead.createdDate.getTime() : null;
        lead.name = sfLead.name;
        lead.isConverted = sfLead.isConverted;
        lead.annualRevenue = sfLead.annualRevenue;
        lead.cleanStatus = sfLead.cleanStatus;
        lead.company = sfLead.company;
        lead.convertedAccountId = sfLead.convertedAccountId;
        lead.convertedContactId = sfLead.convertedContactId;
        lead.convertedDate = sfLead.convertedDate != null ? sfLead.convertedDate.getTime() : null;
        lead.convertedOpportunityId = sfLead.convertedOpportunityId;
        lead.email = sfLead.email;
        lead.industry = sfLead.industry;
        lead.leadSource = sfLead.leadSource;
        lead.mobilePhone = sfLead.mobilePhone;
        lead.phone = sfLead.phone;
        lead.rating = sfLead.rating;
        lead.title = sfLead.title;
        lead.status = sfLead.status;
        lead.website = sfLead.website;
        return lead;
    }

    public static SFLead from(Lead sfLead) {
        SFLead lead = new SFLead();
        lead.id = sfLead.id;
        if (sfLead.lastModifiedDate != null)
            lead.lastModifiedDate = new Date(sfLead.lastModifiedDate);
        lead.description = sfLead.description;
        lead.ownerId = sfLead.ownerId;
        if (sfLead.createdDate != null)
            lead.createdDate = new Date(sfLead.createdDate);
        //lead.name = sfLead.name;
        lead.isConverted = sfLead.isConverted;
        lead.annualRevenue = sfLead.annualRevenue;
        lead.cleanStatus = sfLead.cleanStatus;
        lead.company = sfLead.company;
        lead.convertedAccountId = sfLead.convertedAccountId;
        lead.convertedContactId = sfLead.convertedContactId;
        if (sfLead.convertedDate != null)
            lead.convertedDate = new Date(sfLead.convertedDate);
        lead.convertedOpportunityId = sfLead.convertedOpportunityId;
        lead.email = sfLead.email;
        lead.industry = sfLead.industry;
        lead.leadSource = sfLead.leadSource;
        lead.mobilePhone = sfLead.mobilePhone;
        lead.phone = sfLead.phone;
        lead.rating = sfLead.rating;
        lead.title = sfLead.title;
        lead.status = sfLead.status;
        lead.website = sfLead.website;
        if (sfLead.name != null) {
            List<String> name = new ArrayList<>(Arrays.asList(sfLead.name.split("\\s+")));
            if (name.size() == 1)
                lead.lastName = sfLead.name;
            else {
                lead.firstName = name.get(0);
                name.remove(0);
                lead.lastName = String.join(" ", name);
            }
        }
        return lead;
    }

    //Id,LastName,FirstName,Salutation,Name,Title,Company,Address,Phone,MobilePhone,Fax,Email,Website,Description,LeadSource,Status,Industry,Rating,AnnualRevenue,NumberOfEmployees,OwnerId,IsConverted,ConvertedDate,ConvertedAccountId,ConvertedContactId,ConvertedOpportunityId,IsUnreadByOwner,CreatedDate,LastModifiedDate,CleanStatus"
}
