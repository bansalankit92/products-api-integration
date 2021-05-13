import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.google.gson.Gson;
import com.integration.extensions.domains.greymatter.util.GreyMatterUtil;
import com.integration.util.MediaClient;
import com.integration.util.Oauth2RestClient;

import static com.integration.util.OAuthUtil.*;

public class GreyMatterRunner {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> attr = new HashMap<>();
        String hostUrl = "https://covidapihub.io/data/latest";
        String cookie =
                " access_token=ya29.A0AfH6SMDKVm1lk2akuPcWQVpch6cI4vgULW3ZvHY-xzpkwHy9rAvI-LiTiGLMnDnQBwmW8jmW5OXvcHtqCjgbq1bHuzxMyAjAfUZwliD8OV9rC-Ed2u2s7yHRSzyvCdYx9mj4_pwGZNTRskDrmcSMPsJPjGIkILvYWED8T52Vohwz";
        String mediaUri = "https://studio.extdev.eng.krista.app/api/";
        final String clientId = "213597343695-tso0nb0om1977u2rtd4ls0323cl5mlts.apps.googleusercontent.com";
        final String clientSecret = "5bcuNcFumMyKxOyhwEEm06i-";

        attr.put(HOST_URL, hostUrl);
        attr.put(CLIENT_ID, clientId);
        attr.put(CLIENT_SECRET, clientSecret);
        attr.put(CALLBACK_URI, "https://studio.demo.krista.app/api/rpc/v1/extension/oauth");
        attr.put(REFRESH_TOKEN,
                "1//0gZMcYLihzCO7CgYIARAAGBASNwF-L9IrmF8XW_Vct0x-gs3Ze1ciOhux-zwsE_7VI8189gcxvCNRktIpiRh-LhnS83azy7g-36Y");
        attr.put(MEDIA_ID, mediaUri);
        Oauth2RestClient restClient = new Oauth2RestClient(attr);

        System.out.println(new Gson().toJson(GreyMatterUtil.self(restClient)));
        //GreyMatterUtil.list(restClient,"1",12,null);
//        String s = "{\"label\":\"email match\",\"requirements\":{\"f\":\"if\",\"a\":[{\"f\":\"and\",\"a\":[{\"f\":\"has\",\"a\":[{\"v\":\"obj_eq\"},{\"v\":\"IsFile\"},{\"v\":\"false\"}]},{\"f\":\"has\",\"a\":[{\"v\":\"jwt_eq_obj\"},{\"v\":\"email\"},{\"v\":\"Name\"}]}]},{\"f\":\"yield\",\"a\":[{\"v\":\"C\"},{\"v\":\"R\"},{\"v\":\"X\"}]},{\"f\":\"yield\",\"a\":[{\"v\":\"R\"},{\"v\":\"X\"}]}]}}";
//        FileObject.ObjectPolicy m = (new Gson().fromJson(s, FileObject.ObjectPolicy.class));
//        System.out.println(new Gson().toJson(m));
        GreyMatterUtil.createFolder(restClient, "164625a1ac900318", "KSoft", null);
        MediaClient mediaClient = new MediaClient(mediaUri);
        //  GreyMatterUtil.upload(mediaClient,restClient,"164625a1ac900318",null,null);
        //GreyMatterUtil.delete(restClient,"164634dcfffd9105");
        // System.out.println(new Gson().toJson(GreyMatterUtil.getAllFolders(restClient,null,10L)));
        // System.out.println(new Gson().toJson(GreyMatterUtil.getAllFiles(restClient,null,2L)));

    }

}