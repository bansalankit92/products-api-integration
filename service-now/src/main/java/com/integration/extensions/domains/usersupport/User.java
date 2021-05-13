package com.integration.extensions.domains.usersupport;

import com.google.gson.annotations.SerializedName;

public final class User {

    @SerializedName("First Name")
    public String firstName;

    @SerializedName("Email")
    public String email;

    @SerializedName("Last Name")
    public String lastName;

    @SerializedName("Sys Id")
    public String sysId;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "";
    }

}
