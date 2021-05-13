package com.extensions.domains.development.model;

import com.extensions.domains.development.CodeRepository;
import com.google.gson.annotations.SerializedName;

public class GRepo {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("path")
    public String path;

    @SerializedName("owner")
    public GUser owner;

    @SerializedName("description")
    public String description;

    @SerializedName("path_with_namespace")
    public String fullName;

    @SerializedName("visibility")
    public String visibility;

    @SerializedName("private")
    public boolean isPrivate;
    @SerializedName("language")
    public String language;

    @SerializedName("web_url")
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
        repository.owner = owner.name;
        repository.slug = path;
        return repository;
    }
}