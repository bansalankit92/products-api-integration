package com.app.extensions.domains.cloudstorage.util;

import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonMapper {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting().create();

    public static <T> T fromJson(JsonObject json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    public static <T> T fromJson(String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    public static <T> List<T> fromJson(String json, Type userListType) {
        return gson.fromJson(json, userListType);
    }

    public static <T> String toJson(T object) {
        return gson.toJson(object);
    }
}
