package com.integration.extensions.domains.devops.mapper;

import java.io.IOException;
import com.integration.extensions.domains.devops.Build;
import com.offbytwo.jenkins.model.BuildWithDetails;

public class BuildMapper {
    public static Build from(com.offbytwo.jenkins.model.Build b, String projectName) throws RuntimeException {
        Build build = new Build();
        build.deploymentProjectName = projectName;
        BuildWithDetails details = null;
        try {
            details = b.details();
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        build.status = details.getResult().name();
        build.buildId = String.valueOf(details.getId());
        build.buildNumber = String.valueOf(details.getDisplayName());
        return build;
    }
}