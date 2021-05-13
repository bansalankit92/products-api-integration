package com.extensions.domains.sales.util;

import com.extensions.domains.sales.CreateRecordResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.extensions.domains.sales.PricebookEntry;
import com.extensions.domains.sales.model.SFPricebookEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class PricebookEntryUtil {

    private static Gson gson = new Gson();
    public static final String PRICEBOOK_ENTRY = "PricebookEntry";
    public static final String QUERY_FIELDS = " Id,Name,Pricebook2Id,Product2Id,UnitPrice,IsActive,CreatedDate,LastModifiedDate,ProductCode ";


    public static List<PricebookEntry> getPricebookEntrys(SalesforceUtil salesforceUtil, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from PricebookEntry ORDER BY LastModifiedDate DESC LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFPricebookEntry> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFPricebookEntry>>() {
                }.getType());
        System.out.println(res);
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFPricebookEntry::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<PricebookEntry> getPricebookEntryByName(SalesforceUtil salesforceUtil, String name, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from PricebookEntry where name LIKE '%" +
                        name + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFPricebookEntry> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFPricebookEntry>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFPricebookEntry::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static PricebookEntry getPricebookEntryById(SalesforceUtil salesforceUtil, String id) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from PricebookEntry where id = '" + id + "'");
        SalesforceListResponse<SFPricebookEntry> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFPricebookEntry>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFPricebookEntry::to).findFirst().orElseThrow(() -> new RuntimeException(PRICEBOOK_ENTRY + " Not found for id " + id));
        } else {
            throw new RuntimeException(PRICEBOOK_ENTRY + " Not found for id " + id);
        }
    }

    public static CreateRecordResponse addPricebookEntry(SalesforceUtil salesforceUtil, PricebookEntry opportunity) throws InterruptedException, ExecutionException, IOException {
        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(SFPricebookEntry.from(opportunity)), PRICEBOOK_ENTRY), CreateRecordResponse.class);
    }

    public static void updatePricebookEntry(SalesforceUtil salesforceUtil, PricebookEntry PricebookEntry) throws InterruptedException, ExecutionException, IOException, IllegalAccessException {
        if (PricebookEntry.id == null || PricebookEntry.id.isEmpty())
            throw new RuntimeException("PricebookEntry Id cant be empty");
        SFPricebookEntry updatedPricebookEntry = SFPricebookEntry.from(PricebookEntry);
        SFPricebookEntry oldPricebookEntry = SFPricebookEntry.from(getPricebookEntryById(salesforceUtil, updatedPricebookEntry.id));
        Map<String, String> diff = SalesforceUtil.getDifference(oldPricebookEntry, updatedPricebookEntry);
        salesforceUtil.updateRecord(updatedPricebookEntry.id, gson.toJson(diff), PRICEBOOK_ENTRY);
    }


    public static List<PricebookEntry> getPricebookEntryByLastDays(SalesforceUtil salesforceUtil, int days) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from PricebookEntry WHERE LastModifiedDate = LAST_N_DAYS:" + days);
        SalesforceListResponse<SFPricebookEntry> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFPricebookEntry>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFPricebookEntry::to).collect(Collectors.toList());
        }
    }

    public static String addOrGetPriceBookEntry(SalesforceUtil util, String pricebookId, PricebookEntry pricebookEntry) throws InterruptedException, ExecutionException, IOException {
        Map<String, String> pbe = new HashMap<>();
        pbe.put("Pricebook2Id", pricebookId != null && !pricebookId.isBlank() ? pricebookId : pricebookEntry.pricebookId);
        pbe.put("Product2Id", pricebookEntry.productId);
        pbe.put("UnitPrice", String.valueOf(pricebookEntry.unitPrice));
        pbe.put("IsActive", "true");
        PricebookEntry exist = getPricebookEntryByProductPricebook(util, pricebookId, pricebookEntry.productId);
        if (exist != null) return exist.id;
        System.out.println("exist is null");
        return gson.fromJson(util.createRecord(gson.toJson(pbe), PRICEBOOK_ENTRY), CreateRecordResponse.class).id;

    }

    public static PricebookEntry getPricebookEntryByProductPricebook(SalesforceUtil salesforceUtil, String pricebook2Id, String product2Id) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from PricebookEntry where Pricebook2Id = '" + pricebook2Id + "' AND Product2Id='" + product2Id + "'");
        SalesforceListResponse<SFPricebookEntry> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFPricebookEntry>>() {
                }.getType());
        System.out.println(res);
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFPricebookEntry::to).findFirst().orElse(null);
        } else {
            return null;
        }
    }
}