import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import com.app.extensions.domains.cloudstorage.File;
import com.app.extensions.domains.cloudstorage.util.MediaClient;
import com.app.extensions.domains.cloudstorage.util.S3Util;
import com.google.gson.Gson;

import static com.app.extensions.domains.cloudstorage.util.S3Util.*;

public class S3Runner {

    public static void main(String[] args) throws Exception, IOException, URISyntaxException {
        String clientId = "AKIATE2C4D6UG5TLBSMH";
        String clientSecret = "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";
        Map<String, Object> conAttr = new HashMap<>();
        conAttr.put(AWS_KEY, clientId);
        conAttr.put(AWS_SECRET, clientSecret);
        conAttr.put(AWS_REGION, "eu-west-1");
        conAttr.put(MEDIA_URL, "");
        Gson gson = new Gson();

        File file = new File();
        file.fileName = "XSLX.xslx";

         System.out.println(new Gson().toJson(S3Util.getFiles(S3Util.getS3(conAttr),"345","Sales_sheet1.xlsx")));
        System.out.println(new Gson().toJson(S3Util
                .downloadFile(S3Util.getS3(conAttr), new MediaClient("https://app.com/api/"),
                        "", "container.log")));

    }

}