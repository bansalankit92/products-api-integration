package com.extensions.domains.sales.impl;


import com.extensions.domains.sales.util.SalesforceUtil;

import java.util.HashMap;
import java.util.Map;

import static com.extensions.domains.sales.util.OAuthUtil.*;

public class OpportunityExtensionImplTest {

    public static void main(String[] args) throws Exception {
        final String clientId = "3MVG95jctIhbyCprtzHqvP5ePGYyIyIeXcti8OuurZABonbl4VTRJ0U0LrO2xXN4y6NBQt1ZVh_Q5wv0HSc7B";
        final String clientSecret = "03ADDB5B2F7E0FF863BAC5D642599BD49215297830FEF65F9791AC56FA5D0464";
        final String callbackUri = "http://localhost:8000";
        Map<String, Object> context = new HashMap<>();
        context.put(CLIENT_ID, clientId);
        context.put(CLIENT_SECRET, clientSecret);
        context.put(CALLBACK_URI, callbackUri);
        //5Aep861Xq7VoDavIt7.izOIvQQ9J.D1n3heI2dMY7PpHp9.nMcRTePVHG6q.cKIJOImTPsDMgbG.G8ktLQqWn_T
        //"refresh_token": "5Aep861NEBUy_AOr1fcVycNKpcspX.wpZyK.B5rlxOOUjHaZfPPNfP7jdErtB0uSO68B1UPUCV7i9Y67iU.3NFz",
        context.put(REFRESH_TOKEN,
                "5Aep861NEBUy_AOr1fcVycNKpcspX.wpZyK.B5rlxOOUjHaZfPaykoQ9SU.KDAAaATwZjFl_wq5psd5axN3Ijzs");

//        Opportunity opportunity = new Opportunity();
//        opportunity.name = "Antbrains New";
//        opportunity.closeDate = "2020-10-10";
//        opportunity.stageName = "New";
//        opportunity.amount = "5000";
//        opportunity.probability = "5";
//        impl.addOpportunity(new ConversationContext(), opportunity);

        //   System.out.println(new Gson().toJson(impl.getOpportunitiesByName( "Antbrains")));

        //   List l = impl.entitySelectorForOpportunity(new ConversationContext(), "Ant", "Name", 10L, 1L);
        //   System.out.println(l.size() + "  " + l);
        //System.out.println(impl.updateOpportunity(new ConversationContext(),"my","Needs Analysis"));

//        String s = "{\"LastModifiedDate\":\"2020-08-04T07:35:43.000+0000\",\"ExpectedRevenue\":\"250.0\",\"OwnerId\":\"0055w00000D9a8iAAB\",\"StageName\":\"New\",\"Amount\":\"5000.0\",\"Probability\":\"5.0\",\"CreatedDate\":\"2020-08-04T07:35:43.000+0000\",\"Id\":\"0065w000024lAmfAAE\",\"CloseDate\":\"2020-10-10\",\"Name\":\"Antbrains New\"}";
//        Opportunity opportunity = new Gson().fromJson(s, Opportunity.class);
//        String s2 = "{\"LastModifiedDate\":\"2020-07-08T12:05:20.000+0000\",\"ExpectedRevenue\":\"400.0\",\"OwnerId\":\"0055w00000D9a8iAAB\",\"StageName\":\"New\",\"Amount\":\"4000.0\",\"Probability\":\"10.0\",\"CreatedDate\":\"2020-07-08T12:05:20.000+0000\",\"Id\":\"0065w000022unHCAAY\",\"CloseDate\":\"2020-10-10\",\"Name\":\"Antbrains\"}";
//        Opportunity opportunity2 = new Gson().fromJson(s2, Opportunity.class);
//        impl.updateStatusOfOpportunities(new ConversationContext(), List.of(opportunity, opportunity2), "New");
//        System.out.println(OpportunityUtil.getDifference(opportunity,opportunity2));
        //  System.out.println(new Gson().toJson(impl.fetchOpportunityByPrimaryKey(new ConversationContext(),"0065w000024BdAJAA0")));
        SalesforceUtil util = new SalesforceUtil(context);
        //System.out.println(util.getObjects());
//         System.out.println(util.getRecordById("0015w00002DTC0DAAX","Account"));
          System.out.println(util.getRecordById("0065w000024sg2NAAQ","Opportunity"));
        // System.out.println(util.getRecordById("00Q5w00001sSQJvEAO","Lead"));
        // System.out.println(util.getRecordById("00k5w00001gZ1pyAAC","OpportunityLineItem"));

        //System.out.println(util.getRecordById("0055w00000D9a8iAAB","User"));
        //  System.out.println(util.getRecordById("0J95w0000012YkhCAE","ForecastingQuota"));
        //System.out.println(util.getRecordById("7015w000001YZEvAAO","Campaign"));
        //   System.out.println(util.getRecordById("5005w00001cxkBQAAY","Case"));

        //  System.out.println(new Gson().toJson(impl.salesPipelineSummary()));
        // System.out.println((impl.get("Closed")));
        //
        //{"totalSize":11,"done":true,"records":[{"attributes":{"type":"AggregateResult"},"StageName":"Prospecting","Average":157200.0,"Total":786000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Needs Analysis","Average":235000.0,"Total":235000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Value Proposition","Average":165000.0,"Total":330000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Id. Decision Makers","Average":36666.666666666664,"Total":110000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Perception Analysis","Average":120000.0,"Total":120000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Proposal/Price Quote","Average":185000.0,"Total":370000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Negotiation/Review","Average":197500.0,"Total":395000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Closed Won","Average":200588.23529411765,"Total":3410000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Closed","Average":15000.0,"Total":15000.0},{"attributes":{"type":"AggregateResult"},"StageName":"New","Average":2000.0,"Total":2000.0},{"attributes":{"type":"AggregateResult"},"StageName":"Qualifying","Average":2000.0,"Total":2000.0}]}
        //   OpportunityUtil opportunityUtil = new OpportunityUtil(context);
        //  System.out.println(opportunityUtil.getYTDClosedSumByOwnerId("0055w00000D9a8iAAB"));
        //  System.out.println(opportunityUtil.getYTDClosedSum());
//        System.out.println(opportunityUtil.getQuaterClosedSumByOwnerId("0055w00000D9a8iAAB"));
        // System.out.println(opportunityUtil.getProjectedSum());
        //System.out.println(util.getRecordByQuery("SELECT   AVG(Amount)  Average, SUM(AMOUNT)  Total from Opportunity GROUP BY StageName "));
        //  System.out.println(new Gson().toJson(opportunityUtil.getCurrentQuaterQuota()));

        //  System.out.println(util.getRecordById("0265w000001vcHkAAI","Period"));
        // System.out.println(opportunityUtil.get());
        // System.out.println(opportunityUtil.getModifiedOpportuniesByLastDays(7));

        //     System.out.println(new Gson().toJson(opportunityUtil.getOpportunityByAccountId("0015w00002BeJiNAAV")));
        // System.out.println(new Gson().toJson(opportunityUtil.getOpportunities(10,1)));

        //  System.out.println(new Gson().toJson(opportunityUtil.getOpportunityByOwnerID("0055w00000D9a8iAAB",10,1)));


        // System.out.println(UserUtil.getMe(util));

        // System.out.println(new Gson().toJson(LeadUtil.getLeads(util,10,1)));


        // System.out.println(util.getRecordById("00U5w00000jQGlrEAG","Event"));

//        System.out.println(util.getRecordById("01u5w00000SZuqSAAT","PricebookEntry"));
//        System.out.println(util.getRecordById("01t5w00000ErQqhAAF","Product2"));
//        System.out.println(util.getRecordById("01s5w0000069ocgAAA","Pricebook2"));

        // System.out.println(new Gson().toJson(PricebookEntryUtil.getPricebookEntrys(util,10,1)));
        // System.out.println(new Gson().toJson(impl.(util,10,1)));
//        Opportunity o = new Gson().fromJson("{\"type\":\"com.krista.entity.catEntryEcosystem_fab41fc5_343f_45c9_8fff_e0192ae06251.catEntryDomain_086f33da_aaea_4d0c_816f_3d5f20b4a273.localDomainEntity_011cea38_c7d1_40c1_99e3_295ab76af557\",\"Description\":\"Creating via krista\",\"Close Date\":\"2020-12-12\",\"Amount\":\"10000\",\"Probability\":\"10\",\"Stage Name\":\"New\",\"Name\":\"Krista Client CRM opportunity\"}",Opportunity.class);
//        System.out.println(new Gson().toJson(impl.addOpportunity(o)));

        //  System.out.println(util.getRecordById("0Q05w000001tDm1CAE","Quote")); //0Q05w000001tDm1CAE
        //  util.sendEmail("ankit@antbrains.com","via krista","Okay");

//        Lead lead = new Gson().fromJson("{\"type\":\"com.krista.entity.catEntryEcosystem_fab41fc5_343f_45c9_8fff_e0192ae06251.catEntryDomain_086f33da_aaea_4d0c_816f_3d5f20b4a273.localDomainEntity_8a95a02d_5afb_4fac_ae32_0976885c0446\",\"Status\":\"Working - Contacted\",\"Industry\":\"IT\",\"Is Converted\":false,\"Company\":\"ABC\",\"Email\":\"rahul@example.com\",\"Description\":\"Desc\",\"Title\":\"Okay\",\"Annual Revenue\":\"100000\",\"Name\":\"Rahul\"}",Lead.class);
//        System.out.println(new Gson().toJson(impl.createLead(lead)));

//        List<String> name =  new ArrayList<>(Arrays.asList("Ankit S Bansal".split("\\s+")));
//                    if (name.size()==1)
//                        System.out.println("lastname " + name.get(0));
//                    else {
//                        System.out.println("firstname " + name.get(0));
//                        name.remove(0);
//                        System.out.println("lastname " + String.join(" ", name)); ;
//                    }

        //  System.out.println(util.getRecordById("8005w000002IMYqAAO","Contract"));
//        Quote quote = new Quote();
//        quote.name = "SyncTech Devops";
//        quote.opportunityId="0065w000025e7GnAAI";
//        System.out.println(new Gson().toJson(QuoteUtil.addQuote(util,quote)));  //0Q05w000001tDm6CAE

        //  System.out.println(util.getRecordById("0QL5w000004CzqOGAS","QuoteLineItem"));
       //  System.out.println(new Gson().toJson(QuoteUtil.get(util)));


      //  System.out.println(new Gson().toJson(QuoteUtil.getQuoteLineItemByQuoteId(util,"0Q05w000001tDmBCAU")));
      //  System.out.println(new Gson().toJson(  impl.createAnOppotunity("SyncTech",1636720547000l,"Prospecting",100000.0,"","0015w00002BeJiNAAV") ));//0065w000025e7GnAAI

    }

}