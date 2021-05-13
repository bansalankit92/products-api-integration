package com.integration.extensions.domains.sonarqube.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.integration.extensions.domains.sonarqube.Project;
import com.integration.extensions.domains.sonarqube.util.SonarqubeUtil;
import com.integration.util.RestClient;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class SonarqubeExtensionImpl {

    public static final String HOST_URL = "Host URL";
    public static final String ACCESS_TOKEN = "Access Token";
    private Map<String, Object> attributes = new HashMap<>();

    private static Gson gson = new Gson();

    RestClient restClient;

    /**
     * Fetch Project By Primary Key
     */

    public Project fetchProjectByPrimaryKey(String primaryKey) throws Exception {
        return SonarqubeUtil.getProject(restClient, primaryKey);
    }

    /**
     * Fetch Fields Supporting Search For Project
     */

    public List fetchFieldsSupportingSearchForProject() {
        return new ArrayList();
    }

    /**
     * For Generic Search for entity selector for Project. The List is a List<Pair<String, Pair<String, String>>>
     */

    /**
     * Create Project
     */

    public String createProject(Project entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Project
     */

    public String updateProject(Project entityDefinition, String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Get Files with Duplicate code
     */

    public List getFilesWithDuplicateCode(String projectKey) throws Exception {
        return SonarqubeUtil.getAllMeasures(restClient, projectKey, "Duplicated Lines Density");
    }

    /**
     * Get Overall Metrics
     */

    public Object getOverallMetrics(String projectKey) throws Exception {
        return SonarqubeUtil.getMetrics(restClient, projectKey);
        //return SonarqubeUtil.getMeasures(restClient,projectKey,null,1,100).baseComponent;
    }

    /**
     * Get Bugs
     */

    public Object getBugs(String projectKey) throws Exception {
        return SonarqubeUtil.getAllMeasures(restClient, projectKey, "Bugs");
    }

    /**
     * Get Vulnerabilities
     */

    public Object getVulnerabilities(String projectKey) throws Exception {
        return SonarqubeUtil.getAllMeasures(restClient, projectKey, "Vulnerabilities");
    }

    /**
     * Change version when you do any change in extension
     */

    public String getVersion() {
        return "1.0.0";
    }

    public void init(final Map arg0) {
        // This is a lifecycle method.;
        // This is a lifecycle method.;
        attributes = arg0;
        Object hostUrl = attributes.get(HOST_URL);
        Object AccessTOken = attributes.get(ACCESS_TOKEN);
        if (hostUrl != null && AccessTOken != null) {
            restClient = new RestClient(String.valueOf(hostUrl), String.valueOf(AccessTOken));
        } else {
            throw new RuntimeException("Please enter host url and access token");
        }
    }

    public String getAuthorizationUrl() {
        return new String();
    }

}
