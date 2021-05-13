package com.extensions.domains.development.model;

import com.google.gson.annotations.SerializedName;

public class GUser {
    @SerializedName("login")
    public String login;
    @SerializedName("id")
    public String id;
    @SerializedName("node_id")
    public String nodeId;
    @SerializedName("type")
    public String type;
    @SerializedName("name")
    public String name;
    @SerializedName("company")
    public String company;
    @SerializedName("location")
    public String location;
    @SerializedName("email")
    public String email;
    @SerializedName("bio")
    public String bio;
    @SerializedName("public_repos")
    public int publicRepos;
    @SerializedName("public_gists")
    public int publicGist;
    @SerializedName("followers")
    public int followers;
    @SerializedName("following")
    public int following;
    @SerializedName("total_private_repos")
    public int privateRepos;
}

