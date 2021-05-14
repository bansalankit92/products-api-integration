package com.app.extensions.domains.cloudstorage.model;

import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class MDrive {
    public String name, webUrl, driveType, description, id;
    public Date createdDateTime, lastModifiedDateTime;
    public Quota quota;
    public User lastModifiedBy, owner;

    public static class Quota {
        public String state;
        public long remaining, total, used, deleted;
    }

    public static class User {
        public MUser user;
    }

    public static class DriveList{
        public MDrive[] value;

        @SerializedName("@odata.context")
        public String context;
    }
}