package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sales.Lead;
import com.integration.util.DatePlus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SLeads {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("date_entered")
    private String dateEntered;
    @SerializedName("date_modified")
    private String dateModified;
    @SerializedName("modified_user_id")
    private String modifiedUserId;
    @SerializedName("modified_by_name")
    private String modifiedByName;
    @SerializedName("created_by")
    private String createdBy;
    @SerializedName("created_by_name")
    private String createdByName;
    @SerializedName("description")
    private String description;
    @SerializedName("deleted")
    private Boolean deleted;
    @SerializedName("salutation")
    private String salutation;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("title")
    private String title;
    @SerializedName("facebook")
    private String facebook;
    @SerializedName("twitter")
    private String twitter;
    @SerializedName("googleplus")
    private String googleplus;
    @SerializedName("department")
    private String department;
    @SerializedName("do_not_call")
    private Boolean doNotCall;
    @SerializedName("phone_home")
    private String phoneHome;
    @SerializedName("phone_mobile")
    private String phoneMobile;
    @SerializedName("phone_work")
    private String phoneWork;
    @SerializedName("phone_other")
    private String phoneOther;
    @SerializedName("phone_fax")
    private String phoneFax;
    @SerializedName("primary_address_street")
    private String primaryAddressStreet;
    @SerializedName("primary_address_street_2")
    private String primaryAddressStreet2;
    @SerializedName("primary_address_street_3")
    private String primaryAddressStreet3;
    @SerializedName("primary_address_city")
    private String primaryAddressCity;
    @SerializedName("primary_address_state")
    private String primaryAddressState;
    @SerializedName("primary_address_postalcode")
    private String primaryAddressPostalcode;
    @SerializedName("primary_address_country")
    private String primaryAddressCountry;
    @SerializedName("alt_address_street")
    private String altAddressStreet;
    @SerializedName("alt_address_street_2")
    private String altAddressStreet2;
    @SerializedName("alt_address_street_3")
    private String altAddressStreet3;
    @SerializedName("alt_address_city")
    private String altAddressCity;
    @SerializedName("alt_address_state")
    private String altAddressState;
    @SerializedName("alt_address_postalcode")
    private String altAddressPostalcode;
    @SerializedName("alt_address_country")
    private String altAddressCountry;
    @SerializedName("assistant")
    private String assistant;
    @SerializedName("assistant_phone")
    private String assistantPhone;
    @SerializedName("picture")
    private String picture;
    @SerializedName("converted")
    private Boolean converted;
    @SerializedName("refered_by")
    private String referedBy;
    @SerializedName("lead_source")
    private String leadSource;
    @SerializedName("lead_source_description")
    private String leadSourceDescription;
    @SerializedName("status")
    private String status;
    @SerializedName("status_description")
    private String statusDescription;
    @SerializedName("reports_to_id")
    private String reportsToId;
    @SerializedName("report_to_name")
    private String reportToName;
    @SerializedName("dp_business_purpose")
    private List<Object> dpBusinessPurpose = null;
    @SerializedName("dp_consent_last_updated")
    private String dpConsentLastUpdated;
    @SerializedName("dnb_principal_id")
    private String dnbPrincipalId;
    @SerializedName("account_name")
    private String accountName;
    @SerializedName("account_to_lead")
    private String accountToLead;
    @SerializedName("account_description")
    private String accountDescription;
    @SerializedName("contact_id")
    private String contactId;
    @SerializedName("contact_name")
    private String contactName;
    @SerializedName("account_id")
    private String accountId;
    @SerializedName("opportunity_id")
    private String opportunityId;
    @SerializedName("converted_opp_name")
    private String convertedOppName;
    @SerializedName("opportunity_name")
    private String opportunityName;
    @SerializedName("opportunity_amount")
    private String opportunityAmount;
    @SerializedName("campaign_id")
    private String campaignId;
    @SerializedName("campaign_name")
    private String campaignName;
    @SerializedName("webtolead_email_opt_out")
    private String webtoleadEmailOptOut;
    @SerializedName("webtolead_invalid_email")
    private String webtoleadInvalidEmail;
    @SerializedName("birthdate")
    private String birthdate;
    @SerializedName("portal_name")
    private String portalName;
    @SerializedName("portal_app")
    private String portalApp;
    @SerializedName("website")
    private String website;
    @SerializedName("preferred_language")
    private String preferredLanguage;
    @SerializedName("mkto_sync")
    private Boolean mktoSync;
    @SerializedName("mkto_id")
    private Object mktoId;
    @SerializedName("mkto_lead_score")
    private Object mktoLeadScore;
    @SerializedName("following")
    private Boolean following;
    @SerializedName("my_favorite")
    private Boolean myFavorite;
    @SerializedName("locked_fields")
    private List<Object> lockedFields = null;
    @SerializedName("assigned_user_id")
    private String assignedUserId;
    @SerializedName("assigned_user_name")
    private String assignedUserName;
    @SerializedName("email1")
    private String email1;
    @SerializedName("email2")
    private String email2;
    @SerializedName("hint_account_annual_revenue_c")
    public String hintAnnualRevenue;
    @SerializedName("hint_account_industry_c")
    public String hintIndustry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public String getModifiedByName() {
        return modifiedByName;
    }

    public void setModifiedByName(String modifiedByName) {
        this.modifiedByName = modifiedByName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGoogleplus() {
        return googleplus;
    }

    public void setGoogleplus(String googleplus) {
        this.googleplus = googleplus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getDoNotCall() {
        return doNotCall;
    }

    public void setDoNotCall(Boolean doNotCall) {
        this.doNotCall = doNotCall;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getPhoneOther() {
        return phoneOther;
    }

    public void setPhoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
    }

    public String getPhoneFax() {
        return phoneFax;
    }

    public void setPhoneFax(String phoneFax) {
        this.phoneFax = phoneFax;
    }

    public String getPrimaryAddressStreet() {
        return primaryAddressStreet;
    }

    public void setPrimaryAddressStreet(String primaryAddressStreet) {
        this.primaryAddressStreet = primaryAddressStreet;
    }

    public String getPrimaryAddressStreet2() {
        return primaryAddressStreet2;
    }

    public void setPrimaryAddressStreet2(String primaryAddressStreet2) {
        this.primaryAddressStreet2 = primaryAddressStreet2;
    }

    public String getPrimaryAddressStreet3() {
        return primaryAddressStreet3;
    }

    public void setPrimaryAddressStreet3(String primaryAddressStreet3) {
        this.primaryAddressStreet3 = primaryAddressStreet3;
    }

    public String getPrimaryAddressCity() {
        return primaryAddressCity;
    }

    public void setPrimaryAddressCity(String primaryAddressCity) {
        this.primaryAddressCity = primaryAddressCity;
    }

    public String getPrimaryAddressState() {
        return primaryAddressState;
    }

    public void setPrimaryAddressState(String primaryAddressState) {
        this.primaryAddressState = primaryAddressState;
    }

    public String getPrimaryAddressPostalcode() {
        return primaryAddressPostalcode;
    }

    public void setPrimaryAddressPostalcode(String primaryAddressPostalcode) {
        this.primaryAddressPostalcode = primaryAddressPostalcode;
    }

    public String getPrimaryAddressCountry() {
        return primaryAddressCountry;
    }

    public void setPrimaryAddressCountry(String primaryAddressCountry) {
        this.primaryAddressCountry = primaryAddressCountry;
    }

    public String getAltAddressStreet() {
        return altAddressStreet;
    }

    public void setAltAddressStreet(String altAddressStreet) {
        this.altAddressStreet = altAddressStreet;
    }

    public String getAltAddressStreet2() {
        return altAddressStreet2;
    }

    public void setAltAddressStreet2(String altAddressStreet2) {
        this.altAddressStreet2 = altAddressStreet2;
    }

    public String getAltAddressStreet3() {
        return altAddressStreet3;
    }

    public void setAltAddressStreet3(String altAddressStreet3) {
        this.altAddressStreet3 = altAddressStreet3;
    }

    public String getAltAddressCity() {
        return altAddressCity;
    }

    public void setAltAddressCity(String altAddressCity) {
        this.altAddressCity = altAddressCity;
    }

    public String getAltAddressState() {
        return altAddressState;
    }

    public void setAltAddressState(String altAddressState) {
        this.altAddressState = altAddressState;
    }

    public String getAltAddressPostalcode() {
        return altAddressPostalcode;
    }

    public void setAltAddressPostalcode(String altAddressPostalcode) {
        this.altAddressPostalcode = altAddressPostalcode;
    }

    public String getAltAddressCountry() {
        return altAddressCountry;
    }

    public void setAltAddressCountry(String altAddressCountry) {
        this.altAddressCountry = altAddressCountry;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }

    public void setAssistantPhone(String assistantPhone) {
        this.assistantPhone = assistantPhone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getConverted() {
        return converted;
    }

    public void setConverted(Boolean converted) {
        this.converted = converted;
    }

    public String getReferedBy() {
        return referedBy;
    }

    public void setReferedBy(String referedBy) {
        this.referedBy = referedBy;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getLeadSourceDescription() {
        return leadSourceDescription;
    }

    public void setLeadSourceDescription(String leadSourceDescription) {
        this.leadSourceDescription = leadSourceDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getReportsToId() {
        return reportsToId;
    }

    public void setReportsToId(String reportsToId) {
        this.reportsToId = reportsToId;
    }

    public String getReportToName() {
        return reportToName;
    }

    public void setReportToName(String reportToName) {
        this.reportToName = reportToName;
    }

    public List<Object> getDpBusinessPurpose() {
        return dpBusinessPurpose;
    }

    public void setDpBusinessPurpose(List<Object> dpBusinessPurpose) {
        this.dpBusinessPurpose = dpBusinessPurpose;
    }

    public String getDpConsentLastUpdated() {
        return dpConsentLastUpdated;
    }

    public void setDpConsentLastUpdated(String dpConsentLastUpdated) {
        this.dpConsentLastUpdated = dpConsentLastUpdated;
    }

    public String getDnbPrincipalId() {
        return dnbPrincipalId;
    }

    public void setDnbPrincipalId(String dnbPrincipalId) {
        this.dnbPrincipalId = dnbPrincipalId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountToLead() {
        return accountToLead;
    }

    public void setAccountToLead(String accountToLead) {
        this.accountToLead = accountToLead;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getConvertedOppName() {
        return convertedOppName;
    }

    public void setConvertedOppName(String convertedOppName) {
        this.convertedOppName = convertedOppName;
    }

    public String getOpportunityName() {
        return opportunityName;
    }

    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }

    public String getOpportunityAmount() {
        return opportunityAmount;
    }

    public void setOpportunityAmount(String opportunityAmount) {
        this.opportunityAmount = opportunityAmount;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getWebtoleadEmailOptOut() {
        return webtoleadEmailOptOut;
    }

    public void setWebtoleadEmailOptOut(String webtoleadEmailOptOut) {
        this.webtoleadEmailOptOut = webtoleadEmailOptOut;
    }

    public String getWebtoleadInvalidEmail() {
        return webtoleadInvalidEmail;
    }

    public void setWebtoleadInvalidEmail(String webtoleadInvalidEmail) {
        this.webtoleadInvalidEmail = webtoleadInvalidEmail;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPortalName() {
        return portalName;
    }

    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    public String getPortalApp() {
        return portalApp;
    }

    public void setPortalApp(String portalApp) {
        this.portalApp = portalApp;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Boolean getMktoSync() {
        return mktoSync;
    }

    public void setMktoSync(Boolean mktoSync) {
        this.mktoSync = mktoSync;
    }

    public Object getMktoId() {
        return mktoId;
    }

    public void setMktoId(Object mktoId) {
        this.mktoId = mktoId;
    }

    public Object getMktoLeadScore() {
        return mktoLeadScore;
    }

    public void setMktoLeadScore(Object mktoLeadScore) {
        this.mktoLeadScore = mktoLeadScore;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public Boolean getMyFavorite() {
        return myFavorite;
    }

    public void setMyFavorite(Boolean myFavorite) {
        this.myFavorite = myFavorite;
    }

    public List<Object> getLockedFields() {
        return lockedFields;
    }

    public void setLockedFields(List<Object> lockedFields) {
        this.lockedFields = lockedFields;
    }

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getAssignedUserName() {
        return assignedUserName;
    }

    public void setAssignedUserName(String assignedUserName) {
        this.assignedUserName = assignedUserName;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }


    public static Lead to(SLeads sLeads) {
        Lead lead = new Lead();
        lead.id = sLeads.id;
        lead.description = sLeads.description;
        if (sLeads.dateEntered != null) {
            Date d = DatePlus.fromISO(sLeads.dateEntered);
            lead.createdDate = d != null ? d.getTime() : null;
        }
        if (sLeads.dateModified != null) {
            Date d = DatePlus.fromISO(sLeads.dateModified);
            lead.lastModifiedDate = d != null ? d.getTime() : null;
        }
        lead.ownerId = sLeads.assignedUserId;
        lead.name = sLeads.name;
        lead.isConverted = sLeads.converted;
        lead.annualRevenue = sLeads.hintAnnualRevenue;
        lead.cleanStatus = sLeads.status;
        // lead.company = sLeads.company;
        lead.convertedAccountId = sLeads.accountId;
        lead.convertedContactId = sLeads.contactId;
        // lead.convertedDate = sLeads.da != null ? sLeads.convertedDate.getTime() : null;
        lead.convertedOpportunityId = sLeads.opportunityId;
        lead.email = sLeads.email1;
        lead.industry = sLeads.hintIndustry;
        lead.leadSource = sLeads.leadSource;
        lead.mobilePhone = sLeads.phoneMobile;
        lead.phone = sLeads.phoneWork;
        // lead.rating = sLeads.;
        lead.title = sLeads.title;
        lead.status = sLeads.status;
        lead.website = sLeads.website;
        return lead;
    }

    public static SLeads from(Lead sLeads) {
        SLeads lead = new SLeads();

        lead.id = sLeads.id;
        lead.description = sLeads.description;
        if (sLeads.lastModifiedDate != null)
            lead.dateModified = DatePlus.getISODate(new Date(sLeads.lastModifiedDate));
        if (sLeads.createdDate != null)
            lead.dateEntered = DatePlus.getISODate(new Date(sLeads.createdDate));

        lead.assignedUserId = sLeads.ownerId;
        lead.name = sLeads.name;
        lead.converted = sLeads.isConverted;
        lead.hintAnnualRevenue = sLeads.annualRevenue;
        lead.status = sLeads.cleanStatus;
        // lead.company = sLeads.company;
        lead.accountId = sLeads.convertedAccountId;
        lead.contactId = sLeads.convertedContactId;
        // lead.convertedDate = sLeads.da != null ? sLeads.convertedDate.getTime() : null;
        lead.opportunityId = sLeads.convertedOpportunityId;
        lead.email1 = sLeads.email;
        lead.hintIndustry = sLeads.industry;
        lead.leadSource = sLeads.leadSource;
        lead.phoneMobile = sLeads.mobilePhone;
        lead.phoneWork = sLeads.phone;
        // lead.rating = sLeads.;
        lead.title = sLeads.title;
        lead.status = sLeads.status;
        lead.website = sLeads.website;
        if (sLeads.name != null) {
            List<String> name = new ArrayList<>(Arrays.asList(sLeads.name.split("\\s+")));
            if (name.size() == 1)
                lead.lastName = sLeads.name;
            else {
                lead.firstName = name.get(0);
                name.remove(0);
                lead.lastName = String.join(" ", name);
            }
        }
        return lead;
    }

    public static class Records {
           public SLeads[] records;
           public int next_offset;

           public List<Lead> to() {
               return Arrays.stream(records).map(SLeads::to).collect(Collectors.toList());
           }
       }
}