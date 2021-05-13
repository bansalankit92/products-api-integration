package com.integration.util;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Oauth2Password {

    @SerializedName("grant_type")
    private String grantType;
    @SerializedName("client_id")
    private String clientId;
    @SerializedName("client_secret")
    private String clientSecret;
    @SerializedName("refresh_token")
    private String refreshToken;
    private String username;
    private String password;
    private String platform = "base";

    public Oauth2Password() {
    }

    public Oauth2Password(String clientId, String clientSecret, String username, String password) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
    }

    public Oauth2Password withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public Oauth2Password withClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public Oauth2Password withUsername(String username) {
        this.username = username;
        return this;
    }

    public Oauth2Password withPassword(String password) {
        this.password = password;
        return this;
    }

    public Oauth2Password withRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public Oauth2Password withGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }


    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Object toJson() {
        return new Gson().toJson(this);
    }

    public static class Response {
        private String scope;
        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("token_type")
        private String tokenType;
        @SerializedName("download_token")
        private String downloadToken;
        @SerializedName("refresh_token")
        private String refreshToken;
        @SerializedName("expires_in")
        private long expiresIn;
        @SerializedName("refresh_expires_in")
        private long refreshExpiresIn;

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public String getDownloadToken() {
            return downloadToken;
        }

        public void setDownloadToken(String downloadToken) {
            this.downloadToken = downloadToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getRefreshExpiresIn() {
            return refreshExpiresIn;
        }

        public void setRefreshExpiresIn(long refreshExpiresIn) {
            this.refreshExpiresIn = refreshExpiresIn;
        }

        public String getRaw(){
            return new Gson().toJson(this);
        }
    }


}