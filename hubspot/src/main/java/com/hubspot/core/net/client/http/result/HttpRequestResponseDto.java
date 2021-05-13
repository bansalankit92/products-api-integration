package com.hubspot.core.net.client.http.result;

import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import com.net.gson.GsonObject;
import com.net.gson.GsonWrapperDeserializer;

@JsonAdapter(HttpRequestResponseDto.Deserializer.class)
public class HttpRequestResponseDto<K, V> {

    protected static class Deserializer<K, V>
            extends GsonWrapperDeserializer<HttpRequestResponseDto<K, V>> {

        @SuppressWarnings("unchecked")
        @Override
        protected HttpRequestResponseDto<K, V> fromGson(GsonObject gsonObj) throws JsonParseException {
            String path = gsonObj.optString(STR_Path);
            GsonObject requestObj = gsonObj.optJson(STR_Request);
            String requestClassStr = gsonObj.optString(STR_RequestClass);
            GsonObject responseObj = gsonObj.optJson(STR_Response);
            String responseClassStr = gsonObj.optString(STR_ResponseClass);

            try {
                Class<K> requestClass = (Class<K>) Class.forName(requestClassStr);
                Class<V> responseClass = (Class<V>) Class.forName(responseClassStr);
                return new HttpRequestResponseDto<>(path, requestObj.toObject(requestClass), requestClass,
                        responseObj.toObject(responseClass), responseClass);
            } catch (ClassNotFoundException e) {
                throw new JsonParseException(e);
            }
        }

    }

    private static final String STR_Path = "path";
    private static final String STR_Request = "request";
    private static final String STR_RequestClass = "requestClass";
    private static final String STR_Response = "response";
    private static final String STR_ResponseClass = "responseClass";
    public final String path;
    public final K request;
    public final Class<K> requestClass;
    public final V response;
    public final Class<V> responseClass;

    public HttpRequestResponseDto(String path, K request, Class<K> requestClass, V response, Class<V> responseClass) {
        this.path = path;
        this.request = request;
        this.requestClass = requestClass;
        this.response = response;
        this.responseClass = responseClass;
    }

}