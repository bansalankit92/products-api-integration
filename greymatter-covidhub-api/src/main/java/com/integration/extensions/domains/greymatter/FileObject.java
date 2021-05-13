package com.integration.extensions.domains.greymatter;

import com.google.gson.annotations.SerializedName;

public final class FileObject {

    @SerializedName("Mimetype")
    public String mimetype;

    @SerializedName("Parent Oid")
    public String parentOid;

    @SerializedName("Size")
    public Long size;

    @SerializedName("Original object policy")
    public String originalObjectPolicy;

    @SerializedName("Is File")
    public Boolean isFile;

    @SerializedName("Oid")
    public String oid;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name + " | " + originalObjectPolicy;
    }

}
