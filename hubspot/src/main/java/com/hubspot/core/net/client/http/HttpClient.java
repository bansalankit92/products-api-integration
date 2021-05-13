package com.hubspot.core.net.client.http;

import java.net.URL;
import com.hubspot.core.net.client.async.AsyncClient;
import com.hubspot.core.net.client.http.method.HttpPostDto;
import com.net.gson.GsonObject;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.Realm;
import org.asynchttpclient.SignatureCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpClient extends AsyncClient {
    //region URL interface

    public static String toURL(boolean ssl, String host, int port, String path) {
        if (path != null) {
            assertThat(path).as("Path should begin with a /").startsWith("/");
        }

        return (ssl ? "https://" : "http://") + host + ":" + port + path;
    }

    public static String extractPath(String url) {
        String path;

        try {
            path = new URL(url).toURI().getPath();
            if (path != null) {
                path = path.trim();
            }
        } catch (Exception e) {
            path = null;
        }

        return path;
    }

    //endregion

    //region get interface

    public static <V> void get(String url, Realm realm, SignatureCalculator signatureCalculator,
            AsyncCompletionHandler<V> completionHandler) {
        BoundRequestBuilder requestBuilder = client.prepareGet(url);
        build(requestBuilder, realm, signatureCalculator, completionHandler);
    }

    //endregion

    //region post interface

    public static <K, V> HttpPostDto<K, V> postDto(String url,
            Class<K> classK, Class<V> classV) {
        return new HttpPostDto<>(url, extractPath(url), classK, classV);
    }

    public static HttpPostDto<GsonObject, GsonObject> postJson(String url) {
        return postDto(url, GsonObject.class, GsonObject.class);
    }

    public static <V> void post(String url, Realm realm, SignatureCalculator signatureCalculator, String json,
            AsyncCompletionHandler<V> completionHandler) {
        BoundRequestBuilder requestBuilder = client.preparePost(url).setBody(json);
        build(requestBuilder, realm, signatureCalculator, completionHandler);
    }

    //endregion

    //region internal

    public static <V> void build(BoundRequestBuilder requestBuilder, Realm realm,
            SignatureCalculator signatureCalculator, AsyncCompletionHandler<V> completionHandler) {
        if (realm != null) {
            requestBuilder.setRealm(realm);
        }

        if (signatureCalculator != null) {
            requestBuilder.setSignatureCalculator(signatureCalculator);
        }

        requestBuilder
                .addHeader("Connection", "Close") // important for HTTPS
                .addHeader("Cache-Control", "private, no-cache, no-store, max-age=0, must-revalidate")
                .addHeader("Pragma", "no-cache")
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .execute(completionHandler);
    }

    //endregion
}