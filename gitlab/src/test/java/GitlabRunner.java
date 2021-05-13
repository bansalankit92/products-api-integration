import java.util.HashMap;
import java.util.Map;
import com.extensions.domains.development.util.OAuthUtil;
import com.extensions.domains.development.util.RepositoryUtil;
import com.google.gson.Gson;

import static com.extensions.domains.development.util.OAuthUtil.*;

public class GitlabRunner {

      public static void main(String[] args) throws Exception {
        Map<String, Object> conAttr = new HashMap<>();
         conAttr.put(CLIENT_ID, "765a02a433e50a78a");
        conAttr.put(CLIENT_SECRET, "77dea5973f3edca79589857a35346b00955f1");
        // conAttr.put(REFRESH_TOKEN, "r1.576a8733bb67122e1ee32315802beada6d588f6b8b02f88caf8c384c8ef9b85ed0b8e81193f");
        conAttr.put(CALLBACK_URI, "https://demo2.com/rpc/v1/extension/oauth");
        conAttr.put(ACCESS_TOKEN, "d720854d0c5eadb7c702323edf9d744e4c3549cec4c065aa35f14700340");

        OAuthUtil oAuthUtil = new OAuthUtil(conAttr);
        System.out.println(new Gson().toJson(RepositoryUtil.getUserRepositories(oAuthUtil, "")));

        // System.out.println(new Gson().toJson(RepositoryUtil.getRepoByFullName(oAuthUtil,"ankban/krista-sample")));

        //  System.out.println(new Gson().toJson((BranchUtil.getBranches(oAuthUtil,"ankban/krista-sample","1"))));
        // System.out.println(new Gson().toJson(impl.createCodeRepositoryBranch("ankban/krista-sample","master","new-develop1")));
        //  System.out.println(new Gson().toJson(BranchUtil.getBranches(oAuthUtil,"bansalankit92/personalsite","new",1,5)));
        //    System.out.println(PullRequestUtil.getGPRs(oAuthUtil,""));
        //

    }

}