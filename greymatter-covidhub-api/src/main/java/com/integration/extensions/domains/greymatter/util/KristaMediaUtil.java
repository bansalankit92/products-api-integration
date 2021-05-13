package com.integration.extensions.domains.greymatter.util;

import com.integration.extensions.domains.greymatter.KFile;
import com.integration.util.MediaClient;

import java.io.File;
import java.io.IOException;

public class KristaMediaUtil {

    public static File parse(MediaClient mediaClient, KFile file) throws
            IOException {
        return mediaClient.download(createMediaUrl(file.mediaId), file.mediaId);
    }

    private static String createMediaUrl(String mediaId) {
        return "/media/public/" + mediaId;
    }

}