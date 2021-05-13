package com.extensions.domains.development.model;

import java.util.Arrays;
import com.extensions.domains.development.PullRequest;

public class GPR {
    public String web_url, id, iid, state, title, description;
    public String target_branch, source_branch;
    public GUser author, assignee;
    public GUser[] assignees;


    public PullRequest to() {
        PullRequest pr = new PullRequest();
        pr.title = title;
        pr.pullRequestId = iid;
        if (author!=null)
        pr.author = author.name;
        pr.description = description;
        pr.state = state;
        if (assignees.length > 0)
            pr.reviewers = Arrays.asList(assignees);
        return pr;
    }
}