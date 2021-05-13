package com.net.gson;

import java.lang.reflect.Type;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public abstract class GsonWrapperDeserializer<T> implements JsonDeserializer<T> {

    public final T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return jsonElement.isJsonNull() ? null : fromGson(new GsonObject(jsonElement.getAsJsonObject()));
    }

    protected abstract T fromGson(GsonObject gsonObj) throws JsonParseException;

}
