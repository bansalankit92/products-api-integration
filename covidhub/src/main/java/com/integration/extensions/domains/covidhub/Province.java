package com.integration.extensions.domains.covidhub;

import com.google.gson.annotations.SerializedName;

public final class Province {

    @SerializedName("Country")
    public String country;

    @SerializedName("Name")
    public String name;

    public Province(String name) {
        this.name = name;
    }

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
