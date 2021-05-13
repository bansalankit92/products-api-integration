import java.util.HashMap;
import java.util.Map;
import com.extensions.domains.development.util.BranchUtil;
import com.extensions.domains.development.util.OAuthUtil;

public class DevelopmentExtensionRunner {

    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String CALLBACK_URI = "callbackUri";
    public static final String ACCESS_TOKEN = "access_token";

    public static final String GITHUB_URL = "https://api.github.com";

    public static void main(String[] args) throws Exception {
        Map<String, Object> conAttr = new HashMap<>();
        //githubapp
//
        //oauthapp
        conAttr.put(CLIENT_ID, "765a02a4330a78a");
        conAttr.put(CLIENT_SECRET, "77dea5973f3edca795898ea35346b00955f1");
        // conAttr.put(REFRESH_TOKEN, "r1.576a8733bb67122e1ee32315b79f7802beada6d588f6b8b02f88caf8c384c8ef9b85ed0b8e81193f");
        conAttr.put(CALLBACK_URI, "https://demo2.com/rpc/v1/extension/oauth");
        conAttr.put(ACCESS_TOKEN, "e1ff7c4f0c1a02f12df67dd3573266ba");

        OAuthUtil oAuthUtil = new OAuthUtil(conAttr);
        // System.out.println(new Gson().toJson(RepositoryUtil.getAllUserRepositories(oAuthUtil)));
        System.out.println((BranchUtil.getBranches(oAuthUtil, "bansalankit92/personalsite", "", 1, 3)));
        //  System.out.println(new Gson().toJson(BranchUtil.getBranches(oAuthUtil,"bansalankit92/personalsite","new",1,5)));
        // System.out.println(PullRequestUtil.createPR(oAuthUtil,"bansalankit92/personalsite","created pr via api","pr","develop","nothing"));
//        System.out.println(new Gson().toJson(PullRequestUtil.mergePR(oAuthUtil,"bansalankit92/personalsite",2,"merged via api")));
//          System.out.println(new Gson().toJson(PullRequestUtil.getPR(oAuthUtil,"bansalankit92/personalsite",1,10)));

        // System.out.println(impl.getRepositoriesString(new ConversationContext()));
        //"app/risgrand"
        //  System.out.println(impl.entitySelectorForPullRequest("personalsite 1","Repository Name Space Pull Request Id",1l,1l));
//           System.out.println(impl.entitySelectorForPullRequest(new ConversationContext(),"extension 23","Repository Name Space Pull Request Id",1l,1l));
//          System.out.println(impl.entitySelectorForPullRequest("Ankit","Author Name",1l,1l));
        //   System.out.println(impl.entitySelectorForCodeRepositoryBranch("personalsite dev","Author Name",1l,1l));

        //   System.out.println(impl.fetchPullRequestByPrimaryKey("Extensions==23"));
        //  System.out.println(impl.createCodeRepositoryBranch("app/extensions","develop", "newbranchfromapi1"));
        //  System.out.println(impl.createPullRequest("app/risgrand","DO NOT MERGE - created pr from api", "hotfix/multi-entityselector", "develop") );
        // System.out.println(impl.getRawBranch(new ConversationContext(),"app/extensions","newbranchfromapi"));
        //      System.out.println(impl.getCodeRepositoryBranches("app/extensions")  );
    }

}