package com.hubspot.core.net.client.http.method;

import org.asynchttpclient.Realm;
import org.asynchttpclient.oauth.ConsumerKey;
import org.asynchttpclient.oauth.OAuthSignatureCalculator;
import org.asynchttpclient.oauth.RequestToken;

public class HttpBase {

    public final String url;
    public final String path;
    protected OAuthSignatureCalculator signatureCalculator;
    protected Realm realm;

    public HttpBase(String url, String path) {
        this.url = url;
        this.path = path;
    }

    public void setOauth(String consumerKey, String consumerSecret, String tokenKey, String tokenSecret) {
        setOauth(new ConsumerKey(consumerKey, consumerSecret), new RequestToken(tokenKey, tokenSecret));
    }

    public void setOauth(ConsumerKey consumerKey, RequestToken requestToken) {
        signatureCalculator = new OAuthSignatureCalculator(consumerKey, requestToken);
    }

    public void setRealm(String principal, String password) {
        setRealm(principal, password, null);
    }

    public void setRealm(String principal, String password, IHttpRealm realmConfigurator) {
        Realm.Builder realmBuilder = new Realm.Builder(principal, password);
        if (realmConfigurator != null) {
            realmConfigurator.build(realmBuilder);
        }
        realm = realmBuilder.build();
    }

}