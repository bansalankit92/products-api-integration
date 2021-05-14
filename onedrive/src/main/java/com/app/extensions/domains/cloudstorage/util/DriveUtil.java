package com.app.extensions.domains.cloudstorage.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.app.extensions.domains.cloudstorage.model.MDrive;
import com.app.extensions.domains.cloudstorage.model.MDriveItem;

public class DriveUtil {

    public static MDrive[] myDriveList(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, "/me/drives", new HashMap<>()), MDrive.DriveList.class).value;
    }

    public static MDriveItem root(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, "/me/drive/root", new HashMap<>()), MDriveItem.class);
    }

    public static MDriveItem[] getRootChildren(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> qp = new HashMap<>();
        // qp.put("top", "name,size");
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, "/me/drive/root/children", qp), MDriveItem.ItemList.class).value;
    }

    public static MDriveItem[] getRootChildren(OAuthUtil authUtil, long size, String pageToken)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> qp = new HashMap<>();
        qp.put("top", String.valueOf(size));
        qp.put("skipToken", pageToken);
        //@TODO loop around skip token to get next page
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, "/me/drive/root/children", qp), MDriveItem.ItemList.class).value;
    }

    public static MDriveItem[] getChildren(OAuthUtil authUtil, String itemId)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> qp = new HashMap<>();
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, "/me/drive/items/" + itemId + "/children", qp), MDriveItem.ItemList.class).value;
    }

    public static MDriveItem getDriveItem(OAuthUtil authUtil, String itemId)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> qp = new HashMap<>();
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, "/me/drive/items/" + itemId, qp), MDriveItem.class);
    }

    public static String rootExpand(OAuthUtil authUtil)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> qp = new HashMap<>();
        qp.put("expand", "children(select=id,name)");
        return OAuthUtil.get(authUtil, "/me/drive/root", qp);
    }

    public static MDriveItem[] search(OAuthUtil authUtil, String query)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> qp = new HashMap<>();
        String path = "/me/drive/root/search(q='{" + query + "}')";
        return OAuthUtil.GSON.fromJson(OAuthUtil.get(authUtil, path, qp), MDriveItem.ItemList.class).value;
    }

    public static MDriveItem upload(OAuthUtil authUtil, String itemId, File file, String fileName)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, String> qp = new HashMap<>();
        return OAuthUtil.GSON.fromJson(OAuthUtil.putFile(authUtil, "/me/drive/items/" + itemId + ":/" + fileName + ":/content", file), MDriveItem.class);
    }

    public static MDriveItem createFolder(OAuthUtil authUtil, String folderName)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("name", folderName);
        qp.put("folder", new HashMap());
        return OAuthUtil.GSON.fromJson(OAuthUtil.post(authUtil, "/me/drive/root/children", OAuthUtil.GSON.toJson(qp)), MDriveItem.class);
    }

    public static MDriveItem createFolder(OAuthUtil authUtil, String itemId, String folderName)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("name", folderName);
        qp.put("folder", new HashMap());
        return OAuthUtil.GSON.fromJson(OAuthUtil.post(authUtil, "/me/drive/items/" + itemId + "/children", OAuthUtil.GSON.toJson(qp)), MDriveItem.class);
    }

    private static File parse(MediaClient mediaClient, com.app.extensions.domains.cloudstorage.File file) throws
            IOException {
        return mediaClient.download(createMediaUrl(file.mediaId), file.mediaId);
    }

    private static String createMediaUrl(String mediaId) {
        return "/media/public/" + mediaId;
    }

    public static void uploadFile(OAuthUtil oAuthUtil, MediaClient mediaClient, String itemId, com.app.extensions.domains.cloudstorage.File file) throws IOException, ExecutionException, InterruptedException {
        // Upload a file as a new object with ContentType and title specified.
        File downloadedfile = parse(mediaClient, file);
        System.out.println(downloadedfile.getAbsolutePath());
        upload(oAuthUtil, itemId, downloadedfile, file.fileName);
    }
}