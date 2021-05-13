package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sales.Quote;
import com.integration.util.DatePlus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SQuotes {

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
    @SerializedName("created_by")
    public String createdBy;
    @SerializedName("created_by_name")
    public String createdByName;
    @SerializedName("description")
    public String description;
    @SerializedName("deleted")
    public Boolean deleted;
    @SerializedName("shipper_id")
    public String shipperId;
    @SerializedName("shipper_name")
    public String shipperName;
    @SerializedName("taxrate_id")
    public String taxrateId;
    @SerializedName("taxrate_name")
    public String taxrateName;
    @SerializedName("taxrate_value")
    public String taxrateValue;
    @SerializedName("show_line_nums")
    public Boolean showLineNums;
    @SerializedName("quote_type")
    public String quoteType;
    @SerializedName("date_quote_expected_closed")
    public String dateQuoteExpectedClosed;
    @SerializedName("original_po_date")
    public String originalPoDate;
    @SerializedName("payment_terms")
    public String paymentTerms;
    @SerializedName("date_quote_closed")
    public String dateQuoteClosed;
    @SerializedName("date_order_shipped")
    public String dateOrderShipped;
    @SerializedName("order_stage")
    public String orderStage;
    @SerializedName("quote_stage")
    public String quoteStage;
    @SerializedName("purchase_order_num")
    public String purchaseOrderNum;
    @SerializedName("quote_num")
    public String quoteNum;
    @SerializedName("subtotal")
    public Double subtotal;
    @SerializedName("subtotal_usdollar")
    public String subtotalUsdollar;
    @SerializedName("shipping")
    public Double shipping;
    @SerializedName("shipping_usdollar")
    public String shippingUsdollar;
    @SerializedName("discount")
    public Double discount;
    @SerializedName("deal_tot")
    public Double dealTot;
    @SerializedName("deal_tot_discount_percentage")
    public Integer dealTotDiscountPercentage;
    @SerializedName("deal_tot_usdollar")
    public String dealTotUsdollar;
    @SerializedName("new_sub")
    public String newSub;
    @SerializedName("new_sub_usdollar")
    public String newSubUsdollar;
    @SerializedName("taxable_subtotal")
    public String taxableSubtotal;
    @SerializedName("tax")
    public Double tax;
    @SerializedName("tax_usdollar")
    public String taxUsdollar;
    @SerializedName("total")
    public Double total;
    @SerializedName("total_usdollar")
    public String totalUsdollar;
    @SerializedName("billing_address_street")
    public String billingAddressStreet;
    @SerializedName("billing_address_city")
    public String billingAddressCity;
    @SerializedName("billing_address_state")
    public String billingAddressState;
    @SerializedName("billing_address_postalcode")
    public String billingAddressPostalcode;
    @SerializedName("billing_address_country")
    public String billingAddressCountry;
    @SerializedName("shipping_address_street")
    public String shippingAddressStreet;
    @SerializedName("shipping_address_city")
    public String shippingAddressCity;
    @SerializedName("shipping_address_state")
    public String shippingAddressState;
    @SerializedName("shipping_address_postalcode")
    public String shippingAddressPostalcode;
    @SerializedName("shipping_address_country")
    public String shippingAddressCountry;
    @SerializedName("shipping_account_name")
    public String shippingAccountName;
    @SerializedName("shipping_account_id")
    public String shippingAccountId;
    @SerializedName("shipping_contact_name")
    public String shippingContactName;
    @SerializedName("shipping_contact_id")
    public String shippingContactId;
    @SerializedName("account_name")
    public String accountName;
    @SerializedName("account_id")
    public String accountId;
    @SerializedName("billing_account_name")
    public String billingAccountName;
    @SerializedName("billing_account_id")
    public String billingAccountId;
    @SerializedName("billing_contact_name")
    public String billingContactName;
    @SerializedName("billing_contact_id")
    public String billingContactId;
    @SerializedName("opportunity_name")
    public String opportunityName;
    @SerializedName("opportunity_id")
    public String opportunityId;
    @SerializedName("following")
    public Boolean following;
    @SerializedName("my_favorite")
    public Boolean myFavorite;
    @SerializedName("assigned_user_id")
    public String assignedUserId;
    @SerializedName("assigned_user_name")
    public String assignedUserName;
    @SerializedName("team_count")
    public String teamCount;
    @SerializedName("currency_id")
    public String currencyId;
    @SerializedName("base_rate")
    public String baseRate;
    @SerializedName("currency_name")
    public String currencyName;


    public static Quote to(SQuotes sfQuote) {
        Quote quote = new Quote();
        quote.id = sfQuote.id;
        quote.createdDate = DatePlus.getISODate(sfQuote.dateEntered);
        quote.expirationDate = DatePlus.fromYYYYMMDD(sfQuote.dateQuoteExpectedClosed);
        quote.accountId = sfQuote.accountId;
        quote.name = sfQuote.name;
        quote.billingName = sfQuote.billingAccountName;
        quote.accountId = sfQuote.accountId;
        quote.description = sfQuote.description;
        quote.contactId = sfQuote.billingContactId;
        quote.discount = sfQuote.dealTot;
        quote.grandTotal = sfQuote.total;
        quote.quoteNumber = sfQuote.quoteNum;
        quote.shippingHandling = sfQuote.shipping;
        quote.status = sfQuote.quoteStage;
        quote.subtotal = sfQuote.subtotal;
        quote.tax = sfQuote.tax;
        quote.totalPrice = String.valueOf(sfQuote.total);
//        quote.pricebookId = sfQuote.pricebookId;
//        quote.lineItemCount = sfQuote.;
        quote.opportunityId = sfQuote.opportunityId;
        return quote;
    }

    public static SQuotes from(Quote sfQuote) {
        SQuotes quote = new SQuotes();
        try {
            quote.id = sfQuote.id;
            quote.dateEntered = DatePlus.getISODate(sfQuote.createdDate);
            quote.dateQuoteExpectedClosed = DatePlus.getYYYYMMDD(sfQuote.expirationDate);
            quote.accountId = sfQuote.accountId;
            quote.name = sfQuote.name;
            quote.billingAccountName = sfQuote.billingName;
            quote.accountId = sfQuote.accountId;
            quote.description = sfQuote.description;
            quote.billingContactId = sfQuote.contactId;
            quote.discount = sfQuote.discount;
            quote.total = sfQuote.grandTotal;
            quote.quoteNum = sfQuote.quoteNumber;
            quote.shipping = sfQuote.shippingHandling;
            quote.quoteStage = sfQuote.status;
            quote.subtotal = sfQuote.subtotal;
            quote.tax = sfQuote.tax;

            quote.total = Double.parseDouble(sfQuote.totalPrice);
            //        quote.pricebookId = sfQuote.pricebookId;
            //        quote.lineItemCount = sfQuote.;
            quote.opportunityId = sfQuote.opportunityId;
        } catch (Exception ignored) {
            System.out.println("Err in quote " + ignored.getMessage());
        }
        return quote;
    }

    public static class Records {
           public SQuotes[] records;
           public int next_offset;

           public List<Quote> to() {
               return Arrays.stream(records).map(SQuotes::to).collect(Collectors.toList());
           }
       }

}