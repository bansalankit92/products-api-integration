package com.extensions.domains.sales.model;

import java.util.Date;
import com.extensions.domains.sales.Quote;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class SFQuote {

    @SerializedName("Status")
    public String status;

    @SerializedName("ExpirationDate")
    public Date expirationDate;

    @SerializedName("AccountId")
    public String accountId;

    @SerializedName("TotalPrice")
    public String totalPrice;

    @SerializedName("Description")
    public String description;

    @SerializedName("Discount")
    public Double discount;

    @SerializedName("CreatedDate")
    public Date createdDate;

    @SerializedName("Subtotal")
    public Double subtotal;

    @SerializedName("Tax")
    public Double tax;

    @SerializedName("Pricebook2Id")
    public String pricebookId;

    @SerializedName("LineItemCount")
    public Double lineItemCount;

    @SerializedName("Name")
    public String name;

    @SerializedName("OpportunityId")
    public String opportunityId;

    @SerializedName("ShippingHandling")
    public Double shippingHandling;

    @SerializedName("BillingName")
    public String billingName;

    @SerializedName("Id")
    public String id;

    @SerializedName("QuoteNumber")
    public String quoteNumber;

    @SerializedName("ContactId")
    public String contactId;

    @SerializedName("GrandTotal")
    public Double grandTotal;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

    public static Quote to(SFQuote sfQuote) {
        Quote quote = new Quote();
        quote.id = sfQuote.id;
        quote.createdDate = sfQuote.createdDate != null ? sfQuote.createdDate.getTime() : null;
        quote.expirationDate = sfQuote.expirationDate != null ? sfQuote.expirationDate.getTime() : null;
        quote.accountId = sfQuote.accountId;
        quote.name = sfQuote.name;
        quote.billingName = sfQuote.billingName;
        quote.accountId = sfQuote.accountId;
        quote.description = sfQuote.description;
        quote.contactId = sfQuote.contactId;
        quote.discount = sfQuote.discount;
        quote.grandTotal = sfQuote.grandTotal;
        quote.quoteNumber = sfQuote.quoteNumber;
        quote.shippingHandling = sfQuote.shippingHandling;
        quote.status = sfQuote.status;
        quote.subtotal = sfQuote.subtotal;
        quote.tax = sfQuote.tax;
        quote.totalPrice = sfQuote.totalPrice;
        quote.pricebookId = sfQuote.pricebookId;
        quote.lineItemCount = sfQuote.lineItemCount;
        quote.opportunityId = sfQuote.opportunityId;
        return quote;
    }

    public static SFQuote from(Quote sfQuote) {
        SFQuote quote = new SFQuote();
        quote.id = sfQuote.id;
        quote.accountId = sfQuote.accountId;
        quote.name = sfQuote.name;
        quote.billingName = sfQuote.billingName;
        quote.accountId = sfQuote.accountId;
        quote.description = sfQuote.description;
        quote.contactId = sfQuote.contactId;
        quote.discount = sfQuote.discount;
        quote.grandTotal = sfQuote.grandTotal;
        quote.quoteNumber = sfQuote.quoteNumber;
        quote.shippingHandling = sfQuote.shippingHandling;
        quote.status = sfQuote.status;
        quote.subtotal = sfQuote.subtotal;
        quote.tax = sfQuote.tax;
        quote.totalPrice = sfQuote.totalPrice;
        quote.pricebookId = sfQuote.pricebookId;
        quote.lineItemCount = sfQuote.lineItemCount;
        quote.opportunityId = sfQuote.opportunityId;
//        if (sfQuote.lastModifiedDate != null)
//            quote.lastModifiedDate = new Date(sfQuote.lastModifiedDate);
        if (sfQuote.createdDate != null) {
            quote.createdDate = new Date(sfQuote.createdDate);
        }
        if (sfQuote.expirationDate != null) {
            quote.expirationDate = new Date(sfQuote.expirationDate);
        }
        return quote;
    }

    // Id,OwnerId,Name,CreatedDate,LastModifiedDate,OpportunityId,Pricebook2Id,ContactId,QuoteNumber,Tax,Status,ExpirationDate,Description,Subtotal,TotalPrice,LineItemCount,BillingName,ShippingName,QuoteToName,AdditionalName,Email,Phone,Fax,ContractId,AccountId,Discount,GrandTotal
}
