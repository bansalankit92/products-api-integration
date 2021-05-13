package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sales.PricebookEntry;
import com.integration.util.DatePlus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SProducts {

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
    @SerializedName("type_id")
    public String typeId;
    @SerializedName("manufacturer_id")
    public String manufacturerId;
    @SerializedName("manufacturer_name")
    public String manufacturerName;
    @SerializedName("category_id")
    public String categoryId;
    @SerializedName("category_name")
    public String categoryName;
    @SerializedName("mft_part_num")
    public String mftPartNum;
    @SerializedName("vendor_part_num")
    public String vendorPartNum;
    @SerializedName("date_cost_price")
    public String dateCostPrice;
    @SerializedName("cost_price")
    public String costPrice;
    @SerializedName("discount_price")
    public Double discountPrice;
    @SerializedName("list_price")
    public Double listPrice;
    @SerializedName("cost_usdollar")
    public String costUsdollar;
    @SerializedName("discount_usdollar")
    public String discountUsdollar;
    @SerializedName("list_usdollar")
    public String listUsdollar;
    @SerializedName("status")
    public String status;
    @SerializedName("tax_class")
    public String taxClass;
    @SerializedName("date_available")
    public String dateAvailable;
    @SerializedName("website")
    public String website;
    @SerializedName("weight")
    public Integer weight;
    @SerializedName("qty_in_stock")
    public Integer qtyInStock;
    @SerializedName("support_name")
    public String supportName;
    @SerializedName("support_description")
    public String supportDescription;
    @SerializedName("support_contact")
    public String supportContact;
    @SerializedName("support_term")
    public String supportTerm;
    @SerializedName("pricing_formula")
    public String pricingFormula;
    @SerializedName("pricing_factor")
    public Integer pricingFactor;
    @SerializedName("service_duration_value")
    public Object serviceDurationValue;
    @SerializedName("service_duration_unit")
    public String serviceDurationUnit;
    @SerializedName("renewable")
    public Boolean renewable;
    @SerializedName("service")
    public Boolean service;
    @SerializedName("following")
    public Boolean following;
    @SerializedName("my_favorite")
    public Boolean myFavorite;
    @SerializedName("tag")
    public List<Object> tag = null;
    @SerializedName("locked_fields")
    public List<Object> lockedFields = null;
    @SerializedName("assigned_user_id")
    public String assignedUserId;
    @SerializedName("assigned_user_name")
    public String assignedUserName;
    @SerializedName("currency_id")
    public String currencyId;
    @SerializedName("base_rate")
    public String baseRate;
    @SerializedName("currency_name")
    public String currencyName;
    @SerializedName("currency_symbol")
    public String currencySymbol;


    public static PricebookEntry to(SProducts sProducts) {
        PricebookEntry entry = new PricebookEntry();
        entry.id = sProducts.id;
        entry.createdDate = DatePlus.getISODate(sProducts.dateEntered);
        entry.lastModifiedDate = DatePlus.getISODate(sProducts.dateModified);
        entry.name = sProducts.name;
        // entry.pricebookId = sProducts.p;
        entry.productCode = sProducts.mftPartNum;
        entry.unitPrice = sProducts.listPrice;
        entry.productId = sProducts.id;
        entry.categoryId = sProducts.categoryId;
        entry.discountPrice = sProducts.discountPrice;
        return entry;
    }

    public static SProducts from(PricebookEntry prod) {
        SProducts entry = new SProducts();
        entry.id = prod.id;
        entry.dateModified = DatePlus.getISODate((prod.lastModifiedDate));
        entry.dateEntered = DatePlus.getISODate((prod.createdDate));
        entry.name = prod.name;
        entry.mftPartNum = prod.productCode;
        entry.listPrice = prod.unitPrice;
        // entry.productId = prod.id;
        entry.categoryId = prod.categoryId;
        entry.discountPrice = prod.discountPrice;
        return entry;
    }

    public static class Records {
           public SProducts[] records;
           public int next_offset;

           public List<PricebookEntry> to() {
               return Arrays.stream(records).map(SProducts::to).collect(Collectors.toList());
           }
       }

}