package com.net.gson;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@SuppressWarnings({"unused", "unchecked", "UnusedReturnValue", "OverlyComplexClass"})
public final class GsonObject {

    public static GsonObject fromObject(Object dto) {
        return new GsonObject(JsonConverter.toJson(dto));
    }

    public static boolean isNull(JsonElement jsonElement) {
        return jsonElement == null || jsonElement.isJsonNull();
    }

    public static boolean isNull(JsonElement... jsonElements) {
        for (JsonElement jsonElement : jsonElements) {
            if (isNull(jsonElement)) {
                return true;
            }
        }
        return false;
    }

    JsonObject jsonObj;

    public GsonObject() {
        this(new JsonObject());
    }

    public GsonObject(String json) {
        this(GsonBuilder.toJson(json).getAsJsonObject());
    }

    //region misc methods

    public GsonObject(JsonObject jsonObj) {
        if (jsonObj == null) {
            throw new IllegalArgumentException();
        }

        this.jsonObj = jsonObj;
    }

    public GsonObject(Map<String, String> stringMap) {
        this();

        if (stringMap != null) {
            for (Map.Entry<String, String> entry : stringMap.entrySet()) {
                jsonObj.addProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean isGson() {
        return true;
    }

    public String toString() {
        return jsonObj.toString();
    }

    public String toPrettyString()
    {
        return GsonBuilder.toPrettyJson(this);
    }

    public JsonObject getJsonObject() {
        return jsonObj;
    }

    public GsonArray keyArray() {
        GsonArray array = new GsonArray();
        for (String key : keySet()) {
            array.add(key);
        }
        return array;
    }

    public boolean has(String key) {
        return !isNull(key);
    }

    public int length() {
        return jsonObj.size();
    }

    public boolean isNull(String key) {
        return isNull(jsonObj.get(key));
    }

    public Set<String> keySet() {
        return jsonObj.keySet();
    }

    //endregion

    //region gets

    public void remove(String key) {
        jsonObj.remove(key);
    }

    public boolean isPrimitive(String key) {
        JsonElement jsonElement = jsonObj.get(key);
        return jsonElement != null && !jsonElement.isJsonNull() && jsonElement.isJsonPrimitive();
    }

    public boolean isArray(String key) {
        JsonElement jsonElement = jsonObj.get(key);
        return jsonElement != null && !jsonElement.isJsonNull() && jsonElement.isJsonArray();
    }

    public boolean isJsonObj(String key) {
        JsonElement jsonElement = jsonObj.get(key);
        return jsonElement != null && !jsonElement.isJsonNull() && jsonElement.isJsonObject();
    }

    public Object getPrimitive(String key) {
        JsonPrimitive elem = check(key).getAsJsonPrimitive();
        if (elem.isBoolean()) {
            return elem.getAsBoolean();
        } else if (elem.isString()) {
            return elem.getAsString();
        } else if (elem.isNumber()) {
            return elem.getAsNumber();
        } else {
            throw new RuntimeException("Invalid type");
        }
    }
    
    public String getString(String key) {
        return check(key).getAsString();
    }

    public GsonObject getJson(String key) {
        return new GsonObject(check(key).getAsJsonObject());
    }

    public boolean getBoolean(String key) {
        return check(key).getAsBoolean();
    }

    public int getInt(String key) {
        return check(key).getAsInt();
    }

    public long getLong(String key) {
        return check(key).getAsLong();
    }

    public byte getByte(String key) {
        return check(key).getAsByte();
    }

    public float getFloat(String key) {
        return check(key).getAsFloat();
    }

    public double getDouble(String key) {
        return check(key).getAsDouble();
    }

    //endregion

    //region opts

    public String[] getStringArray(String key) {
        GsonArray array = getArray(key);
        String[] syncIds = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            syncIds[i] = array.getString(i);
        }
        return syncIds;
    }

    public GsonArray getArray(String key) {
        return new GsonArray(check(key).getAsJsonArray());
    }

    public boolean optBoolean(String key) {
        return optBoolean(key, false);
    }

    public boolean optBoolean(String key, boolean defaultValue) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? defaultValue : jsonElement.getAsBoolean();
    }

    public byte optByte(String key) {
        return optByte(key, (byte) 0);
    }

    public byte optByte(String key, byte defaultValue) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? defaultValue : jsonElement.getAsByte();
    }

