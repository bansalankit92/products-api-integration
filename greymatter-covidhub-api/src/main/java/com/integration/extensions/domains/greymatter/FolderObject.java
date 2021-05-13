package com.integration.extensions.domains.greymatter;

import com.google.gson.annotations.SerializedName;

public final class FolderObject {

    @SerializedName("Parent Oid")
    public String parentOid;

    @SerializedName("Oid")
    public String oid;

    @SerializedName("Child Count")
    public Long childCount;

    @SerializedName("Original object policy")
    public String originalObjectPolicy;

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
