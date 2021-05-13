import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.integration.extensions.domains.sonarqube.impl.SonarqubeExtensionImpl;
import com.integration.util.RestClient;

public class SonarqubeRunner {

    private static String token;

    public static void main(String[] args) throws Exception {
        SonarqubeExtensionImpl impl = new SonarqubeExtensionImpl();
        Map<String, Object> attr = new HashMap<>();
        final String host = "http://localhost:9000";
        attr.put(SonarqubeExtensionImpl.HOST_URL, host);
        token = "059a6afaec7b3f1b075a3cb0f7980350f8aa42ec";
        attr.put(SonarqubeExtensionImpl.ACCESS_TOKEN, token);
        impl.init(attr);
        final String projectKey = "extension-jira";
        RestClient restClient = new RestClient(host, token);
        // System.out.println(new Gson().toJson(SonarqubeUtil.getProjects(restClient,"",1,10)));

        //System.out.println(new Gson().toJson(SonarqubeUtil.getMetrics(restClient, projectKey)));

        System.out.println(new Gson().toJson(impl.getBugs(projectKey)));
        System.out.println(new Gson().toJson(impl.getFilesWithDuplicateCode(projectKey)));
    }

}