package com.extensions.domains.sales.model;

import java.util.Date;
import com.extensions.domains.sales.PricebookEntry;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public final class SFPricebookEntry {

    @SerializedName("Product2Id")
    public String productId;

    @SerializedName("LastModifiedDate")
    public Date lastModifiedDate;

    @SerializedName("CreatedDate")
    public Date createdDate;

    @SerializedName("ProductCode")
    public String productCode;

    @SerializedName("Id")
    public String id;

    @SerializedName("Pricebook2Id")
    public String pricebookId;

    @SerializedName("UnitPrice")
    public Double unitPrice;

    @SerializedName("Name")
    public String name;

    public static PricebookEntry to(SFPricebookEntry sfPricebookEntry) {
        PricebookEntry entry = new PricebookEntry();
        entry.id = sfPricebookEntry.id;
        entry.lastModifiedDate =
                sfPricebookEntry.lastModifiedDate != null ? sfPricebookEntry.lastModifiedDate.getTime() : null;
        entry.createdDate = sfPricebookEntry.createdDate != null ? sfPricebookEntry.createdDate.getTime() : null;
        entry.name = sfPricebookEntry.name;
        entry.pricebookId = sfPricebookEntry.pricebookId;
        entry.productCode = sfPricebookEntry.productCode;
        entry.unitPrice = sfPricebookEntry.unitPrice;
        entry.productId = sfPricebookEntry.productId;
        return entry;
    }

    public static SFPricebookEntry from(PricebookEntry sfPricebookEntry) {
        SFPricebookEntry entry = new SFPricebookEntry();
        entry.id = sfPricebookEntry.id;
        if (sfPricebookEntry.lastModifiedDate != null) {
            entry.lastModifiedDate = new Date(sfPricebookEntry.lastModifiedDate);
        }
        if (sfPricebookEntry.createdDate != null) {
            entry.createdDate = new Date(sfPricebookEntry.createdDate);
        }
        entry.name = sfPricebookEntry.name;
        entry.name = sfPricebookEntry.name;
        entry.pricebookId = sfPricebookEntry.pricebookId;
        entry.productCode = sfPricebookEntry.productCode;
        entry.unitPrice = sfPricebookEntry.unitPrice;
        entry.productId = sfPricebookEntry.productId;
        return entry;
    }

    // Id,Name,Pricebook2Id,Product2Id,UnitPrice,IsActive,CreatedDate,LastModifiedDate,ProductCode
}
