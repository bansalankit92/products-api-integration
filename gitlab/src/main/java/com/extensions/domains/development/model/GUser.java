package com.extensions.domains.development.model;

import com.google.gson.annotations.SerializedName;

public class GUser {

    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("username")
      public String username;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("email")
    public String email;
    @SerializedName("organization")
    public String organization;
    @SerializedName("location")
    public String location;

    @SerializedName("bio")
    public String bio;

}

