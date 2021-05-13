package com.integration.extensions.domains.covidhub;

import com.google.gson.annotations.SerializedName;

public final class State {

    @SerializedName("Name")
    public String name;

    @SerializedName("Code")
    public String code;

    public State(String name) {
        this.name = name;
    }

    public State(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name + (code != null && !code.isEmpty() ? " | " + code : "");
    }

}
