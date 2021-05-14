import java.util.HashMap;
import java.util.Map;
import com.amazonaws.services.ec2.AmazonEC2;
import com.integration.extensions.domains.devops.ec2util.EC2Util;

import static com.integration.extensions.domains.devops.ec2util.EC2Util.*;

public class DevopsExtensionImplTest {

    public static void main(String[] args) throws Exception {
        String clientId = "AKIATE2C4D6UG5TLBSMH";
        String clientSecret = "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";
        Map<String, Object> conAttr = new HashMap<>();
        conAttr.put(AWS_KEY, clientId);
        conAttr.put(AWS_SECRET, clientSecret);
        conAttr.put(AWS_REGION, "us-west-2");
        AmazonEC2 ecr = EC2Util.getEC2(conAttr);
        System.out.println(EC2Util.getInstances(ecr));
    }

}