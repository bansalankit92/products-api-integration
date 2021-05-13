package com.hubspot.core.net.client.http.result;

import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import com.net.gson.GsonObject;
import com.net.gson.GsonWrapperDeserializer;
import com.net.gson.JsonConverter;

@JsonAdapter(HttpResponseDto.Deserializer.class)
public class HttpResponseDto<V> {

    protected static class Deserializer<V extends JsonConverter> extends GsonWrapperDeserializer<HttpResponseDto<V>> {

        @SuppressWarnings("unchecked")
        @Override
        protected HttpResponseDto<V> fromGson(GsonObject gsonObj) throws JsonParseException {
            String path = gsonObj.optString(STR_Path);
            GsonObject responseObj = gsonObj.optJson(STR_Response);
            String responseClassStr = gsonObj.optString(STR_ResponseClass);

            try {
                Class<V> responseClass = (Class<V>) Class.forName(responseClassStr);
                return new HttpResponseDto<>(path, responseObj.toObject(responseClass), responseClass);
            } catch (ClassNotFoundException e) {
                throw new JsonParseException(e);
            }
        }

    }

    private static final String STR_Path = "path";
    private static final String STR_Response = "response";
    private static final String STR_ResponseClass = "responseClass";
    public final String path;
    public final V response;
    public final Class<V> responseClass;

    public HttpResponseDto(String path, V response, Class<V> responseClass) {
        this.path = path;
        this.response = response;
        this.responseClass = responseClass;
    }

}