package com.extensions.domains.development.jira.util.methods;

import com.extensions.domains.development.*;

public class IssueMapper {

    private IssueMapper() {
    }

    public static Release getRelease(Issue issue) {
        Release release = new Release();
        release.assigneeName = issue.assigneeName;
        release.comments = issue.comment;
        release.description = issue.description;
        release.releaseKey = issue.key;
        release.priority = issue.priority;
        release.projectKey = issue.projectKey;
        release.reporterName = issue.reporterName;
        release.status = issue.status;
        release.type = issue.issueType;
        release.summary = issue.summary;
        release.id = issue.id;
        return release;
    }

    public static Epic getEpic(Issue issue) {
        Epic release = new Epic();
        release.assigneeName = issue.assigneeName;
        release.comments = issue.comment;
        release.description = issue.description;
        release.epicKey = issue.key;
        release.priority = issue.priority;
        release.projectKey = issue.projectKey;
        release.reporterName = issue.reporterName;
        release.status = issue.status;
        release.type = issue.issueType;
        release.summary = issue.summary;
        release.id = issue.id;
        return release;
    }

    public static Bug getBugs(Issue issue) {
        Bug release = new Bug();
        release.assigneeName = issue.assigneeName;
        release.comments = issue.comment;
        release.description = issue.description;
        release.bugKey = issue.key;
        release.priority = issue.priority;
        release.projectKey = issue.projectKey;
        release.reporterName = issue.reporterName;
        release.status = issue.status;
        release.type = issue.issueType;
        release.summary = issue.summary;
        release.id = issue.id;
        return release;
    }

    public static Story getStory(Issue issue) {
        Story release = new Story();
        release.assigneeName = issue.assigneeName;
        release.comments = issue.comment;
        release.description = issue.description;
        release.storyKey = issue.key;
        release.priority = issue.priority;
        release.projectKey = issue.projectKey;
        release.reporterName = issue.reporterName;
        release.status = issue.status;
        release.storyType = issue.issueType;
        release.summary = issue.summary;
        release.id = issue.id;
        return release;
    }

    public static Subtask getSubtask(Issue issue) {
        Subtask release = new Subtask();
        release.assigneeName = issue.assigneeName;
        release.comments = issue.comment;
        release.description = issue.description;
        release.key = issue.key;
        release.priority = issue.priority;
        release.projectKey = issue.projectKey;
        release.reporterName = issue.reporterName;
        release.status = issue.status;
        release.taskType = issue.issueType;
        release.summary = issue.summary;
        release.id = issue.id;
        release.parentKey = issue.parentKey;
        return release;
    }

    public static Issue getIssue(Subtask issue) {
        Issue release = new Issue();
        release.assigneeName = issue.assigneeName;
        release.description = issue.description;
        release.key = issue.key;
        release.priority = issue.priority;
        release.projectKey = issue.projectKey;
        release.reporterName = issue.reporterName;
        release.status = issue.status;
        release.issueType = issue.taskType;
        release.summary = issue.summary;
        release.id = issue.id;
        release.parentKey = issue.parentKey;
        return release;
    }


    public static Issue getIssue(Release issue) {
        Issue release = new Issue();
         release.assigneeName = issue.assigneeName;
         release.description = issue.description;
         release.key = issue.releaseKey;
         release.priority = issue.priority;
         release.projectKey = issue.projectKey;
         release.reporterName = issue.reporterName;
         release.status = issue.status;
         release.issueType = issue.type;
         release.summary = issue.summary;
         release.id = issue.id;
         return release;
     }

     public static Issue getIssue(Epic issue) {
         Issue release = new Issue();
         release.assigneeName = issue.assigneeName;
         release.description = issue.description;
         release.key = issue.epicKey;
         release.priority = issue.priority;
         release.projectKey = issue.projectKey;
         release.reporterName = issue.reporterName;
         release.status = issue.status;
         release.issueType = issue.type;
         release.summary = issue.summary;
         release.id = issue.id;
         return release;
     }

     public static Issue getIssue(Bug issue) {
         Issue release = new Issue();
         release.assigneeName = issue.assigneeName;
         //release.comments = issue.comment;
         release.description = issue.description;
         release.key = issue.bugKey;
         release.priority = issue.priority;
         release.projectKey = issue.projectKey;
         release.reporterName = issue.reporterName;
         release.status = issue.status;
         release.issueType = issue.type;
         release.summary = issue.summary;
         release.id = issue.id;
         return release;
     }

     public static Issue getIssue(Story issue) {
         Issue release = new Issue();
         release.assigneeName = issue.assigneeName;
         //release.comments = issue.comment;
         release.description = issue.description;
         release.key = issue.storyKey;
         release.priority = issue.priority;
         release.projectKey = issue.projectKey;
         release.reporterName = issue.reporterName;
         release.status = issue.status;
         release.issueType = issue.storyType;
         release.summary = issue.summary;
         release.id = issue.id;
         return release;
     }
}