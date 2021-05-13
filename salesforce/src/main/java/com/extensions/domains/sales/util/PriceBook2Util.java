package com.extensions.domains.sales.util;

import com.extensions.domains.sales.model.SFPriceBook2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PriceBook2Util {
    private static Gson gson = new Gson();
       public static final String PRICEBOOK_ENTRY = "Pricebook2";
       public static final String QUERY_FIELDS = " Id,Name ";


       public static List<SFPriceBook2> getPricebookEntrys(SalesforceUtil salesforceUtil) throws InterruptedException, ExecutionException, IOException {
           String res = salesforceUtil.getRecordByQuery(
                   "Select " + QUERY_FIELDS + " from Pricebook2 where Name='Standard'");
           SalesforceListResponse<SFPriceBook2> oppList =
                   gson.fromJson(res, new TypeToken<SalesforceListResponse<SFPriceBook2>>() {
                   }.getType());
           System.out.println(res);
           if (oppList.records.size() > 0) {
               return oppList.records;
           } else {
               return new ArrayList<>();
           }
       }
}