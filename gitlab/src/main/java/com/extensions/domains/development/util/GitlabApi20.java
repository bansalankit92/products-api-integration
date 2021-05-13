package com.extensions.domains.development.util;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;

public class GitlabApi20 extends DefaultApi20 {

    private static class InstanceHolder {
        private static final GitlabApi20 INSTANCE = new GitlabApi20();

        private static GitlabApi20 getInstance(String hostUrl) {
            if (hostUrl == null || hostUrl.isBlank())
                return new GitlabApi20();
            return new GitlabApi20(hostUrl);
        }
    }

    public static GitlabApi20 instance(String hostUrl) {
        return GitlabApi20.InstanceHolder.getInstance(hostUrl);
    }

    public static GitlabApi20 instance() {
        return InstanceHolder.INSTANCE;
    }

    private final String hostUrl;

    public GitlabApi20(String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public GitlabApi20() {
        this.hostUrl = "https://gitlab.com";
    }

    @Override
    public String getAccessTokenEndpoint() {
        return hostUrl + "/oauth/token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return hostUrl + "/oauth/authorize";
    }

    @Override
    public OAuth2AccessTokenJsonExtractor getAccessTokenExtractor() {
        return OAuth2AccessTokenJsonExtractor.instance();
    }
}
