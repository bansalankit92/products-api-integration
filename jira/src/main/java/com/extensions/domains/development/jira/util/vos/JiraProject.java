package com.extensions.domains.development.jira.util.vos;

import com.extensions.domains.development.TicketingProject;
import com.extensions.domains.development.jira.util.methods.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraProject {
    public String name;
    public String type;
    public String id;
    public String key;
    public String style;
    public String assigneeType;
    public JSONObject lead;

    public JiraProject(String name,
                       String type,
                       String id,
                       String key,
                       String style,
                       String assigneeType,
                       JSONObject lead) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.key = key;
        this.style = style;
        this.assigneeType = assigneeType;
        this.lead = lead;
    }

    public static JiraProject create(JSONObject projectObject) throws JSONException {
        return new JiraProject(
                projectObject.optString("name"),
                projectObject.optString("projectTypeKey"),
                projectObject.optString("id"),
                projectObject.optString("key"),
                projectObject.optString("style"),
                projectObject.optString("assigneeType", Constants.NA),
                projectObject.optJSONObject("lead")
        );
    }

    public TicketingProject getProject() {
        TicketingProject project = new TicketingProject();
        project.projectId = id;
        project.key = key;
        project.name = name;
        project.type = type;
        project.assigneeType = assigneeType;
        project.style = style;
        project.leadAccountId = getLeadId();
        project.leadName = getLeadName();
        return project;
    }

    private String getLeadName() {
        try {
            if (lead != null) {
                return lead.optString("displayName");
            }
        } catch (Exception ignored) {

        }
        return Constants.NA;
    }

    private String getLeadId() {
        try {
            if (lead != null) {
                return lead.optString("accountId");
            }
        } catch (Exception ignored) {

        }
        return Constants.NA;
    }
}
