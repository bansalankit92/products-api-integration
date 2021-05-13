package com.extensions.domains.development.jira.util.methods;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.extensions.domains.development.*;
import com.extensions.domains.development.jira.util.vos.JiraIssue;
import com.extensions.domains.development.jira.util.vos.JiraProject;
import com.extensions.domains.development.jira.util.vos.JiraUser;
import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class IssuesUtil {
    private static Gson gson = new Gson();

    public static Issue createTask(String projectKey, String summary, RestClient client) throws Exception {
        return create(projectKey, summary, "Task", client);
    }

    public static Issue createSubTask(String projectKey, String summary, RestClient client) throws Exception {
        return create(projectKey, summary, "Subtask", client);
    }

    public static Issue createBug(String projectKey, String summary, RestClient client) throws Exception {
        return create(projectKey, summary, "Bug", client);
    }

    public static Issue createStory(String projectKey, String summary, RestClient client) throws Exception {
        return create(projectKey, summary, "Story", client);
    }

    public static Issue createEpic(String projectKey, String summary, RestClient client) throws Exception {
        return create(projectKey, summary, "Epic", client);
    }

    public static Issue create(String projectKey, String summary, String issueType, RestClient client)
            throws Exception {
        return create(projectKey, summary, summary, issueType, client);
    }

    public static Issue create(String projectKey, String summary, String description, String issueType, RestClient client)
            throws Exception {
        Invocation.Builder invoker = client.getResourceInvoker("issue", new HashMap<>());
        JSONObject fields = new JSONObject();
        JSONObject project = new JSONObject();
        JSONObject issueTypeMap = new JSONObject();
        issueTypeMap.put("id", getIssuesTypeId(projectKey, issueType, client));
        project.put("key", projectKey);
        fields.put("project", project);
        fields.put("issuetype", issueTypeMap);
        fields.put("summary", summary);
        fields.put("description", getAtlassianDoc(description));
        JSONObject data = new JSONObject();
        data.put("fields", fields);
        javax.ws.rs.core.Response response = invoker.post(Entity.entity(data.toString(), MediaType.APPLICATION_JSON));
        String jsonResponse = response.readEntity(String.class);
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            String key = jsonObject.optString("key");
            return getIssueFinal(key, client);
        } catch (JSONException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void assign(String issueKey, String username, RestClient client) throws Exception {
        JiraUser jiraUser = UsersUtil.getUser(client, username);
        Invocation.Builder invoker = client.getResourceInvoker("issue/" + issueKey + "/assignee", new HashMap<>());
        JSONObject fields = new JSONObject();
        fields.put("accountId", jiraUser.accountId);
        invoker.put(Entity.entity(fields.toString(), MediaType.APPLICATION_JSON));
    }

    public static void assignTask(String issueKey, User userDetails, RestClient client) throws Exception {
        Invocation.Builder invoker = client.getResourceInvoker("issue/" + issueKey + "/assignee", new HashMap<>());
        JSONObject fields = new JSONObject();
        fields.put("accountId", userDetails.accountId);
        invoker.put(Entity.entity(fields.toString(), MediaType.APPLICATION_JSON));
    }

    public static void assignTask(String issueKey, String userAccountId, RestClient client) throws Exception {
        Invocation.Builder invoker = client.getResourceInvoker("issue/" + issueKey + "/assignee", new HashMap<>());
        JSONObject fields = new JSONObject();
        fields.put("accountId", userAccountId);
        invoker.put(Entity.entity(fields.toString(), MediaType.APPLICATION_JSON));
    }

    public static JiraIssue getIssue(String key, RestClient client) throws Exception {
        String res = getIssueResponse(key, client);
        return JiraIssue.create(new JSONObject(res));
    }

    public static Issue getIssueFinal(String key, RestClient client) throws Exception {
        JiraIssue issue = getIssue(key, client);
        Issue issueFinal = issue.getIssue();
        return issueFinal;
    }

    private static String getIssuesTypeId(String projectKey, String issueType, RestClient client) throws Exception {
        String jsonResponse = getAllIssueTypes(client, String.class);
        JSONArray issueTypes = new JSONArray(jsonResponse);
        for (int i = 0; i < issueTypes.length(); i++) {
            JSONObject issueTypeJson = issueTypes.getJSONObject(i);
            if (issueTypeJson.get("name").equals(issueType)) {
                if (issueTypeJson.has("scope")) {
                    JSONObject scopeJson = (JSONObject) issueTypeJson.get("scope");
                    if (scopeJson.has("project")) {
                        JSONObject projectJson = (JSONObject) scopeJson.get("project");
                        String projectId = (String) projectJson.get("id");
                        JiraProject project = ProjectsUtil.getProjectById(projectId, client);
                        if (project.key.equals(projectKey)) {
                            return (String) issueTypeJson.get("id");
                        }
                    }
                }
            }
        }
        throw new Exception("Invalid issue type");
    }

    private static <T> T getAllIssueTypes(RestClient client, Class<T> tClass) throws Exception {
        return client.fetch("issuetype", new HashMap<>(), tClass);
    }

    public static List<Issue> getUpcomingTasks(RestClient client) throws Exception {
        JSONObject params = new JSONObject();
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
        params.put("jql", " duedate = " + dateString);
        Invocation.Builder invoker = client.getResourceInvoker("search", new HashMap<>());
        Response response = invoker.post(Entity.entity(params.toString(), MediaType.APPLICATION_JSON));
        String jsonResponse = response.readEntity(String.class);
        JSONArray issues = (JSONArray) (new JSONObject(jsonResponse)).get("issues");
        return getIssues(issues);
    }

    public static List<Issue> searchByJQL(RestClient client, String jql, long size, long page) throws Exception {
        Map<String, Object> qparams = new HashMap<>();
        qparams.put("jql", jql);
        qparams.put("startAt", Math.max((page - 1) * size, 0));
        qparams.put("maxResults", size == 0 ? 20 : size);
        String out = client.fetch("search", qparams, String.class);
        JSONObject jsonObject = new JSONObject(out);
        if (jsonObject.has("issues")) {
            JSONArray issues = (JSONArray) jsonObject.get("issues");
            return getIssues(issues);
        } else {
            throw new RuntimeException(jsonObject.has("errorMessages") ? (String) ((JSONArray) jsonObject.get("errorMessages")).get(0) : "Issues not found");
        }
    }

    public static String getIssueResponse(String issueKey, RestClient client) throws Exception {
        return client.fetch("issue/" + issueKey, new HashMap<>(), String.class);
    }

    public static List<Issue> getChildIssueByType(String issueType, String issueKey, RestClient client) throws Exception {
        JSONObject jsonObject = new JSONObject(getIssueResponse(issueKey, client));
        if (JiraIssue.getIssueType(jsonObject).equals(issueType)) {
            JSONArray subtask = JiraIssue.getSubtask(jsonObject);
            return getIssues(subtask);
        }
        return new ArrayList<>();
    }

    private static List<Issue> getIssues(JSONArray issues) throws Exception {
        List<Issue> issuesFinal = new ArrayList<>();
        for (int i = 0; i < issues.length(); i++) {
            JiraIssue issue = JiraIssue.create(issues.getJSONObject(i));
            issuesFinal.add(issue.getIssue());
        }
        return issuesFinal;
    }

    public static List<Issue> getReleaseChildIssue(String issueKey, RestClient client) throws Exception {
        return getChildIssueByType("Release", issueKey, client);
    }

    public static Issue createRelease(String projectKey, String summary, RestClient restClient) throws Exception {
        return create(projectKey, summary, "Release", restClient);
    }

    public static Issue createIssue(String projectKey, String summary, String issueType, RestClient restClient) throws Exception {
        return create(projectKey, summary, issueType, restClient);
    }

    public static boolean addComment(String issueKey, String comment, RestClient client) throws Exception {

        Invocation.Builder invoker = client.getResourceInvoker("issue/" + issueKey + "/comment", new HashMap<>());
        JSONObject bodyContent = getAtlassianDoc(comment);
        JSONObject fields = new JSONObject();
        fields.put("body", bodyContent);

        Response response = invoker.post(Entity.entity(fields.toString(), MediaType.APPLICATION_JSON));
        return response.getStatus() < 400;
    }

    private static JSONObject getAtlassianDoc(String description) throws JSONException {
        JSONObject innerContent = new JSONObject();
        innerContent.put("text", description);
        innerContent.put("type", "text");
        JSONArray innerContents = new JSONArray();
        innerContents.put(innerContent);

        JSONObject content = new JSONObject();
        content.put("type", "paragraph");
        content.put("content", innerContents);
        JSONArray contents = new JSONArray();
        contents.put(content);
        JSONObject bodyContent = new JSONObject();
        bodyContent.put("type", "doc");
        bodyContent.put("version", 1);
        bodyContent.put("content", contents);

        return bodyContent;
    }

    public static List searchJQL(String jql, long size, long page, RestClient client) throws Exception {
        return IssuesUtil.searchByJQL(client, jql, size, page);

    }

    public static List<IssueType> getIssueTypes(RestClient restClient) throws Exception {
        String res = getAllIssueTypes(restClient, String.class);
        JSONArray statusArr = new JSONArray(res);
        List<IssueType> issueTypes = new ArrayList<>();
        for (int i = 0; i < statusArr.length(); i++) {
            IssueType issueType = new IssueType();
            issueType.id = statusArr.getJSONObject(i).optString("id");
            issueType.description = statusArr.getJSONObject(i).optString("description");
            issueType.name = statusArr.getJSONObject(i).optString("name");
            issueType.subTask = statusArr.getJSONObject(i).optString("subtask");
            issueTypes.add(issueType);
        }
        return issueTypes;
    }

    public static List<Priority> getPriorities(RestClient restClient) throws Exception {
        String res = restClient.fetch("/priority", new HashMap<>(), String.class);
        JSONArray statusArr = new JSONArray(res);
        List<Priority> priorities = new ArrayList<>();
        for (int i = 0; i < statusArr.length(); i++) {
            Priority status = new Priority();
            status.id = statusArr.getJSONObject(i).optString("id");
            status.description = statusArr.getJSONObject(i).optString("description");
            status.name = statusArr.getJSONObject(i).optString("name");
            priorities.add(status);
        }
        return priorities;
    }

    public static List<TicketStatus> getStatuses(RestClient restClient) throws Exception {
        String res = restClient.fetch("/status", new HashMap<>(), String.class);
        JSONArray statusArr = new JSONArray(res);
        List<TicketStatus> statuses = new ArrayList<>();
        for (int i = 0; i < statusArr.length(); i++) {
            TicketStatus status = new TicketStatus();
            status.id = statusArr.getJSONObject(i).optString("id");
            status.description = statusArr.getJSONObject(i).optString("description");
            status.name = statusArr.getJSONObject(i).optString("name");
            statuses.add(status);
        }
        return statuses;
    }

    public static Issue updatePriority(RestClient restClient, Priority priority, String issueKey) throws Exception {
        Invocation.Builder invoker = restClient.getResourceInvoker("issue/" + issueKey, new HashMap<>());

        JSONObject fields = new JSONObject();
        fields.put("priority", getPriorityJsonObject(priority));
        JSONObject body = new JSONObject();
        body.put("fields", fields);
        invoker.put(Entity.entity(body.toString(), MediaType.APPLICATION_JSON));
        return getIssueFinal(issueKey, restClient);
    }

    private static JSONObject getPriorityJsonObject(Priority priority) throws JSONException {
        JSONObject priorityObj = new JSONObject();
        if (priority.id != null) {
            priorityObj.put("id", priority.id);
        }
        if (priority.name != null) {
            priorityObj.put("name", priority.name);
        }
        return priorityObj;
    }

    private static JSONObject getAssigneeJsonObject(User user) throws JSONException {
        JSONObject assigneeObject = new JSONObject();
//           if (user.accountId != null) {
//               priorityObj.put("id", user.accountId);
//           }
        if (user.name != null) {
            assigneeObject.put("name", user.name);
        }
        return assigneeObject;
    }

    public static List<TransitionStatus> getTransitions(RestClient restClient, String issueKey) throws Exception {
        String res = restClient.fetch("issue/" + issueKey + "/transitions", new HashMap<>(), String.class);
        JSONObject resObj = new JSONObject(res);
        List<TransitionStatus> transitionStatusList = new ArrayList<>();
        JSONArray transitions = resObj.getJSONArray("transitions");
        for (int i = 0; i < transitions.length(); i++) {
            TransitionStatus transitionStatus = new TransitionStatus();
            JSONObject trans = transitions.optJSONObject(i);
            transitionStatus.fromId = trans.optString("id");
            transitionStatus.fromName = trans.optString("name");
            JSONObject to = trans.optJSONObject("to");
            transitionStatus.toId = to.optString("id");
            transitionStatus.toName = to.optString("name");
            JSONObject category = to.optJSONObject("statusCategory");
            if (category != null) {
                transitionStatus.toCategoryName = category.optString("name");
            }
            transitionStatusList.add(transitionStatus);
        }
        return transitionStatusList;
    }

    public static void updateStatus(RestClient restClient, String issueKey, String statusName) throws Exception {
        Invocation.Builder invoker = restClient.getResourceInvoker("issue/" + issueKey + "/transitions", new HashMap<>());
        List<TransitionStatus> transitionStatusList = getTransitions(restClient, issueKey);
        TransitionStatus status = transitionStatusList.stream()
                .filter(tstatus -> tstatus.toName.equalsIgnoreCase(statusName))
                .findFirst().orElseThrow(() -> new RuntimeException("We cant change the status of the issue key " + issueKey + " to " + statusName + " because no transitions are available to this status."));
        JSONObject transitions = new JSONObject();
        transitions.put("id", status.fromId);
        JSONObject body = new JSONObject();
        body.put("transition", transitions);
        Response response = invoker.post(Entity.entity(body.toString(), MediaType.APPLICATION_JSON));
        if (response.getStatus() >= 400) {
            throw new RuntimeException("Failed updating status " + response.readEntity(String.class));
        }
    }

    public static void addWorklog(RestClient restClient, String timeSpent, long date, String issueKey, String comment) throws Exception {
        Invocation.Builder invoker = restClient.getResourceInvoker("issue/" + issueKey + "/worklog", new HashMap<>());

        JSONObject body = new JSONObject();
        body.put("timeSpent", timeSpent);
        body.put("started", DatePlus.getISODate(new Date(date)));
        if (comment != null && !comment.isEmpty()) {
            body.put("comment", getAtlassianDoc(comment));
        }
        Response res = invoker.post(Entity.entity(body.toString(), MediaType.APPLICATION_JSON));
        if (res.getStatus() >= HttpsURLConnection.HTTP_BAD_REQUEST) {
            throw new RuntimeException(res.readEntity(String.class));
        }
        // String s = res.readEntity(String.class);
        //  return getIssueFinal(issueKey, restClient);
    }

    public static void updateDueDate(RestClient restClient, String issueKey, long date) throws Exception {
        Invocation.Builder invoker = restClient.getResourceInvoker("issue/" + issueKey, new HashMap<>());
        JSONObject set = new JSONObject();
        set.put("set", DatePlus.getYYYYMMDD(date));
        JSONArray array = new JSONArray();
        array.put(set);
        JSONObject duedate = new JSONObject();
        duedate.put("duedate", array);
        JSONObject update = new JSONObject();
        update.put("update", duedate);
        System.out.println(update.toString());
        Response res = invoker.put(Entity.entity(update.toString(), MediaType.APPLICATION_JSON));
        if (res.getStatus() >= HttpsURLConnection.HTTP_BAD_REQUEST) {
            throw new RuntimeException(res.readEntity(String.class));
        }
    }

    public static void updateSummary(RestClient restClient, String issueKey, String summary) throws Exception {
        Invocation.Builder invoker = restClient.getResourceInvoker("issue/" + issueKey, new HashMap<>());
        JSONObject set = new JSONObject();
        set.put("set", summary);
        JSONArray array = new JSONArray();
        array.put(set);
        JSONObject summaryJson = new JSONObject();
        summaryJson.put("summary", array);
        JSONObject update = new JSONObject();
        update.put("update", summaryJson);
        System.out.println(update.toString());
        Response res = invoker.put(Entity.entity(update.toString(), MediaType.APPLICATION_JSON));
        if (res.getStatus() >= HttpsURLConnection.HTTP_BAD_REQUEST) {
            throw new RuntimeException(res.readEntity(String.class));
        }
    }

    public static String updateIssue(Issue request, RestClient client) throws Exception {
        Invocation.Builder invoker = client.getResourceInvoker("issue/" + request.key, new HashMap<>());
        Issue old = getIssueFinal(request.key, client);
        JSONObject update = new JSONObject();
        JSONObject fields = new JSONObject();
        if (!old.summary.trim().equalsIgnoreCase(request.summary.trim())) {
            JSONObject set = new JSONObject();
            set.put("set", request.summary);
            JSONArray array = new JSONArray();
            array.put(set);
            update.put("summary", array);
        }

        if (!old.description.trim().equalsIgnoreCase(request.description.trim())) {
            JSONObject description = getAtlassianDoc(request.description);
            fields.put("description", description);
        }

        if (!old.priority.trim().equalsIgnoreCase(request.priority.trim())) {
            Priority priority1 = new Priority();
            priority1.name = request.priority;
            fields.put("priority", getPriorityJsonObject(priority1));
        }

        if (!old.status.trim().equalsIgnoreCase(request.status.trim())) {
            try {
                updateStatus(client, request.key, request.status);
            } catch (Exception ignore) {

            }
        }

        if (!old.assigneeName.trim().equalsIgnoreCase(request.assigneeName.trim())) {
            try {
                JiraUser user = UsersUtil.searchUser(client, request.assigneeName).stream().findFirst().orElseThrow(() -> new RuntimeException("User not found"));
                assignTask(request.key, user.accountId, client);
            } catch (Exception ignore) {

            }
        }
        JSONObject actualObject = new JSONObject();
        actualObject.put("update", update);
        actualObject.put("fields", fields);
        Response response = invoker.put(Entity.entity(actualObject.toString(), MediaType.APPLICATION_JSON));
        return response.readEntity(String.class);
    }


}
