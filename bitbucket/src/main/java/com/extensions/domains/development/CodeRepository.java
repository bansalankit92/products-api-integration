package com.extensions.domains.development;

import com.google.gson.annotations.SerializedName;

public final class CodeRepository {

    @SerializedName("Project Name")
    public String projectName;

    @SerializedName("Owner")
    public String owner;

    @SerializedName("Description")
    public String description;

    @SerializedName("Language")
    public String language;

    @SerializedName("Full Name")
    public String fullName;

    @SerializedName("Default branch")
    public String defaultBranch;

    @SerializedName("Workspace Slug")
    public String workspaceSlug;

    @SerializedName("Workspace Name")
    public String workspaceName;

    @SerializedName("Slug")
    public String slug;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return projectName;
    }

}
