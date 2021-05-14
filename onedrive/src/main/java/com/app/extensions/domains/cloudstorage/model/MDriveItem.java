package com.app.extensions.domains.cloudstorage.model;

import java.util.Date;
import com.app.extensions.domains.cloudstorage.FileDetails;
import com.app.extensions.domains.cloudstorage.StorageBucket;
import com.google.gson.annotations.SerializedName;

public class MDriveItem {

    public static class ItemList {
        @SerializedName("@odata.context")
        public String context;

        @SerializedName("@odata.nextLink")
        public String nextLink;
        public MDriveItem[] value;
    }

    public String name, webUrl, id;
    public Date createdDateTime, lastModifiedDateTime;
    public MDrive.Quota quota;
    public MDrive.User lastModifiedBy, createdBy;
    public long size;
    public FileType file;
    public FileSystemInfo fileSystemInfo;
    public ParentRef parentReference;
    public Folder folder;

    @SerializedName("@microsoft.graph.downloadUrl")
    public String downloadUrl;

    public boolean isFolder;

    public static class User {
        public MUser user;
    }

    public static class FileType {
        public String mimeType;
    }

    public static class ParentRef {
        public String driveId, id, driveType;
    }

    public static class FileSystemInfo {
        public Date createdDateTime, lastModifiedDateTime;
    }

    public static class Folder {
        public long childCount;
    }

    public MDriveItem eval(){
        this.isFolder = folder != null;
         return this;
    }

    public FileDetails to() {
        FileDetails fileDetails = new FileDetails();
        fileDetails.name = name;
        fileDetails.size = size;
        fileDetails.tag = "";
        fileDetails.bucketName = "";
        if (createdBy!=null&&createdBy.user!=null)
        fileDetails.owner = createdBy.user.displayName;
        fileDetails.id = id;
        if (lastModifiedDateTime!=null)
        fileDetails.lastModified = lastModifiedDateTime.getTime();
        fileDetails.isFolder = folder != null;


        return fileDetails;
    }

    public StorageBucket toSB() {
        StorageBucket fileDetails = new StorageBucket();
           fileDetails.name = name;
           if (createdBy!=null&&createdBy.user!=null)
           fileDetails.owner = createdBy.user.displayName;
           fileDetails.id = id;
           if (createdDateTime!=null)
           fileDetails.createdDate = createdDateTime.getTime();
           return fileDetails;
       }
}