package com.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class PricebookEntry {

    @SerializedName("Product Id")
    public String productId;

    @SerializedName("Last Modified Date")
    public Long lastModifiedDate;

    @SerializedName("Created Date")
    public Long createdDate;

    @SerializedName("Product Code")
    public String productCode;

    @SerializedName("Id")
    public String id;

    @SerializedName("Pricebook Id")
    public String pricebookId;

    @SerializedName("Unit Price")
    public Double unitPrice;

    @SerializedName("Name")
    public String name;

    @SerializedName("Quantity")
    public Long quantity;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name + " | " + unitPrice;
    }

}
