import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.extensions.domains.development.util.GitlabApi20;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class OAuth2GetRefreshToken {
    public static void main(String... args) throws IOException, InterruptedException, ExecutionException {
        // Replace these with your client id and secret
        //githubapp
//           final String clientId = "Iv1.c29815c770b24f09";
//           final String clientSecret = "06dc07bcacf871fd55c86fa20f15cbf43dc9524d";
        // oauth app
        final String clientId = "0596ee2934c88ac7546cf265a2c02b9233bfc7fe015d9186c89afa2b7a7c0b73";
        final String clientSecret = "79e88c9c5866aa39eff7fd71f95850b3a79d6ed68aca790edea1627938eab0ec";


        final String secretState = "secret" + new Random().nextInt(999_999);
        final OAuth20Service service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .defaultScope("api")
                .callback("https://demo2-kristaclient.antbrains.com/api/rpc/v1/extension/oauth")
                .build(GitlabApi20.instance("https://gitlab.com"));
        final Scanner in = new Scanner(System.in, "UTF-8");

        System.out.println();

        // Obtain the Authorization URL
        System.out.println("Fetching the Authorization URL...");
        final String authorizationUrl = service.getAuthorizationUrl()+"&grant_type=authorization_code&access_type=offline&prompt=consent";
        System.out.println("Got the Authorization URL!");
        System.out.println("Now go and authorize ScribeJava here:");
        System.out.println(authorizationUrl);
        System.out.println("And paste the authorization code here");
        System.out.print(">>");
        final String code = in.nextLine();
        System.out.println();


        System.out.println("Trading the Authorization Code for an Access Token...");
        final OAuth2AccessToken accessToken = service.getAccessToken(code);
        System.out.println("Got the Access Token!");
        System.out.println("(The raw response looks like this: " + accessToken.getRawResponse() + "')");
        System.out.println();

        // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");
        final OAuthRequest request = new OAuthRequest(Verb.GET, "https://gitlab.com/api/v4/user");
        service.signRequest(accessToken, request);
        try (Response response = service.execute(request)) {
            System.out.println("Got it! Lets see what we found...");
            System.out.println();
            System.out.println(response.getCode());
            System.out.println(response.getBody());
        }
        System.out.println();
        System.out.println("Thats it man! Go and build something awesome with ScribeJava! :)");
    }
}