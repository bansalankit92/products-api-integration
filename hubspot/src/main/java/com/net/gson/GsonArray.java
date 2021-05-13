package com.net.gson;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

@SuppressWarnings({"unused", "ClassWithTooManyConstructors", "ClassWithTooManyMethods", "OverlyComplexClass"})
public class GsonArray {

    private static class GsonObjectIterator implements Iterator<GsonObject> {

        private final JsonArray jsonArray;
        private int index;
        private GsonObject next;

        public GsonObjectIterator(JsonArray jsonArray) {
            this.jsonArray = jsonArray;
            searchNext();
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public GsonObject next() {
            if (next == null) {
                throw new NoSuchElementException();
            } else {
                GsonObject json = next;
                searchNext();
                return json;
            }
        }

        private void searchNext() {
            next = null;

            for (int i = index; i < jsonArray.size(); i++) {
                JsonElement elem = jsonArray.get(i);
                if (elem != null && elem.isJsonObject()) {
                    next = new GsonObject(elem.getAsJsonObject());
                    index = i + 1;
                    return;
                }
            }

            index = jsonArray.size();
        }

    }

    final JsonArray jsonArray;

    public GsonArray() {
        this(new JsonArray());
    }

    public GsonArray(JsonArray jsonArray) {
        if (jsonArray == null) {
            throw new IllegalArgumentException();
        }

        this.jsonArray = jsonArray;
    }

    public GsonArray(String json) {
        this(GsonBuilder.toJson(json).getAsJsonArray());
    }

    public GsonArray(Collection<String> values) {
        this();

        for (String value : values) {
            jsonArray.add(value);
        }
    }

    public GsonArray(String[] values) {
        this();

        for (String value : values) {
            jsonArray.add(value);
        }
    }

    public GsonArray(int[] values) {
        this();

        for (int value : values) {
            jsonArray.add(value);
        }
    }

    public String getString(int index) {
        return check(index).getAsString();
    }

    public int getInt(int index) {
        return check(index).getAsInt();
    }

    public long getLong(int index) {
        return check(index).getAsLong();
    }

    public double getDouble(int index) {
        return check(index).getAsDouble();
    }

    public boolean getBoolean(int index) {
        return check(index).getAsBoolean();
    }

    public byte getByte(int index) {
        return check(index).getAsByte();
    }

    public float getFloat(int index) {
        return check(index).getAsFloat();
    }

    public char getChar(int index) {
        return check(index).getAsCharacter();
    }

    public GsonObject getJson(int index) {
        return new GsonObject(check(index).getAsJsonObject());
    }

    public GsonArray getArray(int index) {
        return new GsonArray(check(index).getAsJsonArray());
    }

    public GsonObject optJson(int index) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? null : new GsonObject(elem.getAsJsonObject());
    }

    public String optString(int index) {
        return optString(index, null);
    }

    public byte optByte(int index, byte defaultValue) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? defaultValue : elem.getAsByte();
    }

    public int optInteger(int index, int defaultValue) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? defaultValue : elem.getAsInt();
    }

    public long optLong(int index, long defaultValue) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? defaultValue : elem.getAsLong();
    }

    public float optFloat(int index, float defaultValue) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? defaultValue : elem.getAsFloat();
    }

    public double optDouble(int index, double defaultValue) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? defaultValue : elem.getAsDouble();
    }

    public boolean optBoolean(int index, boolean defaultValue) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? defaultValue : elem.getAsBoolean();
    }

    public String optString(int index, String defaultValue) {
        JsonElement elem = optElem(index);
        return GsonObject.isNull(elem) ? defaultValue : elem.getAsString();
    }

    public GsonArray set(int index, String value) {
        jsonArray.set(index, new JsonPrimitive(value));
        return this;
    }

    public GsonArray set(int index, byte value) {
        jsonArray.set(index, new JsonPrimitive(value));
        return this;
    }

    public GsonArray set(int index, int value) {
        jsonArray.set(index, new JsonPrimitive(value));
        return this;
    }

    public GsonArray set(int index, long value) {
        jsonArray.set(index, new JsonPrimitive(value));
        return this;
    }

    public GsonArray set(int index, boolean value) {
        jsonArray.set(index, new JsonPrimitive(value));
        return this;
    }

    public GsonArray set(int index, float value) {
        jsonArray.set(index, new JsonPrimitive(value));
        return this;
    }

    public GsonArray set(int index, double value) {
        jsonArray.set(index, new JsonPrimitive(value));
        return this;
    }

    public GsonArray set(int index, GsonArray value) {
        jsonArray.set(index, value == null ? JsonNull.INSTANCE : value.jsonArray);
        return this;
    }

    public GsonArray set(int index, GsonObject value) {
        jsonArray.set(index, value == null ? JsonNull.INSTANCE : value.jsonObj);
        return this;
    }

    public GsonArray add(String value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(int value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(long value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(double value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(float value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(boolean value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(byte value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(char value) {
        jsonArray.add(value);
        return this;
    }

    public GsonArray add(Object value) {
        return add(value == null ? null : GsonObject.fromObject(value));
    }

    public GsonArray add(GsonObject json) {
        jsonArray.add(json == null ? JsonNull.INSTANCE : json.jsonObj);
        return this;
    }

    public GsonArray add(GsonArray array) {
        jsonArray.add(array == null ? JsonNull.INSTANCE : array.jsonArray);
        return this;
    }

    public GsonArray add(int index, GsonObject json) {
        if (index < 0) {
            throw new GsonException("GsonArray[" + index + "] not found.");
        }

        JsonElement value = json == null ? JsonNull.INSTANCE : json.jsonObj;

        if (index < size()) {
            jsonArray.set(index, value);
        } else {
            while (index != size()) {
                jsonArray.add(JsonNull.INSTANCE);
            }

            jsonArray.add(value);
        }

        return this;
    }

    public void remove(int index) {
        jsonArray.remove(index);
    }

    @SuppressWarnings("Convert2Lambda")
    public Iterable<GsonObject> getAllObjects() {
        return new Iterable<>() {
            @SuppressWarnings("NullableProblems")
            @Override
            public Iterator<GsonObject> iterator() {
                return new GsonObjectIterator(jsonArray);
            }
        };
    }

    public int size() {
        return jsonArray.size();
    }

    public boolean isNull(int index) {
        if (index >= 0 && index < jsonArray.size()) {
            return GsonObject.isNull(jsonArray.get(index));
        }

        return true;
    }

    //region private

    public String toString() {
        return jsonArray.toString();
    }

    private JsonElement check(int index) {
        JsonElement elem = optElem(index);
        if (GsonObject.isNull(elem)) {
            throw new GsonException("Index, " + index + ", element is null");
        }

        return elem;
    }

    //endregion

    private JsonElement optElem(int index) {
        if (index >= 0 || index < jsonArray.size()) {
            JsonElement jsonElement = jsonArray.get(index);
            if (!GsonObject.isNull(jsonElement)) {
                return jsonElement;
            }
        }

        return null;
    }

}