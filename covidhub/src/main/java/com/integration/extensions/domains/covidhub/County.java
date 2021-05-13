package com.integration.extensions.domains.covidhub;

import com.google.gson.annotations.SerializedName;

public final class County {

    @SerializedName("Province")
    public String province;

    @SerializedName("Name")
    public String name;

    @SerializedName("Country")
    public String country;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name + " | " + province;
    }

}
