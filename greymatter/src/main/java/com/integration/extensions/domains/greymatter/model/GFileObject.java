package com.integration.extensions.domains.greymatter.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.integration.extensions.domains.greymatter.FileObject;
import com.integration.extensions.domains.greymatter.FolderObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GFileObject {
    public String tstamp, name, action, oid, parentoid, expiration, checkedtstamp, cluster, originalobjectpolicy, jwthash;
    public UserPolicy userpolicy;
    public int schemaversion, childcount;
    public ObjectPolicy objectpolicy;
    public JsonObject derived, rname;
    public Policy policy;
    public Security security;


    public String sha256plain, mimetype;
    public Long size;
    public boolean isfile;

    public static class UserPolicy {
        public String label;
    }


    public static class Policy {
        public java.util.List<String> policy;
    }

    public static List<GFileObject> toList(GFileObject[] fileArr) {
        return Arrays.stream(fileArr).collect(Collectors.toList());
    }

    public static FileObject to(GFileObject fObj) {
        FileObject obj = new FileObject();
        obj.isFile = fObj.isfile;
        obj.mimetype = fObj.mimetype;
        obj.name = fObj.name;
        obj.oid = fObj.oid;
        obj.originalObjectPolicy = fObj.originalobjectpolicy;
        obj.parentOid = fObj.parentoid;
        obj.size = fObj.size;

        return obj;

    }

    public static FolderObject toFolderObject(GFileObject fObj) {
        FolderObject obj = new FolderObject();
          obj.name = fObj.name;
          obj.oid = fObj.oid;
          obj.originalObjectPolicy = fObj.originalobjectpolicy;
          obj.parentOid = fObj.parentoid;
          obj.childCount = (long) fObj.childcount;

          return obj;

      }

    public static List<FileObject> toObject(GFileObject[] fileArr) {
        return toList(fileArr).stream().map(GFileObject::to).collect(Collectors.toList());
    }


    public MetaRequest toMetaRequest() {
        Gson gson  =new Gson();
        MetaRequest meta= new MetaRequest();
        meta.isfile  = isfile;
        meta.originalobjectpolicy = originalobjectpolicy;
        meta.name = name;
        meta.action = action;
        meta.security = security;
        meta.objectpolicy = objectpolicy;
        meta.oid = oid;
        meta.parentoid = parentoid;

        return gson.fromJson(gson.toJson(meta), MetaRequest.class);
       }


}