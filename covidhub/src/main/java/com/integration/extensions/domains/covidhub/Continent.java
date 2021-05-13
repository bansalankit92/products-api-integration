package com.integration.extensions.domains.covidhub;

import com.google.gson.annotations.SerializedName;

public final class Continent {

    @SerializedName("Name")
    public String name;

    public Continent(String name) {
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
