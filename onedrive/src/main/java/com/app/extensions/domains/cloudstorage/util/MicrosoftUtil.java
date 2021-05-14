package com.app.extensions.domains.cloudstorage.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import com.app.extensions.domains.cloudstorage.model.MUser;

public class MicrosoftUtil {

    public static MUser getMe(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, "/me", new HashMap<>()), MUser.class);
    }
}