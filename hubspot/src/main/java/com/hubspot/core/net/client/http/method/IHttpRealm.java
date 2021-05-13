package com.hubspot.core.net.client.http.method;

import org.asynchttpclient.Realm;

public interface IHttpRealm {

    void build(Realm.Builder realmBuilder);

}
