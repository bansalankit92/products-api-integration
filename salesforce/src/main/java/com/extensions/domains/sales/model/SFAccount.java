package com.extensions.domains.sales.model;

import java.util.Date;
import com.extensions.domains.sales.Account;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class SFAccount {

    @SerializedName("AccountNumber")
    public String accountNumber;

    @SerializedName("Ownership")
    public String ownership;

    @SerializedName("CreatedDate")
    public Date createdDate;

    @SerializedName("Website")
    public String website;

    @SerializedName("SLAExpirationDate")
    public String sLAExpirationDate;

    @SerializedName("Name")
    public String name;

    @SerializedName("Industry")
    public String industry;

    @SerializedName("NumberOfEmployees")
    public String numberOfEmployees;

    @SerializedName("BillingCity")
    public String billingCity;

    @SerializedName("OwnerId")
    public String ownerId;

    @SerializedName("ShippingStreet")
    public String shippingStreet;

    @SerializedName("Phone")
    public String phone;

    @SerializedName("SLASerialNumber")
    public String sLASerialNumber;

    @SerializedName("ShippingState")
    public String shippingState;

    @SerializedName("CreatedById")
    public String createdById;

    @SerializedName("BillingState")
    public String billingState;

    @SerializedName("ShippingCity")
    public String shippingCity;

    @SerializedName("BillingCountry")
    public String billingCountry;

    @SerializedName("Sic")
    public String sic;

    @SerializedName("ShippingCountry")
    public String shippingCountry;

    @SerializedName("ShippingPostalCode")
    public String shippingPostalCode;

    @SerializedName("Type")
    public String type;

    @SerializedName("BillingStreet")
    public String billingStreet;

    @SerializedName("BillingPostalCode")
    public String billingPostalCode;

    @SerializedName("CustomerPriority")
    public String customerPriority;

    @SerializedName("CleanStatus")
    public String cleanStatus;

    @SerializedName("Id")
    public String id;

    @SerializedName("Fax")
    public String fax;

    @SerializedName("AnnualRevenue")
    public Double annualRevenue;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

    public static Account to(SFAccount sfAccount) {
        Account account = new Account();

        account.accountNumber = sfAccount.accountNumber;
        account.ownership = sfAccount.ownership;
        account.createdDate = sfAccount.createdDate.getTime();
        account.website = sfAccount.website;
        account.sLAExpirationDate = sfAccount.sLAExpirationDate;
        account.name = sfAccount.name;
        account.industry = sfAccount.industry;
        account.numberOfEmployees = sfAccount.numberOfEmployees;
        account.billingCity = sfAccount.billingCity;
        account.ownerId = sfAccount.ownerId;
        account.shippingStreet = sfAccount.shippingStreet;
        account.phone = sfAccount.phone;
        account.sLASerialNumber = sfAccount.sLASerialNumber;
        account.shippingState = sfAccount.shippingState;
        account.createdById = sfAccount.createdById;
        account.billingState = sfAccount.billingState;
        account.shippingCity = sfAccount.shippingCity;
        account.billingCountry = sfAccount.billingCountry;
        account.sic = sfAccount.sic;
        account.shippingCountry = sfAccount.shippingCountry;
        account.shippingPostalCode = sfAccount.shippingPostalCode;
        account.type = sfAccount.type;
        account.billingStreet = sfAccount.billingStreet;
        account.billingPostalCode = sfAccount.billingPostalCode;
        account.customerPriority = sfAccount.customerPriority;
        account.cleanStatus = sfAccount.cleanStatus;
        account.id = sfAccount.id;
        account.fax = sfAccount.fax;
        account.annualRevenue = sfAccount.annualRevenue;
        return account;
    }

    public static SFAccount from(Account sfAccount) {
        SFAccount account = new SFAccount();

        account.accountNumber = sfAccount.accountNumber;
        account.ownership = sfAccount.ownership;
        if (sfAccount.createdDate != null) {
            account.createdDate = new Date(sfAccount.createdDate);
        }
        account.website = sfAccount.website;
        account.sLAExpirationDate = sfAccount.sLAExpirationDate;
        account.name = sfAccount.name;
        account.industry = sfAccount.industry;
        account.numberOfEmployees = sfAccount.numberOfEmployees;
        account.billingCity = sfAccount.billingCity;
        account.ownerId = sfAccount.ownerId;
        account.shippingStreet = sfAccount.shippingStreet;
        account.phone = sfAccount.phone;
        account.sLASerialNumber = sfAccount.sLASerialNumber;
        account.shippingState = sfAccount.shippingState;
        account.createdById = sfAccount.createdById;
        account.billingState = sfAccount.billingState;
        account.shippingCity = sfAccount.shippingCity;
        account.billingCountry = sfAccount.billingCountry;
        account.sic = sfAccount.sic;
        account.shippingCountry = sfAccount.shippingCountry;
        account.shippingPostalCode = sfAccount.shippingPostalCode;
        account.type = sfAccount.type;
        account.billingStreet = sfAccount.billingStreet;
        account.billingPostalCode = sfAccount.billingPostalCode;
        account.customerPriority = sfAccount.customerPriority;
        account.cleanStatus = sfAccount.cleanStatus;
        account.id = sfAccount.id;
        account.fax = sfAccount.fax;
        account.annualRevenue = sfAccount.annualRevenue;
        return account;
    }

}
