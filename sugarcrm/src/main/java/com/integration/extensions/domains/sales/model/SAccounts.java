package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sales.Account;
import com.integration.util.DatePlus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SAccounts {

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
    @SerializedName("facebook")
    private String facebook;
    @SerializedName("twitter")
    private String twitter;
    @SerializedName("googleplus")
    private String googleplus;
    @SerializedName("account_type")
    private String accountType;
    @SerializedName("industry")
    private String industry;
    @SerializedName("annual_revenue")
    private String annualRevenue;
    @SerializedName("phone_fax")
    private String phoneFax;
    @SerializedName("billing_address_street")
    private String billingAddressStreet;
    @SerializedName("billing_address_street_2")
    private String billingAddressStreet2;
    @SerializedName("billing_address_street_3")
    private String billingAddressStreet3;
    @SerializedName("billing_address_street_4")
    private String billingAddressStreet4;
    @SerializedName("billing_address_city")
    private String billingAddressCity;
    @SerializedName("billing_address_state")
    private String billingAddressState;
    @SerializedName("billing_address_postalcode")
    private String billingAddressPostalcode;
    @SerializedName("billing_address_country")
    private String billingAddressCountry;
    @SerializedName("rating")
    private String rating;
    @SerializedName("phone_office")
    private String phoneOffice;
    @SerializedName("phone_alternate")
    private String phoneAlternate;
    @SerializedName("website")
    private String website;
    @SerializedName("ownership")
    private String ownership;
    @SerializedName("employees")
    private String employees;
    @SerializedName("ticker_symbol")
    private String tickerSymbol;
    @SerializedName("shipping_address_street")
    private String shippingAddressStreet;
    @SerializedName("shipping_address_street_2")
    private String shippingAddressStreet2;
    @SerializedName("shipping_address_street_3")
    private String shippingAddressStreet3;
    @SerializedName("shipping_address_street_4")
    private String shippingAddressStreet4;
    @SerializedName("shipping_address_city")
    private String shippingAddressCity;
    @SerializedName("shipping_address_state")
    private String shippingAddressState;
    @SerializedName("shipping_address_postalcode")
    private String shippingAddressPostalcode;
    @SerializedName("shipping_address_country")
    private String shippingAddressCountry;
    @SerializedName("service_level")
    private String serviceLevel;
    @SerializedName("parent_id")
    private String parentId;
    @SerializedName("sic_code")
    private String sicCode;
    @SerializedName("duns_num")
    private String dunsNum;
    @SerializedName("parent_name")
    private String parentName;
    @SerializedName("campaign_id")
    private String campaignId;
    @SerializedName("campaign_name")
    private String campaignName;
    @SerializedName("next_renewal_date")
    private String nextRenewalDate;
    @SerializedName("widget_next_renewal_date")
    private String widgetNextRenewalDate;
    @SerializedName("following")
    private Boolean following;
    @SerializedName("my_favorite")
    private Boolean myFavorite;
    @SerializedName("tag")
    private List<Object> tag = null;
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
    @SerializedName("invalid_email")
    private Boolean invalidEmail;
    @SerializedName("email_opt_out")
    private Boolean emailOptOut;
    @SerializedName("email_addresses_non_primary")
    private String emailAddressesNonPrimary;
    @SerializedName("latitude_c")
    private String latitudeC;
    @SerializedName("longitude_c")
    private String longitudeC;

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getPhoneFax() {
        return phoneFax;
    }

    public void setPhoneFax(String phoneFax) {
        this.phoneFax = phoneFax;
    }

    public String getBillingAddressStreet() {
        return billingAddressStreet;
    }

    public void setBillingAddressStreet(String billingAddressStreet) {
        this.billingAddressStreet = billingAddressStreet;
    }

    public String getBillingAddressStreet2() {
        return billingAddressStreet2;
    }

    public void setBillingAddressStreet2(String billingAddressStreet2) {
        this.billingAddressStreet2 = billingAddressStreet2;
    }

    public String getBillingAddressStreet3() {
        return billingAddressStreet3;
    }

    public void setBillingAddressStreet3(String billingAddressStreet3) {
        this.billingAddressStreet3 = billingAddressStreet3;
    }

    public String getBillingAddressStreet4() {
        return billingAddressStreet4;
    }

    public void setBillingAddressStreet4(String billingAddressStreet4) {
        this.billingAddressStreet4 = billingAddressStreet4;
    }

    public String getBillingAddressCity() {
        return billingAddressCity;
    }

    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }

    public String getBillingAddressState() {
        return billingAddressState;
    }

    public void setBillingAddressState(String billingAddressState) {
        this.billingAddressState = billingAddressState;
    }

    public String getBillingAddressPostalcode() {
        return billingAddressPostalcode;
    }

    public void setBillingAddressPostalcode(String billingAddressPostalcode) {
        this.billingAddressPostalcode = billingAddressPostalcode;
    }

    public String getBillingAddressCountry() {
        return billingAddressCountry;
    }

    public void setBillingAddressCountry(String billingAddressCountry) {
        this.billingAddressCountry = billingAddressCountry;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPhoneOffice() {
        return phoneOffice;
    }

    public void setPhoneOffice(String phoneOffice) {
        this.phoneOffice = phoneOffice;
    }

    public String getPhoneAlternate() {
        return phoneAlternate;
    }

    public void setPhoneAlternate(String phoneAlternate) {
        this.phoneAlternate = phoneAlternate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getShippingAddressStreet() {
        return shippingAddressStreet;
    }

    public void setShippingAddressStreet(String shippingAddressStreet) {
        this.shippingAddressStreet = shippingAddressStreet;
    }

    public String getShippingAddressStreet2() {
        return shippingAddressStreet2;
    }

    public void setShippingAddressStreet2(String shippingAddressStreet2) {
        this.shippingAddressStreet2 = shippingAddressStreet2;
    }

    public String getShippingAddressStreet3() {
        return shippingAddressStreet3;
    }

    public void setShippingAddressStreet3(String shippingAddressStreet3) {
        this.shippingAddressStreet3 = shippingAddressStreet3;
    }

    public String getShippingAddressStreet4() {
        return shippingAddressStreet4;
    }

    public void setShippingAddressStreet4(String shippingAddressStreet4) {
        this.shippingAddressStreet4 = shippingAddressStreet4;
    }

    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    public String getShippingAddressState() {
        return shippingAddressState;
    }

    public void setShippingAddressState(String shippingAddressState) {
        this.shippingAddressState = shippingAddressState;
    }

    public String getShippingAddressPostalcode() {
        return shippingAddressPostalcode;
    }

    public void setShippingAddressPostalcode(String shippingAddressPostalcode) {
        this.shippingAddressPostalcode = shippingAddressPostalcode;
    }

    public String getShippingAddressCountry() {
        return shippingAddressCountry;
    }

    public void setShippingAddressCountry(String shippingAddressCountry) {
        this.shippingAddressCountry = shippingAddressCountry;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    public String getDunsNum() {
        return dunsNum;
    }

    public void setDunsNum(String dunsNum) {
        this.dunsNum = dunsNum;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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

    public String getNextRenewalDate() {
        return nextRenewalDate;
    }

    public void setNextRenewalDate(String nextRenewalDate) {
        this.nextRenewalDate = nextRenewalDate;
    }

    public String getWidgetNextRenewalDate() {
        return widgetNextRenewalDate;
    }

    public void setWidgetNextRenewalDate(String widgetNextRenewalDate) {
        this.widgetNextRenewalDate = widgetNextRenewalDate;
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

    public List<Object> getTag() {
        return tag;
    }

    public void setTag(List<Object> tag) {
        this.tag = tag;
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

    public Boolean getInvalidEmail() {
        return invalidEmail;
    }

    public void setInvalidEmail(Boolean invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    public Boolean getEmailOptOut() {
        return emailOptOut;
    }

    public void setEmailOptOut(Boolean emailOptOut) {
        this.emailOptOut = emailOptOut;
    }

    public String getEmailAddressesNonPrimary() {
        return emailAddressesNonPrimary;
    }

    public void setEmailAddressesNonPrimary(String emailAddressesNonPrimary) {
        this.emailAddressesNonPrimary = emailAddressesNonPrimary;
    }

    public String getLatitudeC() {
        return latitudeC;
    }

    public void setLatitudeC(String latitudeC) {
        this.latitudeC = latitudeC;
    }

    public String getLongitudeC() {
        return longitudeC;
    }

    public void setLongitudeC(String longitudeC) {
        this.longitudeC = longitudeC;
    }


    public static class Records {
           public SAccounts[] records;
           public int next_offset;

           public List<Account> to() {
               return Arrays.stream(records).map(SAccounts::to).collect(Collectors.toList());
           }
       }

    public Account to() {
        Account account = new Account();
        account.name = name;
        account.accountNumber = dunsNum;
        account.ownership = ownership;
        if (this.dateEntered != null)
            account.createdDate = DatePlus.fromISO(this.dateEntered).getTime();
        account.website = website;
        //account.sLAExpirationDate = ;
        account.name = name;
        account.industry = industry;
        account.numberOfEmployees = employees;
        account.billingCity = billingAddressCity;
        account.ownerId = assignedUserId;
        account.shippingStreet = shippingAddressStreet;
        account.phone = phoneOffice;
        //account.sLASerialNumber;
        account.shippingState = shippingAddressState;
        account.createdById = createdBy;
        account.billingState = billingAddressState;
        account.shippingCity = shippingAddressCity;
        account.billingCountry = billingAddressCountry;
        account.sic = sicCode;
        account.shippingCountry = shippingAddressCountry;
        account.shippingPostalCode = shippingAddressPostalcode;
        account.type = accountType;
        account.billingStreet = billingAddressStreet;
        account.billingPostalCode = billingAddressPostalcode;
        account.customerPriority = rating;
        //    account.cleanStatus = st;
        account.id = id;
        account.fax = phoneFax;
        account.annualRevenue = annualRevenue;
        return account;
    }

    public static SAccounts from(Account account) {
        SAccounts saccount = new SAccounts();
        saccount.name = account.name;
        saccount.dunsNum = account.accountNumber;
        saccount.ownership = account.ownership;
        saccount.website = account.website;
        //account.sLAExpirationDate = ;
        saccount.industry = account.industry;
        saccount.employees = account.numberOfEmployees;
        saccount.billingAddressCity = account.billingCity;
        saccount.assignedUserId = account.ownerId;
        saccount.shippingAddressStreet = account.shippingStreet;
        saccount.phoneOffice = account.phone;
        //account.sLASerialNumber;
        saccount.shippingAddressState = account.shippingState;
        saccount.createdBy = account.createdById;
        saccount.billingAddressState = account.billingState;
        saccount.shippingAddressCity = account.shippingCity;
        saccount.billingAddressCountry = account.billingCountry;
        saccount.sicCode = account.sic;
        saccount.shippingAddressCountry = account.shippingCountry;
        saccount.shippingAddressPostalcode = account.shippingPostalCode;
        saccount.accountType = account.type;
        saccount.billingAddressStreet = account.billingStreet;
        saccount.billingAddressPostalcode = account.billingPostalCode;
        saccount.rating = account.customerPriority;
        //    account.cleanStatus = st;
        saccount.id = account.id;
        saccount.phoneFax = account.fax;
        saccount.annualRevenue = account.annualRevenue;
        return saccount;
    }
}