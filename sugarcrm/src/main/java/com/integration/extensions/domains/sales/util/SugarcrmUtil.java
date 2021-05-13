package com.integration.extensions.domains.sales.util;

import com.integration.util.RestClient;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SugarcrmUtil {


    private final RestClient restClient;

    public SugarcrmUtil(Map<String, Object> attributes) {
        this.restClient = new RestClient(attributes);
    }

    public String search(String module, String key, String value) throws IOException {
        String filter = String.format("{\"%s\":{\"$contains\":\"%s\"}}", key, value);
        return get(module, filter, new HashMap<>());
    }

    public String search(String module, Map<String, String> andFilters, long page, long size) throws IOException {
        String filter = null;
        String andfilter = "";
        if (!andFilters.isEmpty()) {
            for (Map.Entry<String, String> entry : andFilters.entrySet()) {
                andfilter += String.format("{\"%s\":{\"$contains\":\"%s\"}}", entry.getKey(), entry.getValue()) + ",";
            }
            andfilter = andfilter.substring(0, andfilter.length() - 1);
            filter = String.format("[{\"$and\":[%s]}]", andfilter);
        }
        Map<String, Object> queryParams = new HashMap<>();
               queryParams.put("offset", Math.max((page - 1) * size, 0));
               queryParams.put("max_num", size);
        return get(module, filter, queryParams);
    }

    public String greaterThen(String module, String key, String value) throws IOException {
        String filter = String.format("{\"%s\":{\"$gte\":\"%s\"}}", key, value);
        return get(module, filter, new HashMap<>());
    }

    public String search(String module, String key, String value, long page, long size) throws IOException {
        String filter = String.format("{\"%s\":{\"$contains\":\"%s\"}}", key, value);
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("offset", Math.max((page - 1) * size, 0));
        queryParams.put("max_num", size);
        return get(module, filter, queryParams);
    }

    public String get(String module, long page, long size) throws IOException {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("offset", Math.max((page - 1) * size, 0));
        queryParams.put("max_num", size);
        return get(module, "", queryParams);
    }

    public String getById(String module, String id) throws IOException {
        Map<String, Object> queryParams = new HashMap<>();
        return get(module + "/" + id, "", queryParams);
    }

    public String getMe() throws IOException {
        Map<String, Object> queryParams = new HashMap<>();
        return get("/me", "", queryParams);
    }

    public String get(String module, String filter, Map<String, Object> queryParams) {
        if (queryParams == null) queryParams = new HashMap<>();
        if (filter != null && !filter.isEmpty())
            queryParams.put("filter", URLEncoder.encode("[" + filter + "]", StandardCharsets.UTF_8).replace("+", "%20"));
        return restClient.get("/" + module, queryParams);
    }

    public String get(String module) {
        return get(module, "", new HashMap<>());
    }

    public String post(String module, String body) {
        return restClient.post("/" + module, body);
    }

    public String put(String module, String id, String body) {
        System.out.println(body);
        return restClient.put("/" + module + "/" + id, (body));
    }

    public static Map<String, String> getDifference(Object old, Object newObj) throws IllegalAccessException {
        Map<String, String> values = new HashMap<>();
        for (Field field : old.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value1 = field.get(old);
            Object value2 = field.get(newObj);
            if (value1 != null && value2 != null) {
                if (!Objects.equals(value1, value2)) {
                    if (!field.getName().toLowerCase().contains("date") && !field.getName().contains("id"))
                        try {
                            values.put(field.getName(), (String) value2);
                        } catch (Exception ig) {
                            System.out.println("Got exception difference on field:" + field.getName());
                        }
                }
            }
        }
        return values;
    }


}