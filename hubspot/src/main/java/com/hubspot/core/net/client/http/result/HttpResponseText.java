package com.hubspot.core.net.client.http.result;

public class HttpResponseText {

    public final String path;
    public final String contentType;
    public final String content;

    public HttpResponseText(String path, String contentType, String content) {
        this.path = path;
        this.contentType = contentType;
        this.content = content;
    }

}