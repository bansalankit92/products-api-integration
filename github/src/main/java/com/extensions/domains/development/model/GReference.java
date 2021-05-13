package com.extensions.domains.development.model;

import com.extensions.domains.development.CodeRepositoryBranch;

public class GReference {

    public String ref, url;
    public GObject object;

    public static class GObject {
        public String sha, type, url;
    }

    public CodeRepositoryBranch to(String repoFullName) {
        CodeRepositoryBranch branch = new CodeRepositoryBranch();
        if (ref!=null) {
            String[] refs = ref.split("/");
            branch.name = refs[refs.length - 1];
        }
        branch.hash = object.sha;
        branch.repositoryFullName = repoFullName;
        branch.type = object.type;
        branch.repositoryName = repoFullName.split("/")[1];
        return branch;
    }

}