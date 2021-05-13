package com.net.gson;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;
import com.google.gson.*;

public class GsonBuilder {

    private static class GsonObjectSerializer implements JsonSerializer<GsonObject>, JsonDeserializer<GsonObject> {

        @Override
        public JsonElement serialize(GsonObject src, Type typeOfSrc, JsonSerializationContext context) {
            return src.jsonObj;
        }

        @Override
        public GsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return json.isJsonNull()
                    ? null
                    : new GsonObject(json.getAsJsonObject());
        }

    }

    private static class GsonArraySerializer implements JsonSerializer<GsonArray>, JsonDeserializer<GsonArray> {

        @Override
        public JsonElement serialize(GsonArray src, Type typeOfSrc, JsonSerializationContext context) {
            return src.jsonArray;
        }

        @Override
        public GsonArray deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return json.isJsonNull()
                    ? null
                    : new GsonArray(json.getAsJsonArray());
        }

    }

    private static class ClassSerializer implements JsonSerializer<Class<?>>, JsonDeserializer<Class<?>> {

        @Override
        public JsonElement serialize(Class<?> src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getName());
        }

        @Override
        public Class<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            if (json.isJsonNull()) {
                return null;
            }
            try {
                return Class.forName(json.getAsString());
            } catch (ClassNotFoundException e) {
                return null;
            }
        }

    }

    private static final JsonParser jsonParser = new JsonParser();
    private static Gson gson = createGson(false);
    private static Gson gson_prettyPrint = createGson(true);

    public static void setTypeAdapters(Map<Class<?>, ?> typeAdapters) {
        gson = createGson(false, typeAdapters);
        gson_prettyPrint = createGson(true, typeAdapters);
    }

    private static Gson createGson(boolean prettyPrint, Map<Class<?>, ?> typeAdapters) {
        com.google.gson.GsonBuilder gsonBuilder = new com.google.gson.GsonBuilder()
                .registerTypeAdapter(GsonObject.class, new GsonObjectSerializer())
                .registerTypeAdapter(GsonArray.class, new GsonArraySerializer())
                .registerTypeAdapter(Class.class, new ClassSerializer())
                .enableComplexMapKeySerialization();
        if (typeAdapters != null) {
            for (Map.Entry<Class<?>, ?> entry : typeAdapters.entrySet()) {
                gsonBuilder.registerTypeAdapter(entry.getKey(), entry.getValue());
            }
        }

        if (prettyPrint) {
            gsonBuilder.setPrettyPrinting();
        }

        return gsonBuilder.create();
    }

    private static Gson createGson(boolean prettyPrint) {
        return createGson(prettyPrint, Collections.emptyMap());
    }

    //region serializers

    static JsonElement toJson(String json) {
        try {
            return jsonParser.parse(json);
        } catch (Exception e) {
            throw new GsonException(e);
        }
    }

    public static String toJson(Object dto) {
        return gson.toJson(dto);
    }

    public static GsonObject toJsonObject(Object dto) {
        return new GsonObject(gson.toJsonTree(dto).getAsJsonObject());
    }

    public static String toPrettyJson(Object dto) {
        return gson_prettyPrint.toJson(dto);
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String json, Type type) {
        return json == null ? null : (T) gson.fromJson(json, type);
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(GsonObject json, Type type) {
            return json == null || json.jsonObj == null ? null : (T) gson.fromJson(json.jsonObj, type);
    }
    //endregion
}