package com.integration.extensions.domains.sumologic.model;

import com.integration.extensions.domains.sumologic.SearchJobStatus;

import java.util.ArrayList;
import java.util.Arrays;

public class SlSearchJobStatus {

//      public List pendingWarnings;
//
//      public List pendingErrors;

      public SlHistogramBuckets[] histogramBuckets;

      public Double record;

      public Double messageCount;

      public String state;


      public SearchJobStatus to(){
            SearchJobStatus status = new SearchJobStatus();
            status.state = state;
            if (histogramBuckets!=null && histogramBuckets.length>0)
            status.histogramBuckets = Arrays.asList(histogramBuckets);
            status.messageCount = messageCount;
            status.record  =record;
            status.pendingErrors = new ArrayList();
            status.pendingWarnings = new ArrayList();
            return status;
      }

}