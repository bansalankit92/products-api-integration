package com.extensions.domains.sales.util;

import com.extensions.domains.sales.Contract;
import com.extensions.domains.sales.CreateRecordResponse;
import com.extensions.domains.sales.model.SFContract;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ContractUtil {

    private static Gson gson = new Gson();
    public static final String CONTRACT = "Contract";
    public static final String QUERY_FIELDS = " Id,LastName,FirstName,Salutation,Name,Title,Company,Address,Phone,MobilePhone,Fax,Email,Website,Description,ContractSource,Status,Industry,Rating,AnnualRevenue,NumberOfEmployees,OwnerId,IsConverted,ConvertedDate,ConvertedAccountId,ConvertedContactId,ConvertedOpportunityId,IsUnreadByOwner,CreatedDate,LastModifiedDate,CleanStatus ";


    public static List<Contract> getContracts(SalesforceUtil salesforceUtil, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Contract ORDER BY LastModifiedDate DESC LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        System.out.println(res);
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Contract> getContractByName(SalesforceUtil salesforceUtil, String name, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Contract where name LIKE '%" +
                        name + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Contract> getContractByName(SalesforceUtil salesforceUtil, String name, String accountId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        if (accountId == null || accountId.isEmpty()) return getContractByName(salesforceUtil, name, size, page);
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Contract where name LIKE '%" +
                        name + "%' AND AccountId = '" + accountId + "'  ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


    public static List<Contract> getContractByStatus(SalesforceUtil salesforceUtil, String status, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Contract where status LIKE '%" +
                        status + "%' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Contract> getContractsByOwnerId(SalesforceUtil salesforceUtil, String ownerId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Contract where ownerId  = '" +
                        ownerId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Contract> getContractsByOwnerId(SalesforceUtil salesforceUtil, String ownerId) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Contract where ownerId  = '" +
                        ownerId + "'");
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<Contract> getContractByAccountId(SalesforceUtil salesforceUtil, String accountId, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Contract where AccountId = '" + accountId + "' ORDER BY LastModifiedDate DESC  LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static Contract getContractById(SalesforceUtil salesforceUtil, String id) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + "  from Contract where id = '" + id + "'");
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFContract::to).findFirst().orElseThrow(() -> new RuntimeException(CONTRACT + " Not found for id " + id));
        } else {
            throw new RuntimeException(CONTRACT + " Not found for id " + id);
        }
    }

    public static CreateRecordResponse addContract(SalesforceUtil salesforceUtil, Contract opportunity) throws InterruptedException, ExecutionException, IOException {
        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(SFContract.from(opportunity)), CONTRACT), CreateRecordResponse.class);
    }

    public static void updateContract(SalesforceUtil salesforceUtil, Contract Contract) throws InterruptedException, ExecutionException, IOException, IllegalAccessException {
        if (Contract.id == null || Contract.id.isEmpty())
            throw new RuntimeException("Contract Id cant be empty");
        SFContract updatedContract = SFContract.from(Contract);
        SFContract oldContract = SFContract.from(getContractById(salesforceUtil, updatedContract.id));
        Map<String, String> diff = SalesforceUtil.getDifference(oldContract, updatedContract);
        salesforceUtil.updateRecord(updatedContract.id, gson.toJson(diff), CONTRACT);
    }


    public static List<Contract> getContractByLastDays(SalesforceUtil salesforceUtil, int days) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Contract WHERE LastModifiedDate = LAST_N_DAYS:" + days);
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        }
    }

    public static List<Contract> getContractByDate(SalesforceUtil salesforceUtil, long date) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + QUERY_FIELDS + " from Contract WHERE CreatedDate >" + DatePlus.getISODate(new Date(date)));
        SalesforceListResponse<SFContract> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFContract>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFContract::to).collect(Collectors.toList());
        }
    }
}