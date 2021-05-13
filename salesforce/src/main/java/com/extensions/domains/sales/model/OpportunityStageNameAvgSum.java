package com.extensions.domains.sales.model;

import com.extensions.domains.sales.SalesPipelineSummary;

public class OpportunityStageNameAvgSum {

    public String StageName;
    public double Average, Total;

    public static SalesPipelineSummary to(OpportunityStageNameAvgSum avg){
        SalesPipelineSummary summary = new SalesPipelineSummary();
        summary.average = avg.Average;
        summary.status = avg.StageName;
        summary.total = avg.Total;
        return summary;
    }
}