package com.net.gson;

import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public abstract class GsonWrapperSerializer<T> extends GsonWrapperDeserializer<T> implements JsonSerializer<T> {

    public final JsonElement serialize(T obj, Type type, JsonSerializationContext context) {
        return toGson(obj).jsonObj;
    }

    public abstract GsonObject toGson(T obj);

}
