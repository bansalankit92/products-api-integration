package com.extensions.domains.development.jira.util.vos;

import java.util.ArrayList;
import java.util.List;
import com.extensions.domains.development.Issue;
import com.extensions.domains.development.jira.util.methods.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraIssue {
    public String id;
    public String key;
    public Object fields;

    public JiraIssue(String id, String key, Object fields) {
        this.id = id;
        this.key = key;
        this.fields = fields;
    }

    public static JiraIssue create(JSONObject issueObject) throws JSONException {
        return new JiraIssue((String) issueObject.get("id"), (String) issueObject.get("key"), issueObject.has("fields") ? (Object) issueObject.get("fields") : null);
    }

    public List<String> getComments() {
        try {
            JSONArray jsonArray = (JSONArray) ((JSONObject) ((JSONObject) this.fields).get("comment")).get("comments");
            List<String> comments = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                comments.add((String) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) jsonArray.getJSONObject(i).get("body")).get("content")).getJSONObject(0)).get("content")).getJSONObject(0).get("text"));
            }
            return comments;
        } catch (JSONException e) {
            return new ArrayList<>();
        }
    }

    private String getAssignee() {
        try {
            return (String) ((JSONObject) ((JSONObject) this.fields).get("assignee")).get("displayName");
        } catch (Exception e) {
            return "NA";
        }
    }

    private String getDescription() {
        try {
            return (String) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) ((JSONObject) this.fields).get("description")).get("content")).getJSONObject(0)).get("content")).getJSONObject(0).get("text");
        } catch (Exception e) {
            return "";
        }
    }

    private String getPriority() {
        try {
            return (String) ((JSONObject) ((JSONObject) this.fields).get("priority")).get("name");
        } catch (Exception e) {
            return "";
        }
    }

    private String getProject() {
        try {
            return (String) ((JSONObject) ((JSONObject) this.fields).get("project")).get("name");
        } catch (Exception e) {
            return "";
        }

    }

    private String getReporter() {
        try {
            return (String) ((JSONObject) ((JSONObject) this.fields).get("reporter")).get("displayName");
        } catch (Exception e) {
            return "";
        }

    }

    private String getStatus() {
        try {
            return (String) ((JSONObject) ((JSONObject) this.fields).get("status")).get("name");
        } catch (Exception e) {
            return "";
        }

    }

    private String getType() {
        try {
            return (String) ((JSONObject) ((JSONObject) this.fields).get("issuetype")).get("name");
        } catch (Exception e) {
            return "";
        }

    }

    public Issue getIssue() {
        Issue issue = new Issue();
        try {
            issue.assigneeName = getAssignee();
            issue.comment = getComments();
            issue.description = getDescription();
            issue.key = key;
            issue.name = key;
            issue.priority = getPriority();
            issue.projectKey = getProject();
            issue.reporterName = getReporter();
            issue.status = getStatus();
            issue.issueType = getType();
            issue.summary = getSummary();
            issue.id = id;
            issue.parentKey = getParent();
        } catch (Exception e) {
            return issue;
        }
        return issue;
    }

    private String getParent() {
        try {
            JSONObject parent = ((JSONObject) this.fields).optJSONObject("parent");
            if (parent != null) {
                return parent.optString("key");
            }
        }catch (Exception ignored){

        }
            return Constants.NA;
    }

    public String getSummary() {
        try {
            return ((JSONObject) this.fields).getString("summary");
        }catch (Exception e) {
            return "";
        }
    }

    public static JSONArray getSubtask(JSONObject object) throws JSONException {
        JSONObject fields = object.getJSONObject("fields");
        return fields.getJSONArray("subtasks");
    }

    public static String getIssueType(JSONObject object) throws JSONException {
        try {
            JSONObject fields = object.getJSONObject("fields");
            return fields.getJSONObject("issuetype").getString("name");
        } catch (Exception e) {
            return "";
        }
    }

}
