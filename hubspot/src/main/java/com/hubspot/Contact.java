package com.hubspot;

import com.google.gson.annotations.SerializedName;

public final class Contact {

    @SerializedName("First Name")
    public String firstName;

    @SerializedName("Email")
    public String email;

    @SerializedName("Id")
    public String id;

    @SerializedName("Last Name")
    public String lastName;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return "email = " + email;
    }

}
