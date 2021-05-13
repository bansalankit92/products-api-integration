package com.integration.extensions.domains.covidhub;

import com.google.gson.annotations.SerializedName;

public final class City {

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
