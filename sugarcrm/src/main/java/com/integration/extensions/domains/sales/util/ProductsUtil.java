package com.integration.extensions.domains.sales.util;

import com.integration.extensions.domains.sales.PricebookEntry;
import com.integration.extensions.domains.sales.model.Me;
import com.integration.extensions.domains.sales.model.SProducts;
import com.integration.util.RestClient;

import java.io.IOException;
import java.util.List;

public class ProductsUtil {
    public static final String PRODUCT_TEMPLATES = "ProductTemplates";

    public static List<PricebookEntry> getPricebookEntryByName(SugarcrmUtil util, String opportunityName) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "name", opportunityName);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();
    }

    public static List<PricebookEntry> getPricebookEntryByName(SugarcrmUtil util, String opportunityName, long size, long page) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "name", opportunityName, page, size);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();
    }

    public static List<PricebookEntry> getPricebookEntryByDescription(SugarcrmUtil util, String opportunityDescription, long size, long page) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "description", opportunityDescription, page, size);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();
    }

    public static List<PricebookEntry> getPriceBooks(SugarcrmUtil util, long size, long page) throws IOException {
        String res = util.get(PRODUCT_TEMPLATES, page, size);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();
    }

    public static List<PricebookEntry> getPricebookEntryByStatus(SugarcrmUtil util, String opportunityStatus, long size, long page) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "sales_stage", opportunityStatus, page, size);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();
    }

    public static List<PricebookEntry> getPricebookEntryByStatus(SugarcrmUtil util, String opportunityStatus) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "sales_stage", opportunityStatus);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();
    }

    public static List<PricebookEntry> getPricebookEntryByOwnerID(SugarcrmUtil util, String ownerID, long size, long page) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "created_by", ownerID, page, size);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();

    }

    public static List<PricebookEntry> getPricebookEntryByAccountId(SugarcrmUtil util, String accountId, long size, long page) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "account_id", accountId, page, size);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();

    }

    public static List<PricebookEntry> getPricebookEntryByAssignedUser(SugarcrmUtil util, String assignedUserId) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "assigned_user_id", assignedUserId);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();

    }


    public static List<PricebookEntry> getMyPricebookEntry(SugarcrmUtil util) throws IOException {
        Me.CurrentUser c = RestClient.gson.fromJson(util.getMe(), Me.CurrentUser.class);
        String res = util.search(PRODUCT_TEMPLATES, "assigned_user_id", c.currentUser.id);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();

    }

    public static List<PricebookEntry> getPricebookEntryByAccountId(SugarcrmUtil util, String accountId) throws IOException {
        String res = util.search(PRODUCT_TEMPLATES, "account_id", accountId);
        return RestClient.gson.fromJson(res, SProducts.Records.class).to();

    }

    public static PricebookEntry getPricebookEntryById(SugarcrmUtil util, String id) throws IOException {
        return SProducts.to( RestClient.gson.fromJson(util.getById(PRODUCT_TEMPLATES, id), SProducts.class));
    }

    public static PricebookEntry addPricebookEntry(SugarcrmUtil util, PricebookEntry opportunity) {
        return SProducts.to(RestClient.gson.fromJson(util.post(PRODUCT_TEMPLATES, RestClient.gson.toJson(SProducts.from(opportunity))), SProducts.class));
    }

    public static PricebookEntry updatePricebookEntry(SugarcrmUtil util, PricebookEntry updatedPricebookEntry) throws IOException, IllegalAccessException {
        if (updatedPricebookEntry.id == null || updatedPricebookEntry.id.isEmpty())
            throw new RuntimeException("PricebookEntry Id cant be empty");
        SProducts updatedopportunity = SProducts.from(updatedPricebookEntry);
        return SProducts.to( RestClient.gson.fromJson(util.put(PRODUCT_TEMPLATES, updatedopportunity.id, RestClient.gson.toJson(updatedopportunity)), SProducts.class));

    }

}