package com.net.gson;

import java.lang.reflect.Type;

public final class JsonConverter {

    public static String toJson(Object object) {
        return GsonBuilder.toJson(object);
    }

    public static <T> T fromJson(String json, Type type) {
        try {
            return GsonBuilder.fromJson(json, type);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public static <T> T parseObjectAs(Object payload, Type valueType) {
        return fromJson(toJson(payload), valueType);
    }

    private JsonConverter() {
    }

}
