import java.util.HashMap;
import java.util.Map;
import com.extensions.domains.development.bitbucket.oAuth.AccessToken;
import com.extensions.domains.development.bitbucket.oAuth.OAuthClient;
import com.extensions.domains.development.bitbucket.util.RepositoryUtil;
import com.extensions.domains.development.bitbucket.util.RestClient;
import org.codehaus.jettison.json.JSONException;

public class DevelopmentExtensionRunner {

    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String CLIENT_ID = "clientId";
    private static final String CLIENT_SECRET = "clientSecret";

    public static void main(String[] args) throws Exception {
        String clientId = "UEZREDt99hXWtGPhU";
        String clientSecret = "Rfx66CVZZdp33pYWcvbd5NSxqcRefL5";
        OAuthClient oAuthClient;
        Map<String, Object> conAttr = new HashMap<>();

        conAttr.put(CLIENT_ID, "7naVAVfu7KSqMdnhG");
        conAttr.put(CLIENT_SECRET, "Zp85QwNac6zWb9Ra9LH2pHfMYHBg82w");
        conAttr.put(REFRESH_TOKEN, "VzbWv9caRzUJ9VsRT");

        oAuthClient = new OAuthClient((String) conAttr.get(CLIENT_ID), (String) conAttr.get(CLIENT_SECRET));
        System.out.println(RepositoryUtil.getAll(getRestClient(oAuthClient)));
        // System.out.println(PullRequestUtil.getAll(getRestClient(), repositoryFullName));
    }

    private static RestClient getRestClient(OAuthClient oAuthClient) throws JSONException {
        String refreshToken = "VzbWv9caRzUJ9sCRT";
        AccessToken accessToken = oAuthClient.refreshAccessToken(refreshToken);

        return new RestClient(accessToken.access_token);
    }

}