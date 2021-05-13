package com.extensions.domains.development.jira.util.methods;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;

public class JiraApi20 extends DefaultApi20  {

    private static class InstanceHolder {

            private static final JiraApi20 INSTANCE = new JiraApi20();
        }

        public static JiraApi20 instance() {
            return JiraApi20.InstanceHolder.INSTANCE;
        }

        @Override
        public String getAccessTokenEndpoint() {
            return "https://auth.atlassian.com/oauth/token";
        }

        @Override
        protected String getAuthorizationBaseUrl() {
            return "https://auth.atlassian.com/authorize";
        }

        @Override
        public OAuth2AccessTokenJsonExtractor getAccessTokenExtractor() {
            return OAuth2AccessTokenJsonExtractor.instance();
        }
}
