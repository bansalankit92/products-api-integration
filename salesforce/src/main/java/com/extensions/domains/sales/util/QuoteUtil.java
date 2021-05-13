package com.extensions.domains.sales.util;

import com.extensions.domains.sales.CreateRecordResponse;
import com.extensions.domains.sales.Quote;
import com.extensions.domains.sales.model.SFPriceBook2;
import com.extensions.domains.sales.model.SFQuote;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.extensions.domains.sales.PricebookEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class QuoteUtil {

    private static Gson gson = new Gson();
    public static final String QUOTE = "Quote";
    public static final String QUERY_FIELDS = " Id,OwnerId,Name,CreatedDate,LastModifiedDate,OpportunityId,Pricebook2Id,ContactId,QuoteNumber,Tax,Status,ExpirationDate,Description,Subtotal,TotalPrice,LineItemCount,BillingName,ShippingName,QuoteToName,AdditionalName,Email,Phone,Fax,ContractId,AccountId,Discount,GrandTotal ";


    public static List<Quote> getQuotes(SalesforceUtil salesforceUtil, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Quote ORDER BY LastModifiedDate DESC LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        System.out.println(res);
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Quote> getQuoteByName(SalesforceUtil salesforceUtil, String name, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where name LIKE '%" +
                        name + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Quote> getQuoteByName(SalesforceUtil salesforceUtil, String name, String accountId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        if (accountId == null || accountId.isEmpty()) return getQuoteByName(salesforceUtil, name, size, page);
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where name LIKE '%" +
                        name + "%' AND AccountId = '" + accountId + "'  ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Quote> getQuoteByNameAndOpportunityId(SalesforceUtil salesforceUtil, String name, String opportunityId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        if (opportunityId == null || opportunityId.isEmpty()) return getQuoteByName(salesforceUtil, name, size, page);
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where name LIKE '%" +
                        name + "%' AND OpportunityId = '" + opportunityId + "'  ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


    public static List<Quote> getQuoteByStatus(SalesforceUtil salesforceUtil, String status, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where status LIKE '%" +
                        status + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Quote> getQuotesByOwnerId(SalesforceUtil salesforceUtil, String ownerId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where ownerId  = '" +
                        ownerId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Quote> getQuotesByOwnerId(SalesforceUtil salesforceUtil, String ownerId) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where ownerId  = '" +
                        ownerId + "'");
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Quote> getQuoteByAccountId(SalesforceUtil salesforceUtil, String accountId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where AccountId = '" + accountId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Quote> getQuoteByOpportunityId(SalesforceUtil salesforceUtil, String opportunityId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where OpportunityId = '" + opportunityId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static Quote getQuoteById(SalesforceUtil salesforceUtil, String id) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Quote where id = '" + id + "'");
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFQuote::to).findFirst().orElseThrow(() -> new RuntimeException(QUOTE + " Not found for id " + id));
        } else {
            throw new RuntimeException(QUOTE + " Not found for id " + id);
        }
    }

    public static CreateRecordResponse addQuote(SalesforceUtil salesforceUtil, Quote opportunity) throws InterruptedException, ExecutionException, IOException {
        SFQuote quote = SFQuote.from(opportunity);
        if (quote.pricebookId == null) {
            List<SFPriceBook2> pb = PriceBook2Util.getPricebookEntrys(salesforceUtil);
            if (!pb.isEmpty())
                quote.pricebookId = pb.get(0).Id;
        }

        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(quote), QUOTE), CreateRecordResponse.class);
    }

    public static void updateQuote(SalesforceUtil salesforceUtil, Quote Quote) throws InterruptedException, ExecutionException, IOException, IllegalAccessException {
        if (Quote.id == null || Quote.id.isEmpty())
            throw new RuntimeException("Quote Id cant be empty");
        SFQuote updatedQuote = SFQuote.from(Quote);
        SFQuote oldQuote = SFQuote.from(getQuoteById(salesforceUtil, updatedQuote.id));
        Map<String, String> diff = SalesforceUtil.getDifference(oldQuote, updatedQuote);
        salesforceUtil.updateRecord(updatedQuote.id, gson.toJson(diff), QUOTE);
    }


    public static List<Quote> getQuoteByLastDays(SalesforceUtil salesforceUtil, int days) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Quote WHERE LastModifiedDate = LAST_N_DAYS:" + days);
        SalesforceListResponse<SFQuote> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFQuote>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFQuote::to).collect(Collectors.toList());
        }
    }

    public static CreateRecordResponse addProductToQuote(SalesforceUtil util, Quote quote, PricebookEntry pbe, Double discount) throws InterruptedException, ExecutionException, IOException {
        Map<String, String> map = new HashMap<>();
        map.put("QuoteId", quote.id);
        map.put("Quantity", "12");
        map.put("PricebookEntryId", PricebookEntryUtil.addOrGetPriceBookEntry(util, quote.pricebookId, pbe));
        map.put("Product2Id", pbe.productId);
        map.put("UnitPrice", String.valueOf(pbe.unitPrice));
        map.put("Discount", discount!=null? String.valueOf(discount):null);
        return gson.fromJson(util.createRecord(new Gson().toJson(map), "QuoteLineItem"), CreateRecordResponse.class);

    }

    public static List<Map<String,Object>> getQuoteLineItemByQuoteId(SalesforceUtil salesforceUtil, String quoteId) throws InterruptedException, ExecutionException, IOException {
            String res = salesforceUtil.getRecordByQuery(
                    "Select LineNumber,QuoteId,PricebookEntryId,Quantity,UnitPrice,Discount,ListPrice,Subtotal,TotalPrice,Product2Id from QuoteLineItem WHERE QuoteId = '" + quoteId+"'");
            SalesforceListResponse<Map<String,Object>> oppList =
                    gson.fromJson(res, new TypeToken<SalesforceListResponse<Map<String,Object>>>() {
                    }.getType());
            if (oppList.records.isEmpty()) {
                return new ArrayList<>();
            } else {
                return oppList.records.stream().peek(x->x.put("attributes",null)).collect(Collectors.toList());
            }
        }

//
}