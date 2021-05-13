package com.integration.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

public final class Quote {

    @SerializedName("Status")
    public String status;

    @SerializedName("Expiration Date")
    public Long expirationDate;

    @SerializedName("Account Id")
    public String accountId;

    @SerializedName("Total Price")
    public String totalPrice;

    @SerializedName("Description")
    public String description;

    @SerializedName("Discount")
    public Double discount;

    @SerializedName("Created Date")
    public Long createdDate;

    @SerializedName("Subtotal")
    public Double subtotal;

    @SerializedName("Tax")
    public Double tax;

    @SerializedName("Pricebook Id")
    public String pricebookId;

    @SerializedName("Line Item Count")
    public Double lineItemCount;

    @SerializedName("Name")
    public String name;

    @SerializedName("Opportunity Id")
    public String opportunityId;

    @SerializedName("Shipping Handling")
    public Double shippingHandling;

    @SerializedName("Billing Name")
    public String billingName;

    @SerializedName("Id")
    public String id;

    @SerializedName("Quote Number")
    public String quoteNumber;

    @SerializedName("Contact Id")
    public String contactId;

    @SerializedName("Grand Total")
    public Double grandTotal;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
