import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class GoogleAuthRunner {

    private static final String NETWORK_NAME = "Google";
        private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v3/userinfo";

        private GoogleAuthRunner() {
        }

        @SuppressWarnings("PMD.SystemPrintln")
        public static void main(String... args) throws IOException, InterruptedException, ExecutionException {
            // Replace these with your client id and secret
            final String clientId = "213597343695-tso0nb0om1977u2rtd4ls0323cl5mlts.apps.googleusercontent.com";
            final String clientSecret = "5bcuNcFumMyKxOyhwEEm06i-";
            final String secretState = "secret" + new Random().nextInt(999_999);
            final OAuth20Service service = new ServiceBuilder(clientId)
                    .apiSecret(clientSecret)
                    .defaultScope("openid profile email") // replace with desired scope
                   // .callback("https://studio.demo.krista.app/callback")
                    .callback("https://studio.demo.krista.app/api/rpc/v1/extension/oauth")
                    .build(GoogleApi20.instance());
            final Scanner in = new Scanner(System.in, "UTF-8");

            System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
            System.out.println();

            // Obtain the Authorization URL
            System.out.println("Fetching the Authorization URL...");
            //pass access_type=offline to get refresh token
            //https://developers.google.com/identity/protocols/OAuth2WebServer#preparing-to-start-the-oauth-20-flow
            final Map<String, String> additionalParams = new HashMap<>();
            additionalParams.put("access_type", "offline");
            //force to reget refresh token (if user are asked not the first time)
            additionalParams.put("prompt", "consent");
            final String authorizationUrl = service.createAuthorizationUrlBuilder()
                    .state(secretState)
                    .additionalParams(additionalParams)
                    .build();
            System.out.println("Got the Authorization URL!");
            System.out.println("Now go and authorize ScribeJava here:");
            System.out.println(authorizationUrl);
            System.out.println("And paste the authorization code here");
            System.out.print(">>");
            final String code = in.nextLine();
            System.out.println();

            System.out.println("And paste the state from server here. We have set 'secretState'='" + secretState + "'.");
            System.out.print(">>");
            final String value = in.nextLine();
            if (secretState.equals(value)) {
                System.out.println("State value does match!");
            } else {
                System.out.println("Ooops, state value does not match!");
                System.out.println("Expected = " + secretState);
                System.out.println("Got      = " + value);
                System.out.println();
            }

            System.out.println("Trading the Authorization Code for an Access Token...");
            OAuth2AccessToken accessToken= service.getAccessToken(code);
            System.out.println("Got the Access Token!");
            System.out.println("(The raw response looks like this: " + accessToken.getRawResponse() + "')");

            System.out.println("Refreshing the Access Token...");
            accessToken = service.refreshAccessToken("1//0gZMcYLihzCO7CgYIARAAGBASNwF-L9IrmF8XW_Vct0x-gs3Ze1ciOhux-zwsE_7VI8189gcxvCNRktIpiRh-LhnS83azy7g-36Y");//accessToken.getRefreshToken());
            System.out.println("Refreshed the Access Token!");
            System.out.println("(The raw response looks like this: " + accessToken.getRawResponse() + "')");
            System.out.println();

            // Now let's go and ask for a protected resource!
            System.out.println("Now we're going to access a protected resource...");
//            while (true) {
//                System.out.println("Paste fieldnames to fetch (leave empty to get profile, 'exit' to stop example)");
//                System.out.print(">>");
//                final String query = in.nextLine();
//                System.out.println();
//
//                final String requestUrl;
//                if ("exit".equals(query)) {
//                    break;
//                } else if (query == null || query.isEmpty()) {
//                    requestUrl = PROTECTED_RESOURCE_URL;
//                } else {
//                    requestUrl = PROTECTED_RESOURCE_URL + "?fields=" + query;
//                }
//
//                final OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl);
//                service.signRequest(accessToken, request);
//                System.out.println();
//                try (Response response = service.execute(request)) {
//                    System.out.println(response.getCode());
//                    System.out.println(response.getBody());
//                }
//                System.out.println();
//            }
        }

//    {
//      "access_token": "ya29.a0AfH6SMDB-QJBiIvppvjdWrC_-vdL8evhMyCKBVYGr1FD6FD30maWZn1b3iXW-rNHrsOcNbu8AQYSIPkEqUJiw4WlF-a5MPwVMFlFReHCWyIf4uMj8jQAoACc4N0towUwWewERxXFpsbaIvgebgON_JEqNXzq1ea7T54m4zGO-Fs",
//      "expires_in": 3599,
//      "refresh_token": "1//0gPMvEXZkXOl-CgYIARAAGBASNwF-L9IrqcQzq_-MB6nlvNz8QXJOTAyrQ6fd4xmIiLAsIVRvkrZbsw9wOh1fr5mTFjSyHdCrSXc",
//      "scope": "https://www.googleapis.com/auth/userinfo.profile",
//      "token_type": "Bearer",
//      "id_token": "eyJhbGciOiJSUzI1NiIsImtpZCI6ImRlZGMwMTJkMDdmNTJhZWRmZDVmOTc3ODRlMWJjYmUyM2MxOTcyNGQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIyMTM1OTczNDM2OTUtdHNvMG5iMG9tMTk3N3UycnRkNGxzMDMyM2NsNW1sdHMuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIyMTM1OTczNDM2OTUtdHNvMG5iMG9tMTk3N3UycnRkNGxzMDMyM2NsNW1sdHMuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDQwMDMxNDUzMDczODk5MzkyMzgiLCJhdF9oYXNoIjoielhNM1dZQUgtSWs5dDYybjlGcFFFUSIsIm5hbWUiOiJBbmtpdCBCYW5zYWwiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDYuZ29vZ2xldXNlcmNvbnRlbnQuY29tLy0tWGVjOFU5cFVqZy9BQUFBQUFBQUFBSS9BQUFBQUFBQUFBQS9BTVp1dWNrcGNhN2k5a05GTHVGd1BZSUxhRnk2N0xwSUpnL3M5Ni1jL3Bob3RvLmpwZyIsImdpdmVuX25hbWUiOiJBbmtpdCIsImZhbWlseV9uYW1lIjoiQmFuc2FsIiwibG9jYWxlIjoiZW4iLCJpYXQiOjE2MDYxOTAwNTgsImV4cCI6MTYwNjE5MzY1OH0.VN_uJJLTf-sacVL89TV03ccSBA34ecVLl5xXSUv1QdT3rQ8ECUdfUii-4G-W9Conyo9iI6KYm9rjght6NbRt-qqBPI7a5ReiqaBvWjeYAX--oBnEbW4lJtZFuNmojq9AUFgVmMVo3VTrN1wuyK2t9XNLM7ixl3gl_BKHblEx2F7jetBH4IIm7BGnYTb6kLpuOizA3QwCvnh02HhVIP0BbUWRrB3GlSgkFaofnH1CT242pZhZ_n8zyBtjsLayV3amHp2ebb7gQiuySuLromrzo9n70I8FY0M_pSnT6tezp_eros0nQN2SoEOYIrcQLi8wtTMc9arexciYDHLBEaej7A"
//    }')
}