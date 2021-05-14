package com.integration.extensions.domains.devops;

import java.io.IOException;
import java.util.List;

public interface DevOpsExtension {

    /**
     * Get Jenkins Version
     */
    String getJenkinsVersion();

    /**
     * Trigger Build
     */
    String triggerBuild(String moduleName) throws Exception;

    /**
     * Get Build Number by name
     */
    String getBuildNumberByName(String moduleName) throws Exception;

    /**
     * Get project build details
     */
    ProjectBuild getProjectBuild(String projectName) throws Exception;

    /**
     * Get build for given project name and build number
     */
    Build getBuild(String projectName, String buildNumber) throws Exception;

    /**
     * Get Project build
     */
    List getProjectBuilds() throws IOException;

    /**
     * Fetch Project Build By Primary Key
     */
    ProjectBuild fetchProjectBuildByPrimaryKey(String primaryKey) throws Exception;

    /**
     * Fetch Fields Supporting Search For Project Build
     */
    List fetchFieldsSupportingSearchForProjectBuild();

    /**
     * last Failed build
     */
    Build getLastFailedBuild(String projectName) throws Exception;

    Build cancelABuild(String projectName, String buildNumber) throws Exception;

    /**
     * Get builds list by project name
     */
    List getBuildsListByProjectName(String projectName) throws Exception;

    /**
     * Get Test Results by project name and build number
     */
    TestResults getTestResults(String projectName, Long buildNumber) throws Exception;

    /**
     * Get Build by project name, get latest if build number not send
     */
    Build getBuildDeatilsByProjectName(String projectName, Long buildNumber) throws Exception;

}
