package com.integration.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;

public final class User {

    @SerializedName("Company Name")
    public String companyName;

    @SerializedName("Mobile Number")
    public String mobileNumber;

    @SerializedName("Email")
    public String email;

    @SerializedName("User name")
    public String userName;

    @SerializedName("Alias")
    public String alias;

    @SerializedName("First Name")
    public String firstName;

    @SerializedName("Id")
    public String id;

    @SerializedName("Last Name")
    public String lastName;

    @SerializedName("Name")
    public String name;

    @SerializedName("Community Nickname")
    public String communityNickname;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name;
    }

}
