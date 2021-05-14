import java.util.HashMap;
import java.util.Map;
import com.app.extensions.domains.cloudstorage.util.DriveUtil;
import com.app.extensions.domains.cloudstorage.util.MicrosoftUtil;
import com.app.extensions.domains.cloudstorage.util.OAuthUtil;

import static com.app.extensions.domains.cloudstorage.util.OAuthUtil.*;

public class OneDriveRunner {

    public static void main(String[] args) throws Exception {
        final String refreshToken =
                "0.AAAAa9VF2C4Ewk6GmfOUo5wITgkEgCbR0_ZDuajoDkZrwgpvAIQ.AQABAAAAAAAGV_bv21oQQ4ROqh0_1-tA42-UF0cjeNgr27A2QOCoiRsr16WeFC5DGMqHgTGsTS8QTvBbCGg1Mka3G-o8HimJJiLRZ66Yssfah50RW0G7fcaVlObKrL1qGj73Lp5uCFdrUuvcPPuZ9dUW4zqb_y-4D-KuQH7C9-upeN6PwemcBnTlY5L3Qdbe1YW53J59jgZ0Z3aJcWZ7tM8Ljiuv5aqlPohKMbZ2HdQA4NPo7YWFCqktffkc_stn2N3K_mYnH21qWLBMpBRECoEQ73i6hPkJVtWarnLxtSAeYqr7vmIjpa0R-8BHEFSzLQwrE62CUPW74I8iy4w5Bt7ekOmVWV4CcvcIcFijA0srGxmKeZL6f7ynlNgcx5u1PcYM74Z0JPsd3t5jsC6vLwMwEf69DRZHZ_bJR8-1OQg11cO6_em88Xe0XZnGshLbEkl_HvuJAbtowhpnytCzmfL4SeFRxpwGJiuYjlmDbieLAHYfGEIn-UIRyI7vZGOGTJgbNg9TKtQJDS4xGX15luQVu0yyu6oyo5hC5dGhIiybhgyPIxVdMjRqmQn4hqt6Q3X2z3dnpmbKhJj-Ql16jXXLddpVg_LYsXCTnxYOwlYK7lr5aoj-cnyUxZ1-z2222a90g86Kq4s5cGKW89IpLDPJhXyv5moHtwepBltBictrKAmvnGyHEn4bm7l0pqjwfOPOHZagRMhVhtf5Sh3NdP-orOE4o10OksaQkClq7u7DoMhtsR3BOJSiPUBERH_mPKL6-esCiYipfwi1buBgaVOazWQQPzP4c7WuyC4OdTQhxQXwNBT5WNnEHF66x1Ur-LK-IdKvmVeZSdl5bl_y3eEMWThTIXEEvV4PZQMVEn4psjk2yInEqTrkQOX6AiZUPUGLitIo3VuG5AP54uHE8xbNocRn6Z-kDCrV_6fipXpxBUcXf-EuwPkhKN4Szz4XyWTPPx-QzgXOE4v7utPRYyhsNv183JdvIAA";
        final String clientId = "26800409-d3d1-43f6-b9a8-e80e466bc20a";
        final String clientSecret = "~qMgYLo9ZzXbr5~6xi48_n-42.W7OoX0l-";
        final String callbackUri = "https://client.or-extdev-01.com/api/";
        Map<String, Object> context = new HashMap<>();
        context.put(CLIENT_ID, clientId);
        context.put(CLIENT_SECRET, clientSecret);
        context.put(CALLBACK_URI, callbackUri);
        context.put(REFRESH_TOKEN, refreshToken);
        context.put(MEDIA_ID, "https://client.or-extdev-01.antbrains.com/api");

        OAuthUtil util = new OAuthUtil(context);

        System.out.println(MicrosoftUtil.getMe(util));
        System.out.println(DriveUtil.myDriveList(util));
        // System.out.println(DriveUtil.root(util));
//        System.out.println(DriveUtil.getRootChildren(util));
//        System.out.println(DriveUtil.rootExpand(util));
        // System.out.println(FileUtil.search(util,"conv"));

        //  String itemId= "01TFKER2AX4PXJK762WJFIAJDRTPVCSOFJ";
//        System.out.println(DriveUtil.getRootChildren(util,1,""));
//        System.out.println(DriveUtil.getChildren(util,itemId));

        //  File file = new File("/Users/macbook/Desktop/extn_upload/meta.jar");
        // System.out.println(DriveUtil.upload(util,itemId,file,file.getName()));
        //  System.out.println(DriveUtil.createFolder(util,"via_api_new"));

    }

}