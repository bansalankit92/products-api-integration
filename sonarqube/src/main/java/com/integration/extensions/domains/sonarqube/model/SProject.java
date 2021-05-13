package com.integration.extensions.domains.sonarqube.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sonarqube.Project;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SProject {

    @SerializedName("organization")
    public String organization;
    @SerializedName("key")
    public String key;
    @SerializedName("name")
    public String name;
    @SerializedName("qualifier")
    public String qualifier;
    @SerializedName("visibility")
    public String visibility;
    @SerializedName("lastAnalysisDate")
    public Date lastAnalysisDate;
    @SerializedName("revision")
    public String revision;
    @SerializedName("description")
    public String description;


    public static class ProjectList {
        public SPaging paging;
        public SProject[] components;

        public List<Project> list() {
            return Arrays.stream(components).map(SProject::to).collect(Collectors.toList());
        }
    }

    public Project to() {
        Project project = new Project();
        project.analysisDate = lastAnalysisDate.getTime();
        project.description = description;
        project.key = key;
        project.name = name;
        // project.needIssueSync =
        project.organization = organization;
        project.qualifier = qualifier;
        project.visibility = visibility;

        return project;
    }
}