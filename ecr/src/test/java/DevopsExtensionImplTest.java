import java.util.HashMap;
import java.util.Map;
import com.amazonaws.services.ecr.AmazonECR;
import com.integration.extensions.domains.devops.ecrutil.ECRUtil;

import static com.integration.extensions.domains.devops.ec2util.EC2Util.*;

public class DevopsExtensionImplTest {

    public static void main(String[] args) throws Exception {
//              String clientId = "AKIATE2C4D6UG5TLBSMH";
//              String clientSecret = "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";

        String clientId = "AKIA4Z4WLR3PEE2AIYYI";
        String clientSecret = "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";
        Map<String, Object> conAttr = new HashMap<>();
        conAttr.put(AWS_KEY, clientId);
        conAttr.put(AWS_SECRET, clientSecret);
        conAttr.put(AWS_REGION, "us-west-2");

        AmazonECR ecr = ECRUtil.getECR(conAttr);
        System.out.println(ECRUtil.getAllRepositories(ecr));
    }

}