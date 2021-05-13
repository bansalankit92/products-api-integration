package com.extensions.domains.sales.util;

import com.extensions.domains.sales.*;
import com.extensions.domains.sales.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class OpportunityUtil {

    public static final String AND = " AND ";
    private Gson gson = new Gson();
    private OAuthUtil authUtil;
    private SalesforceUtil salesforceUtil;
    public static final String OPPORTUNITY = "Opportunity";

    public static final String query = " id, Name, StageName,Amount, closeDate, probability, Description,ExpectedRevenue,LastModifiedDate, createdDate,ownerid ";

    public OpportunityUtil(Map<String, Object> attributes) {
        this.authUtil = new OAuthUtil(attributes);
        this.salesforceUtil = new SalesforceUtil(attributes);
    }

    public List<Opportunity> getOpportunityByName(String opportunityName) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where name LIKE '%" +
                        opportunityName + "%'");
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByName(String opportunityName, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where name LIKE '%" +
                        opportunityName + "%' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByDescription(String opportunityDescription, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where Description LIKE '%" +
                        opportunityDescription + "%' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByDescription(String opportunityDescription) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where Description LIKE '%" +
                        opportunityDescription + "%'");
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunities(long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByStatus(String opportunityStatus, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where StageName LIKE '%" +
                        opportunityStatus + "%' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static boolean isAvailable(String s) {
        return s != null && !s.isBlank();
    }

    public static boolean isAvailable(Boolean s) {
        return s != null;
    }

    public static boolean isAvailable(Double s) {
        return s != null;
    }

    public static boolean isAvailable(DateRange s) {
        return s != null;
    }

    public static String likeQuery(String key, String value) {
        return (isAvailable(value) ? " " + key + " LIKE '%" + value + "%' " + AND : "");
    }

    public static String equalQuery(String key, String value) {
           return (isAvailable(value) ? " " + key + " = '" + value + "' " + AND : "");
       }

    public List<Opportunity> filter(String opportunityName, String opportunityId,
                                    String stageName, String ownerId,
                                    Boolean fetchClosedOpportunity, String accountId,
                                    Double probabilityGreaterThan, Double probabilityLessThan,
                                    DateRange closeDateTimeRange) throws InterruptedException, ExecutionException, IOException {
        String bigQuery = "Select " + query + " from Opportunity WHERE "
                + likeQuery("name", opportunityName)
                + likeQuery("StageName", stageName)
                + equalQuery("OwnerId", ownerId)
                + equalQuery("Id", opportunityId)
                + equalQuery("AccountId", accountId)
                + (isAvailable(fetchClosedOpportunity) ? " isClosed = " + fetchClosedOpportunity+ AND : "")
                + (isAvailable(probabilityGreaterThan) ? " probability > " + probabilityGreaterThan+ AND : "")
                + (isAvailable(probabilityLessThan) ? " probability < " + probabilityLessThan + AND: "")
                + (isAvailable(closeDateTimeRange) ? " CloseDate >= " + DatePlus.getYYYYMMDD(closeDateTimeRange.from) + " AND CloseDate <=" + DatePlus.getYYYYMMDD(closeDateTimeRange.to) : "");

        bigQuery =  removeEndsWith(bigQuery,"WHERE ");
        bigQuery =removeEndsWith(bigQuery,AND)+" ORDER BY LastModifiedDate";
       // System.out.println(bigQuery);
        String res = salesforceUtil.getRecordByQuery(bigQuery.trim());
      //  System.out.println(res);
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static String removeEndsWith(String s, String val) {
            if (s.endsWith(val)) {
                int index = s.lastIndexOf(val);
                if (index > 0) {
                    return s.substring(0, index);
                }
            }
            return s;
        }

    public List<Opportunity> getOpportunityByOwnerID(String ownerID, long size, long page) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where OwnerId = '" +
                        ownerID.trim() + "' ORDER BY Name LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByOwnerID(String ownerID) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery("Select " + query + " from Opportunity where OwnerId = '" + ownerID.trim() + "'");
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByStatus(String opportunityStatus) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where StageName LIKE '%" +
                        opportunityStatus + "%'");
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByAccountId(String accountId) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity where AccountId ='" +
                        accountId + "'");
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<Opportunity> getOpportunityByQuery(String query) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(query);
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.size() > 0) {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public OAuth20Service getoAuthService() {
        return authUtil.getoAuthService();
    }



    public void updateOpportunity(Opportunity updatedOpportunity) throws InterruptedException, ExecutionException, IOException, IllegalAccessException {
        if (updatedOpportunity.id == null || updatedOpportunity.id.isEmpty())
            throw new RuntimeException("Opportunity Id cant be empty");
        SFOpportunity updatedopportunity = SFOpportunity.from(updatedOpportunity);
        SFOpportunity oldOpportunity1 = SFOpportunity.from(getOpportunityById(updatedopportunity.id));
        Map<String, String> diff = SalesforceUtil.getDifference(oldOpportunity1, updatedopportunity);
        salesforceUtil.updateRecord(updatedopportunity.id, gson.toJson(diff), OPPORTUNITY);
    }

    public Opportunity getOpportunityById(String opportunityId) throws InterruptedException, ExecutionException, IOException {
        return SFOpportunity.to(gson.fromJson(salesforceUtil.getRecordById(opportunityId, OPPORTUNITY), SFOpportunity.class));
    }

    public CreateRecordResponse addOpportunity(Opportunity opportunity) throws InterruptedException, ExecutionException, IOException {
        SFOpportunity opportunity1 = SFOpportunity.from(opportunity);
        if (opportunity1.Pricebook2Id == null) {
            List<SFPriceBook2> pb = PriceBook2Util.getPricebookEntrys(salesforceUtil);
            if (!pb.isEmpty())
                opportunity1.Pricebook2Id = pb.get(0).Id;
        }
        return gson.fromJson(salesforceUtil.createRecord(gson.toJson(opportunity1), OPPORTUNITY), CreateRecordResponse.class);
    }


    public List<SalesPipelineSummary> getSalesPipelinedSummary() throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery("  SELECT  StageName, AVG(Amount)  Average, SUM(AMOUNT)  Total from Opportunity GROUP BY StageName ");
        SalesforceListResponse<OpportunityStageNameAvgSum> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<OpportunityStageNameAvgSum>>() {
                }.getType());
        if (!oppList.records.isEmpty()) {
            return oppList.records.stream().map(OpportunityStageNameAvgSum::to).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public Long getYTDClosedSumByOwnerId(String ownerId) throws InterruptedException, ExecutionException, IOException {
        String aggRes = salesforceUtil.getRecordByQuery("SELECT ownerid, owner.name, SUM(AMOUNT) Total from Opportunity where IsClosed = true AND CALENDAR_YEAR(CloseDate) = " + Calendar.getInstance().get(Calendar.YEAR) + " GROUP BY ownerid, owner.name Having ownerid = '" + ownerId + "'");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        List<SFAggOpportunityOwnerTotal> list = oppList.records;
        if (list.isEmpty()) return 0L;
        return Math.round(list.stream().findFirst().get().Total);
    }

    public List<SFAggOpportunityOwnerTotal> getYTDClosedSum() throws InterruptedException, ExecutionException, IOException {
        String aggRes = salesforceUtil.getRecordByQuery("SELECT ownerid, owner.name, SUM(AMOUNT) Total from Opportunity where IsClosed = true AND CALENDAR_YEAR(CloseDate) = " + Calendar.getInstance().get(Calendar.YEAR) + " GROUP BY ownerid, owner.name ");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        return oppList.records;
    }

    public Long getQuaterClosedSumByOwnerId(String ownerId) throws InterruptedException, ExecutionException, IOException {
        String aggRes = salesforceUtil.getRecordByQuery("SELECT ownerid, owner.name,SUM(AMOUNT) Total from Opportunity where IsClosed = true AND CloseDate=THIS_QUARTER GROUP BY ownerid, owner.name  Having ownerid = '" + ownerId + "'");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        List<SFAggOpportunityOwnerTotal> list = oppList.records;
        if (list.isEmpty()) return 0L;
        return Math.round(list.stream().findFirst().get().Total);
    }

    public List getQuaterClosedSum() throws InterruptedException, ExecutionException, IOException {
        String aggRes = salesforceUtil.getRecordByQuery("SELECT ownerid, owner.name,SUM(AMOUNT) Total from Opportunity where IsClosed = true AND CloseDate=THIS_QUARTER GROUP BY ownerid, owner.name");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        return oppList.records;

    }

    public Long getProjectedQuaterSumIsNotClosed() throws InterruptedException, ExecutionException, IOException {
        // calculate sum of all stage
        String aggRes = salesforceUtil.getRecordByQuery("SELECT SUM(AMOUNT) Total from Opportunity where IsClosed = false AND CloseDate=THIS_QUARTER GROUP BY STAGENAME");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        List<SFAggOpportunityOwnerTotal> list = oppList.records;
        if (list.isEmpty()) return 0L;
        else return Math.round(list.stream().map(r -> r.Total).mapToDouble(Double::doubleValue).sum());
    }

    public Long getProjectedSumWithoutCloseDate() throws InterruptedException, ExecutionException, IOException {
        // calculate sum of all stage
        String aggRes = salesforceUtil.getRecordByQuery("SELECT SUM(AMOUNT) Total from Opportunity where IsClosed = false GROUP BY STAGENAME");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        List<SFAggOpportunityOwnerTotal> list = oppList.records;
        if (list.isEmpty()) return 0L;
        else return Math.round(list.stream().map(r -> r.Total).mapToDouble(Double::doubleValue).sum());
    }

    public List getCurrentQuaterQuota() throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery("SELECT QuotaOwner.Name, QuotaAmount FROM ForecastingQuota where startdate=THIS_QUARTER");
        SalesforceListResponse<Quota.SFQuota> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<Quota.SFQuota>>() {
                }.getType());
        List<Quota.SFQuota> list = oppList.records;
        return list.stream().map(Quota.SFQuota::to).collect(Collectors.toList());
    }

    public List<Opportunity> getModifiedOpportuniesByLastDays(int days) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity WHERE LastModifiedDate = LAST_N_DAYS:" + days);
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        }
    }

    public List<Opportunity> getNewOpportuniesByLastDays(long days) throws InterruptedException, ExecutionException, IOException {
        String res = salesforceUtil.getRecordByQuery(
                "Select " + query + " from Opportunity WHERE CreatedDate = LAST_N_DAYS:" + days);
        SalesforceListResponse<SFOpportunity> oppList =
                gson.fromJson(res, new TypeToken<SalesforceListResponse<SFOpportunity>>() {
                }.getType());
        if (oppList.records.isEmpty()) {
            return new ArrayList<>();
        } else {
            return oppList.records.stream().map(SFOpportunity::to).collect(Collectors.toList());
        }
    }

    public Long getRevenueClosedThisQuater() throws InterruptedException, ExecutionException, IOException {
        // calculate sum of all stage
        String aggRes = salesforceUtil.getRecordByQuery("SELECT SUM(ExpectedRevenue) Total from Opportunity where IsClosed = true AND CloseDate=THIS_QUARTER GROUP BY STAGENAME");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        List<SFAggOpportunityOwnerTotal> list = oppList.records;
        if (list.isEmpty()) return 0L;
        else return Math.round(list.stream().map(r -> r.Total).mapToDouble(Double::doubleValue).sum());
    }

    public Long getRevenueNotClosedThisQuater() throws InterruptedException, ExecutionException, IOException {
        // calculate sum of all stage
        String aggRes = salesforceUtil.getRecordByQuery("SELECT SUM(ExpectedRevenue) Total from Opportunity where IsClosed = false AND CloseDate=THIS_QUARTER GROUP BY STAGENAME");
        SalesforceListResponse<SFAggOpportunityOwnerTotal> oppList =
                gson.fromJson(aggRes, new TypeToken<SalesforceListResponse<SFAggOpportunityOwnerTotal>>() {
                }.getType());
        List<SFAggOpportunityOwnerTotal> list = oppList.records;
        if (list.isEmpty()) return 0L;
        else return Math.round(list.stream().map(r -> r.Total).mapToDouble(Double::doubleValue).sum());
    }

    public CreateRecordResponse addProductToOpportunity(Opportunity quote, PricebookEntry pbe) throws InterruptedException, ExecutionException, IOException {
        Map<String, String> map = new HashMap<>();
        map.put("QuoteId", quote.id);
        map.put("Quantity", "12");
        map.put("PricebookEntryId", PricebookEntryUtil.addOrGetPriceBookEntry(salesforceUtil, quote.Pricebook2Id, pbe));
        map.put("Product2Id", pbe.productId);
        map.put("UnitPrice", String.valueOf(pbe.unitPrice));
        return gson.fromJson(salesforceUtil.createRecord(new Gson().toJson(map), "OpportunityLineItem"), CreateRecordResponse.class);

    }


    public String get() throws InterruptedException, ExecutionException, IOException {
        // return salesforceUtil.getRecordByQuery("  SELECT  SUM(AMOUNT)  Total from Opportunity GROUP BY STAGENAME  Having STAGENAME LIKE '" + stageName + "%'");
        return salesforceUtil.getRecordByQuery("  SELECT  Name,StageName,closedate from Opportunity WHERE LastModifiedDate = LAST_N_DAYS:7");
        //  return salesforceUtil.getRecordByQuery("  SELECT Id, Name FROM Opportunity WHERE HasOpportunityLineItem = true ");
        //SELECT Opportunity.Id, OpportunityLineItem.Id, OpportunityLineItemSchedule.Id FROM Opportunity, OpportunityLineItem, OpportunityLineItemSchedule WHERE Opportunity.HasOpportunityLineItem = 'true' AND OpportunityLineItem.HasRevenueSchedule = 'true' AND Opportunity.Id = '00000000aaaa' AND OpportunityLineItem.OpportunityId = Opportunity.Id AND OpportunityLineItemSchedule.OpportunityLineItemId = OpportunityLineItem.Id
        // return salesforceUtil.getRecordByQuery("SELECT QuotaOwner.Name, QuotaAmount FROM ForecastingQuota where startdate=THIS_QUARTER");
        //return salesforceUtil.getRecordByQuery("SELECT Id from OpportunityLineItem where OpportunityId='0065w000022unHCAAY'");
        //return salesforceUtil.getRecordByQuery("SELECT Id, ScheduleDate, Revenue from OpportunityLineItemSchedule ");
        // return salesforceUtil.getRecordByQuery("SELECT SUM(ExpectedRevenue) Total from Opportunity where IsClosed = false AND CloseDate=THIS_QUARTER GROUP BY STAGENAME");
    }

    //SELECT Id, QuotaOwnerId, QuotaAmount, QuotaOwner.Name, ForecastingTypeId, PeriodId FROM ForecastingQuota

    //SELECT sum(Revenue) FROM OpportunityLineItemSchedule where OpportunityLineItem.Opportunity.StageName in ('Closed Won','Contract','Pricing','Trial','Contract Signed','Schedule Variation Open','Schedule Variation–Signed') and ScheduleDate =THIS_QUARTER
}