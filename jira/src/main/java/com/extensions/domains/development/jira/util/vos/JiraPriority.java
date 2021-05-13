package com.extensions.domains.development.jira.util.vos;

import com.extensions.domains.development.Priority;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class JiraPriority {

    public String description;

    public String id;

    public String name;

    public static Priority from(JiraPriority jiraPriority) {
        Priority issueType = new Priority();
        issueType.description = jiraPriority.description;
        issueType.id = jiraPriority.id;
        issueType.name = jiraPriority.name;
        return issueType;
    }
}