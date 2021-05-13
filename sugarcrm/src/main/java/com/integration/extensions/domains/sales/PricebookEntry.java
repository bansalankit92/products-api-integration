package com.integration.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("Category Id")
    public String categoryId;

    @SerializedName("Discount Price")
    public Double discountPrice;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
