package com.extensions.domains.development;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public final class PullRequest {

    @SerializedName("Title")
    public String title;

    @SerializedName("Author")
    public String author;

    @SerializedName("Pull Request Id")
    public String pullRequestId;

    @SerializedName("Description")
    public String description;

    @SerializedName("Reviewers")
    public List reviewers;

    @SerializedName("State")
    public String state;

    /**
     * Please add only relevant fields here for summary.
     */
    @Override
    public String toString() {
        return pullRequestId + " | " + title + " | " + author;
    }

}
