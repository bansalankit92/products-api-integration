package com.extensions.domains.development.model;

import com.extensions.domains.development.CodeRepositoryBranch;
import com.google.gson.annotations.SerializedName;

public class GBranches {

    

    public String name;
    @SerializedName("web_url")
    public String url;
    public Commit commit;

    public static class Commit {
        public String id, short_id, web_url,title,message,author_name,author_email;
    }

    public CodeRepositoryBranch to(String repoFullName) {
        CodeRepositoryBranch branch = new CodeRepositoryBranch();
        branch.name = name;
        branch.hash = commit.id;
        branch.repositoryFullName = repoFullName;
        branch.repositoryName = repoFullName.split("/")[1];
        branch.authorNickname = commit.author_name;
        branch.message = commit.message;
        return branch;
    }

}