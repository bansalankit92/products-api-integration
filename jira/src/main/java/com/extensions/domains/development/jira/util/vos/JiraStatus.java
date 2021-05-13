package com.extensions.domains.development.jira.util.vos;

import com.extensions.domains.development.TicketStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraStatus {

    public String description;

    public String id;

    public String name;

    public static TicketStatus from(JiraStatus jiraStatus) {
        TicketStatus status = new TicketStatus();
        status.description = jiraStatus.description;
        status.id = jiraStatus.id;
        status.name = jiraStatus.name;
        return status;
    }
}