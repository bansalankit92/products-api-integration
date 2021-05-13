package com.extensions.domains.sales.model;

import java.util.Date;

public class SCampaign {
    String Id, Name, ParentId, Type, Status, Description, StartDate, EndDate;
    Long ExpectedRevenue, BudgetedCost, ActualCost, ExpectedResponse, NumberSent;
    Long NumberOfLeads, NumberOfConvertedLeads, NumberOfContacts, NumberOfResponses,
            NumberOfOpportunities, NumberOfWonOpportunities, AmountAllOpportunities,
            AmountWonOpportunities;
    String OwnerId, CreatedById, LastModifiedById, CampaignMemberRecordTypeId;
    Date CreatedDate, LastModifiedDate;

}