    public int optInt(String key) {
        return optInt(key, 0);
    }

    public int optInt(String key, int defaultValue) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? defaultValue : jsonElement.getAsInt();
    }

    public long optLong(String key) {
        return optLong(key, 0L);
    }

    public long optLong(String key, long defaultValue) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? defaultValue : jsonElement.getAsLong();
    }

    public String optString(String key) {
        return optString(key, null);
    }

    public String optString(String key, String defaultValue) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? defaultValue : jsonElement.getAsString();
    }

    public float optFloat(String key) {
        return optFloat(key, 0f);
    }

    public float optFloat(String key, float defaultValue) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? defaultValue : jsonElement.getAsFloat();
    }

    public double optDouble(String key) {
        return optDouble(key, Double.NaN);
    }

    public double optDouble(String key, double defaultValue) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? defaultValue : jsonElement.getAsDouble();
    }

    //endregion

    //region puts

    public GsonObject optJson(String key) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? null : new GsonObject(jsonElement.getAsJsonObject());
    }

    public String[] optStringArray(String key) {
        GsonArray array = optArray(key);
        if (array == null) {
            return null;
        }

        String[] syncIds = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            syncIds[i] = array.optString(i);
        }
        return syncIds;
    }

    public GsonArray optArray(String key) {
        JsonElement jsonElement = jsonObj.get(key);
        return isNull(jsonElement) ? null : new GsonArray(jsonElement.getAsJsonArray());
    }

    public GsonObject put(String key, Object value) {
        return put(key, value == null ? null : GsonObject.fromObject(value));
    }

    public GsonObject put(String key, GsonObject value) {
        if (value == null) {
            jsonObj.remove(key);
        } else {
            jsonObj.add(key, value.jsonObj);
        }
        return this;
    }

    public GsonObject putEvenIfNull(String key, GsonObject value) {
        jsonObj.add(key, value == null ? null : value.jsonObj);
        return this;
    }

    public GsonObject put(String key, Boolean value) {
        jsonObj.addProperty(key, value);
        return this;
    }

    public GsonObject put(String key, Byte value) {
        jsonObj.addProperty(key, value);
        return this;
    }

    public GsonObject put(String key, Integer value) {
        jsonObj.addProperty(key, value);
        return this;
    }

    public GsonObject put(String key, Long value) {
        jsonObj.addProperty(key, value);
        return this;
    }

    public GsonObject put(String key, Float value) {
        jsonObj.addProperty(key, value);
        return this;
    }

    public GsonObject put(String key, Double value) {
        jsonObj.addProperty(key, value);
        return this;
    }

    public GsonObject put(String key, String value) {
        if (value == null) {
            jsonObj.remove(key);
        } else {
            jsonObj.addProperty(key, value);
        }
        return this;
    }

    public GsonObject putEvenIfNull(String key, String value) {
        jsonObj.addProperty(key, value);
        return this;
    }

    //endregion

    //region object interface

    public GsonObject put(String key, GsonArray value) {
        if (value == null) {
            jsonObj.remove(key);
        } else {
            jsonObj.add(key, value.jsonArray);
        }
        return this;
    }

    public GsonObject put(String key, Collection<String> values) {
        if (values == null) {
            jsonObj.remove(key);
        } else {
            jsonObj.add(key, new GsonArray(values).jsonArray);
        }

        return this;
    }

    public GsonObject put(String key, String[] values) {
        if (values == null) {
            jsonObj.remove(key);
        } else {
            jsonObj.add(key, new GsonArray(values).jsonArray);
        }

        return this;
    }

    //endregion

    public GsonObject put(String key, int[] values) {
        if (values == null) {
            jsonObj.remove(key);
        } else {
            jsonObj.add(key, new GsonArray(values).jsonArray);
        }

        return this;
    }

    public <T> T toObject(Type tType) {
        return JsonConverter.fromJson(JsonConverter.toJson(this), tType);
    }

    public JsonElement check(String key) {
        JsonElement jsonElement = jsonObj.get(key);
        if (isNull(jsonElement)) {
            throw new GsonException("Key, " + key + ", not found in json");
        }
        return jsonElement;
    }

    public JsonElement opt(String key)
    {
        return jsonObj.get(key);
    }
}