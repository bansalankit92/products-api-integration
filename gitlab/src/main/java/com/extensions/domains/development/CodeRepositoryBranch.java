package com.extensions.domains.development;

import com.google.gson.annotations.SerializedName;

public final class CodeRepositoryBranch {

    @SerializedName("Repository Full Name")
    public String repositoryFullName;

    @SerializedName("Type")
    public String type;

    @SerializedName("Message")
    public String message;

    @SerializedName("Author Nickname")
    public String authorNickname;

    @SerializedName("Repository Name")
    public String repositoryName;

    @SerializedName("Hash")
    public String hash;

    @SerializedName("Name")
    public String name;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return name + " | " + authorNickname;
    }

}
