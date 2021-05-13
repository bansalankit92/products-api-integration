package com.extensions.domains.development.jira.util.vos;

import com.extensions.domains.development.IssueType;
import com.extensions.domains.development.jira.util.methods.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraIssueType {

    public String subtask;

    public String description;

    public String id;

    public String name;

    public JsonNode scope;

    public static IssueType from(JiraIssueType jiraIssueType) {
        IssueType issueType = new IssueType();
        issueType.description = jiraIssueType.description;
        issueType.id = jiraIssueType.id;
        issueType.name = jiraIssueType.name;
        issueType.subTask = jiraIssueType.subtask;
       // issueType. = getProjectId(jiraIssueType);
        return issueType;
    }

    private static String getProjectId(JiraIssueType jiraIssueType) {
        try {
            return jiraIssueType.scope.get("project").get("id").asText(Constants.NA);
        } catch (Exception e) {
            return Constants.NA;
        }
    }

}