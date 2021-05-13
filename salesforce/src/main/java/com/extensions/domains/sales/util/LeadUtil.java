package com.extensions.domains.sales.util;

import com.extensions.domains.sales.CreateRecordResponse;
import com.extensions.domains.sales.Lead;
import com.extensions.domains.sales.model.SFLead;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class LeadUtil {

    private static Gson gson = new Gson();
    public static final String LEAD = "Lead";
    public static final String QUERY_FIELDS = " Id,LastName,FirstName,Salutation,Name,Title,Company,Address,Phone,MobilePhone,Fax,Email,Website,Description,LeadSource,Status,Industry,Rating,AnnualRevenue,NumberOfEmployees,OwnerId,IsConverted,ConvertedDate,ConvertedAccountId,ConvertedContactId,ConvertedOpportunityId,IsUnreadByOwner,CreatedDate,LastModifiedDate,CleanStatus ";


    public static List<Lead> getLeads(SalesforceUtil salesforceUtil, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Lead ORDER BY LastModifiedDate DESC LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        System.out.println(res);
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Lead> getLeadByName(SalesforceUtil salesforceUtil, String name, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Lead where name LIKE '%" +
                        name + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Lead> getLeadByName(SalesforceUtil salesforceUtil, String name, String accountId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        if (accountId == null || accountId.isEmpty()) return getLeadByName(salesforceUtil, name, size, page);
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Lead where name LIKE '%" +
                        name + "%' AND AccountId = '" + accountId + "'  ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


    public static List<Lead> getLeadByStatus(SalesforceUtil salesforceUtil, String status, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Lead where status LIKE '%" +
                        status + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Lead> getLeadsByOwnerId(SalesforceUtil salesforceUtil, String ownerId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Lead where ownerId  = '" +
                        ownerId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Lead> getLeadsByOwnerId(SalesforceUtil salesforceUtil, String ownerId) throws InterruptedException, ExecutionException, IOException {
            String res = salesforceUtil.getRecordByQuery(
                    "Select " + QUERY_FIELDS + "  from Lead where ownerId  = '" +
                            ownerId + "'");
            SalesforceListResponse<SFLead> oppList =
                    gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                    }.getType());
            if (oppList.records.size() > 0) {
                return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
            } else {
                return new ArrayList<>();
            }
        }

    public static List<Lead> getLeadByAccountId(SalesforceUtil salesforceUtil, String accountId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Lead where AccountId = '" + accountId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static Lead getLeadById(SalesforceUtil salesforceUtil, String id) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Lead where id = '" + id + "'");
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFLead::to).findFirst().orElseThrow(() -> new RuntimeException(LEAD + " Not found for id " + id));
        } else {
            throw new RuntimeException(LEAD + " Not found for id " + id);
        }
    }

    public static CreateRecordResponse addLead(SalesforceUtil salesforceUtil, Lead opportunity) throws InterruptedException, ExecutionException, IOException {
        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(SFLead.from(opportunity)), LEAD), CreateRecordResponse.class);
    }

    public static void updateLead(SalesforceUtil salesforceUtil, Lead Lead) throws InterruptedException, ExecutionException, IOException, IllegalAccessException {
        if (Lead.id == null || Lead.id.isEmpty())
            throw new RuntimeException("Lead Id cant be empty");
        SFLead updatedLead = SFLead.from(Lead);
        SFLead oldLead = SFLead.from(getLeadById(salesforceUtil, updatedLead.id));
        Map<String, String> diff = SalesforceUtil.getDifference(oldLead, updatedLead);
        salesforceUtil.updateRecord(updatedLead.id, gson.toJson(diff), LEAD);
    }


    public static List<Lead> getLeadByLastDays(SalesforceUtil salesforceUtil, int days) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Lead WHERE LastModifiedDate = LAST_N_DAYS:" + days);
        SalesforceListResponse<SFLead> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
        }
    }

    public static List<Lead> getLeadByDate(SalesforceUtil salesforceUtil, long date) throws InterruptedException, ExecutionException, IOException {
            String res = salesforceUtil.getRecordByQuery(
                    "Select " + QUERY_FIELDS + " from Lead WHERE CreatedDate >" + DatePlus.getISODate(new Date(date)));
            SalesforceListResponse<SFLead> oppList =
                    gson.fromJson(res, new TypeToken<SalesforceListResponse<SFLead>>() {
                    }.getType());
            if (oppList.records.isEmpty()) {
                return new ArrayList<>();
            } else {
                return oppList.records.stream().map(SFLead::to).collect(Collectors.toList());
            }
        }
}