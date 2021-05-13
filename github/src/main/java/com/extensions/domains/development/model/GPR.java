package com.extensions.domains.development.model;

import com.extensions.domains.development.PullRequest;
import com.google.gson.annotations.SerializedName;

public class GPR {
    public String url, id, state, title, body;
    public int number;
    public GUser user;
    public Branch base;
    public Branch head;
    @SerializedName("requested_reviewers")
    public GUser[] reviewers;

    public static class Branch {
        public String label, ref, sha;
        public GUser user;
        public GRepo repo;
    }

    public static class Response{
        public String sha,message;
        public boolean merged;
    }


    public PullRequest to() {
        PullRequest pr = new PullRequest();
        pr.title = title;
        pr.pullRequestId = String.valueOf(number);
        pr.author = user.login;
        pr.description = body;
        pr.state = state;
        return pr;
    }
}