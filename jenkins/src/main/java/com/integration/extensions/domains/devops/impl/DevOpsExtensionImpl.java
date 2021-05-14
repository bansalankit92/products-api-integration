package com.integration.extensions.domains.devops.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.google.gson.Gson;
import com.integration.extensions.domains.devops.DevOpsExtension;
import com.integration.extensions.domains.devops.ProjectBuild;
import com.integration.extensions.domains.devops.TestResults;
import com.integration.extensions.domains.devops.mapper.BuildMapper;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.helper.JenkinsVersion;
import com.offbytwo.jenkins.model.*;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class DevOpsExtensionImpl implements DevOpsExtension {

    private Map<String, Object> attributes = new HashMap<>();
    public static String HOST_URL = "hostUrl";
    public static String USER_NAME = "userName";
    public static String USER_PASSWORD = "password";
    public static JenkinsServer jenkins;
    public static final Gson GSON = new Gson();

    @Override
    public com.integration.extensions.domains.devops.Build getLastFailedBuild(String projectName) throws Exception {
        return BuildMapper.from(jenkins.getJob(projectName).getLastFailedBuild(), projectName);
    }

    @Override
    public com.integration.extensions.domains.devops.Build cancelABuild(String projectName, String buildNumber)
            throws Exception {
        com.integration.extensions.domains.devops.Build b = null;
//         jenkins.getQueue().getItems().stream().forEach(x->{
//          if (x.getTask().getName()
//        });
        return b;
    }

    @Override
    public List getBuildsListByProjectName(String projectName) throws Exception {
        return jenkins.getJob(projectName).getAllBuilds().stream().map(b -> BuildMapper.from(b, projectName))
                .collect(Collectors.toList());
    }

    @Override
    public TestResults getTestResults(String projectName, Long buildNumber) throws Exception {
        com.offbytwo.jenkins.model.Build build;
        if (buildNumber == null) {
            build = jenkins.getJob(projectName).getLastBuild();
        } else {
            build = jenkins.getJob(projectName).getBuildByNumber(Math.toIntExact(buildNumber));
        }
        TestReport report = build.getTestReport();
        List<TestChildReport> childReport = report.getChildReports();
        TestResults result = new TestResults();
        result.buildNumber = String.valueOf(buildNumber);

        if (childReport.isEmpty()) {
            result.failCount = (report.getFailCount());
            result.skipCount = (report.getSkipCount());
            result.passCount = (report.getTotalCount() - report.getFailCount() - report.getSkipCount());
        } else {
            childReport.forEach(x -> {
                TestResult testResult = x.getResult();
                result.duration += testResult.getDuration();
                result.skipCount += testResult.getSkipCount();
                result.failCount += testResult.getFailCount();
                result.passCount += testResult.getPassCount();
            });
        }

        return result;
    }

    @Override
    public com.integration.extensions.domains.devops.Build getBuildDeatilsByProjectName(String projectName,
            Long buildNumber) throws Exception {
        com.offbytwo.jenkins.model.Build build;
        if (buildNumber == null) {
            build = jenkins.getJob(projectName).getLastBuild();
        } else {
            build = jenkins.getJob(projectName).getBuildByNumber(Math.toIntExact(buildNumber));
        }

        return BuildMapper.from(build, projectName);
    }

    @Override
    public ProjectBuild fetchProjectBuildByPrimaryKey(String primaryKey) throws Exception {
        return new ProjectBuild(primaryKey);
    }

    @Override
    public List fetchFieldsSupportingSearchForProjectBuild() {
        return new ArrayList<>();
    }

    private List<ProjectBuild> getProjectBuildList() throws IOException {
        Map<String, Job> jobs = jenkins.getJobs();
        return jobs.values().stream().map(x -> new ProjectBuild(x.getName())).collect(Collectors.toList());
    }

    /**
     * Get Jenkins Version
     */
    @Override
    public String getJenkinsVersion() {
        JenkinsVersion job = jenkins.getVersion();
        return job.toString();
    }

    /**
     * Trigger Build
     */
    @Override
    public String triggerBuild(String moduleName) throws Exception {
        Map<String, Job> jobs = jenkins.getJobs();
        JobWithDetails job = jobs.get(moduleName).details();
        QueueReference jj = job.build(true);
        JobWithDetails job1 = jobs.get(moduleName).details();
        return String.valueOf(job1.getLastBuild().getNumber());
    }

    /**
     * Get Build Number by name
     */
    @Override
    public String getBuildNumberByName(String moduleName) throws
            Exception {
        Map<String, Job> jobs = jenkins.getJobs();
        JobWithDetails job = jobs.get(moduleName).details();
        return String.valueOf(job.getLastBuild().getNumber());
    }

    @Override
    public ProjectBuild getProjectBuild(String projectName) throws Exception {
        return getProjectBuildList().stream().filter(x -> x.name.toLowerCase().contains(projectName.toLowerCase()))
                .findFirst().orElseThrow(() -> new RuntimeException("Project not found " + projectName));
    }

    @Override
    public com.integration.extensions.domains.devops.Build getBuild(String projectName, String buildNumber)
            throws Exception {
        com.offbytwo.jenkins.model.Build build =
                jenkins.getJob(projectName).getBuildByNumber(Integer.parseInt(buildNumber));
        return BuildMapper.from(build, projectName);
    }

    @Override
    public List getProjectBuilds() throws IOException {
        return getProjectBuildList();
    }

}
