
import com.integration.extensions.domains.sales.util.QuotesUtil;
import com.integration.extensions.domains.sales.util.SugarcrmUtil;
import com.integration.util.Base64Plus;

import java.util.HashMap;
import java.util.Map;

import static com.integration.util.RestClient.*;

public class SugarCrmSalesRunner {
    public static void main(String[] args) throws Exception {
        // http://www.jsonschema2pojo.org/

        final String clientId = "sugar";
        final String clientSecret = "";
        final String username = "admin";
        final String password = "asdf";
        final String url = "https://sg-baseline101.demo.sugarcrm.com";
        // YWRtaW46YXNkZg==
        final String base64 = Base64Plus.encode(new Base64Plus.UsernamePassword(username, password));

        Map<String, Object> context = new HashMap<>();
        context.put(CLIENT_ID, clientId);
        context.put(CLIENT_SECRET, clientSecret);
        context.put(USERNAME_PASSWORD, base64);
        context.put(HOST_URL, url);

        System.out.println(base64);
        System.out.println(Base64Plus.decode(base64));

        //        Opportunity opportunity = new Opportunity();
        //        opportunity.name = "Antbrains New";
        //        opportunity.closeDate = "2020-10-10";
        //        opportunity.stageName = "New";
        //        opportunity.amount = "5000";
        //        opportunity.probability = "5";
        //        impl.addOpportunity(new ConversationContext(), opportunity);

        SugarcrmUtil util = new SugarcrmUtil(context);
      //  System.out.println(gson.toJson(impl.getOpportunityByUser("NA")));
        // System.out.println(util.search(OpportunityUtil.OPPORTUNITY,"name", "Q3 ARVRO III PR - $7174 - New - 297 Units"));
        //System.out.println(util.getMe());
        //System.out.println(OpportunityUtil.getOpportunityByName(util, "Q3"));

      // System.out.println(util.get("Accounts"));
     //   System.out.println(util.get("Leads"));
//        System.out.println(util.get("Users"));
//        System.out.println(util.get("Quotes"));
//        System.out.println(util.get("ProductTemplates"));
       // System.out.println(util.get("Campaigns"));
        //System.out.println(util.get("Reports"));

      //  System.out.println(util.getById("Reports","3851297c-83cc-11e8-b846-0211b31cacdf/chart"));
        //System.out.println(util.getById("Reports","3851297c-83cc-11e8-b846-0211b31cacdf/records"));
        //System.out.println(util.getById("Reports","3851297c-83cc-11e8-b846-0211b31cacdf/record_count"));

   //     System.out.println(new Gson().toJson(impl.updateOpportunityStatusByName("AD Importing Company Inc ","Needs Analysis")));
    //    System.out.println(new Gson().toJson(AccountUtil.getAccountById(util,"99b819a8-ee6b-11ea-bc64-063b0cd98a86")));

        System.out.println((QuotesUtil.getQuotesByOpportunityName(util,"Spend Thrift",10,1)));

    }
}