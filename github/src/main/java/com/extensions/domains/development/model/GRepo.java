package com.extensions.domains.development.model;

import com.extensions.domains.development.CodeRepository;
import com.google.gson.annotations.SerializedName;

public class GRepo {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("owner")
    public GUser owner;

    @SerializedName("description")
    public String description;

    @SerializedName("full_name")
    public String fullName;

    @SerializedName("private")
    public boolean isPrivate;
    @SerializedName("language")
    public String language;

    @SerializedName("url")
    public String url;

    @SerializedName("default_branch")
    public String defaultBranch;

    public CodeRepository to() {
        CodeRepository repository = new CodeRepository();
        repository.name = name;
        repository.defaultBranch = defaultBranch;
        repository.description = description;
        repository.fullName = fullName;
        repository.language = language;
        repository.owner = owner.login;

        return repository;
    }
}