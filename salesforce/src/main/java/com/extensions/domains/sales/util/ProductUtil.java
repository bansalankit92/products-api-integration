package com.extensions.domains.sales.util;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ProductUtil {
    private static Gson gson = new Gson();
       public static final String PRICEBOOK_ENTRY = "PricebookEntry";
       public static final String QUERY_FIELDS = " Id,Name,ProductCode,Description,QuantityScheduleType,QuantityInstallmentPeriod,NumberOfQuantityInstallments,RevenueScheduleType,RevenueInstallmentPeriod,NumberOfRevenueInstallments,CanUseQuantitySchedule,CanUseRevenueSchedule,IsActive,CreatedDate,CreatedById,LastModifiedDate,LastModifiedById,SystemModstamp,Family,ExternalDataSourceId,ExternalId,DisplayUrl,QuantityUnitOfMeasure,IsDeleted,IsArchived,LastViewedDate,LastReferencedDate,StockKeepingUnit ";

       //

       public static String getProductss(SalesforceUtil salesforceUtil, long size, long page) throws InterruptedException, ExecutionException, IOException {
           String res = salesforceUtil.getRecordByQuery(
                   "Select " + QUERY_FIELDS + " from Products ORDER BY LastModifiedDate DESC LIMIT " + size + " OFFSET " + Math.max((page - 1) * size, 0));
          return res;
       }

}