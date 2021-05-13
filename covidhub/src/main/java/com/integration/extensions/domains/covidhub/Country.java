package com.integration.extensions.domains.covidhub;

import com.google.gson.annotations.SerializedName;

public final class Country {

    @SerializedName("ISO 3")
    public String iSO3;

    @SerializedName("ISO 2")
    public String iSO2;

    @SerializedName("Code")
    public String code;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
