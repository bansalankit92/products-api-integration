package com.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;


public final class Account {
    @SerializedName("Account Number")
    public String accountNumber;

    @SerializedName("Ownership")
    public String ownership;

    @SerializedName("Created Date")
    public Long createdDate;

    @SerializedName("Website")
    public String website;

    @SerializedName("SLA Expiration Date")
    public String sLAExpirationDate;

    @SerializedName("Name")
    public String name;

    @SerializedName("Industry")
    public String industry;

    @SerializedName("Number Of Employees")
    public String numberOfEmployees;

    @SerializedName("Billing City")
    public String billingCity;

    @SerializedName("Owner Id")
    public String ownerId;

    @SerializedName("Shipping Street")
    public String shippingStreet;

    @SerializedName("Phone")
    public String phone;

    @SerializedName("SLA Serial Number")
    public String sLASerialNumber;

    @SerializedName("Shipping State")
    public String shippingState;

    @SerializedName("Created By Id")
    public String createdById;

    @SerializedName("Billing State")
    public String billingState;

    @SerializedName("Shipping City")
    public String shippingCity;

    @SerializedName("Billing Country")
    public String billingCountry;

    @SerializedName("Sic")
    public String sic;

    @SerializedName("Shipping Country")
    public String shippingCountry;

    @SerializedName("Shipping Postal Code")
    public String shippingPostalCode;

    @SerializedName("Type")
    public String type;

    @SerializedName("Billing Street")
    public String billingStreet;

    @SerializedName("Billing Postal Code")
    public String billingPostalCode;

    @SerializedName("CustomerPriority")
    public String customerPriority;

    @SerializedName("Clean Status")
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
}
