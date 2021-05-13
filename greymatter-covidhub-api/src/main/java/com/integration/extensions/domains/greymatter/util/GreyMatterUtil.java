package com.integration.extensions.domains.greymatter.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.greymatter.FileObject;
import com.integration.extensions.domains.greymatter.FolderObject;
import com.integration.extensions.domains.greymatter.KFile;
import com.integration.extensions.domains.greymatter.model.GFileObject;
import com.integration.extensions.domains.greymatter.model.MetaRequest;
import com.integration.extensions.domains.greymatter.model.Security;
import com.integration.extensions.domains.greymatter.model.Self;
import com.integration.util.MediaClient;
import com.integration.util.Oauth2RestClient;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class GreyMatterUtil {
    private static final Gson GSON = new Gson();

    public static Self self(Oauth2RestClient Oauth2RestClient) throws InterruptedException, ExecutionException, IOException {
        String res = Oauth2RestClient.get("/self", new HashMap<>());
        System.out.println(res);
        return new Gson().fromJson(res, Self.class);
    }

    public static List<FileObject> list(Oauth2RestClient Oauth2RestClient, String oid, long count, String last) throws InterruptedException, ExecutionException, IOException {
        Map<String, java.lang.Object> qp = new HashMap<>();
        qp.put("count", count > 0 ? count : 20);
        qp.put("childCount", true);
        qp.put("last", last != null && !last.isBlank() ? last : null);
        String res = Oauth2RestClient.get("/list/" + (oid != null && !oid.isBlank() ? oid : "1"), qp);
        return GFileObject.toObject(new Gson().fromJson(res, GFileObject[].class));
    }

    public static FileObject props(Oauth2RestClient Oauth2RestClient, String oid) throws InterruptedException, ExecutionException, IOException {
        return GFileObject.to(getByOid(Oauth2RestClient, oid));
    }

    public static FolderObject getFileFolderByOid(Oauth2RestClient Oauth2RestClient, String oid) throws InterruptedException, ExecutionException, IOException {
        return GFileObject.toFolderObject(getByOid(Oauth2RestClient, oid));
    }

    private static GFileObject getByOid(Oauth2RestClient Oauth2RestClient, String oid) throws InterruptedException, ExecutionException, IOException {
        Map<String, java.lang.Object> qp = new HashMap<>();
        qp.put("childCount", true);
        String res = Oauth2RestClient.get("/props/" + (oid != null && !oid.isBlank() ? oid : "1"), qp);
        return (new Gson().fromJson(res, GFileObject.class));
    }


    public static FileObject createFolder(Oauth2RestClient Oauth2RestClient, String parentOid, String folderName, String objectPolicy) throws InterruptedException, ExecutionException, IOException {
        Self self = self(Oauth2RestClient);
        MetaRequest meta = new MetaRequest();
        meta.parentoid = parentOid;
        meta.security = new Security();
        meta.action = "U";
        meta.name = folderName;
        meta.isfile = false;
        meta.originalobjectpolicy = objectPolicy != null && !objectPolicy.isBlank() ? objectPolicy : PolicyUtil.getUserYeildAllPolicy(self);
        String res = Oauth2RestClient.postMultipart("/write", List.of(meta), null);
        return GFileObject.to(new Gson().fromJson(res, GFileObject[].class)[0]);
    }

    public static FileObject upload(MediaClient mediaClient, Oauth2RestClient Oauth2RestClient, String parentOid, String objectPolicy, KFile file) throws IOException, ExecutionException, InterruptedException {
        Self self = self(Oauth2RestClient);
        MetaRequest meta = new MetaRequest();
        meta.parentoid = parentOid;
        meta.security = new Security();
        meta.action = "C";
        meta.name = file.fileName;
        meta.isfile = true;
        meta.originalobjectpolicy = objectPolicy != null && !objectPolicy.isBlank() ? objectPolicy : PolicyUtil.getUserYeildAllPolicy(self);
        File toUploadFile = KristaMediaUtil.parse(mediaClient, file);
        String res = Oauth2RestClient.postMultipart("/write", List.of(meta), toUploadFile);
        return GFileObject.to(new Gson().fromJson(res, GFileObject[].class)[0]);
    }


    public static void delete(Oauth2RestClient Oauth2RestClient, String oid) throws InterruptedException, ExecutionException, IOException {
        MetaRequest meta = getByOid(Oauth2RestClient, oid).toMetaRequest();
        meta.action = "D";
        meta.security = null;
        meta.originalobjectpolicy = meta.name = null;
        String res = Oauth2RestClient.postMultipart("/write", List.of(meta), null);
    }

    public static FileObject update(Oauth2RestClient Oauth2RestClient, String oid, String newName, String newPolicy) throws InterruptedException, ExecutionException, IOException {
        MetaRequest meta = getByOid(Oauth2RestClient, oid).toMetaRequest();
        meta.action = "U";
        meta.security = null;
        meta.objectpolicy = null;
        meta.originalobjectpolicy = newPolicy != null && !newPolicy.isBlank() ? newPolicy : meta.originalobjectpolicy;
        meta.name = newName != null && !newName.isBlank() ? newName : meta.name;
        String res = Oauth2RestClient.postMultipart("/write", List.of(meta), null);
        return GFileObject.to(new Gson().fromJson(res, GFileObject[].class)[0]);
    }


    public static List<FileObject> getAllFilesInFolder(Oauth2RestClient Oauth2RestClient, String oid, Long totalCount) {
        String last = null;
        int count = 40;
        List<FileObject> obj = new ArrayList<>();
        List<FileObject> res;

        do {
            try {
                res = list(Oauth2RestClient, oid, count, last);
                obj.addAll(res);
                last = res.get(res.size() - 1).oid;

            } catch (Exception e) {
                break;
            }
        } while (res.size()==count && obj.size() < totalCount);
        return obj;
    }

    public static List<FileObject> getAllFolders(Oauth2RestClient Oauth2RestClient, String oid, Long count) throws InterruptedException, ExecutionException, IOException {
        List<FileObject> objects = list(Oauth2RestClient, oid, count, null);
        Queue<FileObject> folders = objects.stream().filter(x -> !x.isFile).collect(Collectors.toCollection(LinkedList::new));
        List<FileObject> res = new ArrayList<>();
        do {
            FileObject folder = folders.poll();
            res.add(folder);
            objects = getAllFilesInFolder(Oauth2RestClient, folder.oid, count);
            folders.addAll(objects.stream().filter(x -> !x.isFile).collect(Collectors.toList()));
        }
        while (!folders.isEmpty() && res.size() <= count);

        return res;
    }

    public static List<FileObject> getAllFiles(Oauth2RestClient Oauth2RestClient, String oid, Long count) throws InterruptedException, ExecutionException, IOException {
        List<FileObject> objects = list(Oauth2RestClient, oid, count, null);
        Queue<FileObject> folders = objects.stream().filter(x -> !x.isFile).collect(Collectors.toCollection(LinkedList::new));
        List<FileObject> res = objects.stream().filter(x -> x.isFile).collect(Collectors.toCollection(LinkedList::new));
        do {
            FileObject folder = folders.poll();
            objects = getAllFilesInFolder(Oauth2RestClient, folder.oid, count);
            folders.addAll(objects.stream().filter(x -> !x.isFile).collect(Collectors.toList()));
            res.addAll(objects.stream().filter(x -> x.isFile).collect(Collectors.toList()));
        }
        while (!folders.isEmpty() && res.size() < count);

        return res;
    }
}