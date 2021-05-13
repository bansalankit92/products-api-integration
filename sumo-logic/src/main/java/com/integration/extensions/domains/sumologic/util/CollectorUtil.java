package com.integration.extensions.domains.sumologic.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.sumologic.Collectors;
import com.integration.extensions.domains.sumologic.model.SlCollectors;
import com.integration.util.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectorUtil {

    public static final String PATH = "/api/v1/collectors";
    public static final Gson GSON = new Gson();

    public static List<Collectors> getCollectors(RestClient restClient) {
        String res = restClient.get(PATH, new HashMap<>());
        SlCollectors.CList status = GSON.fromJson(res, SlCollectors.CList.class);
        return status.to();
    }

    public static Collectors getCollectorById(RestClient restClient, String collectorId) {
        Map<String, Object> qp = new HashMap<>();
        String res = restClient.get(PATH + "/" + collectorId, qp);
        SlCollectors.SingleCollector status = GSON.fromJson(res, SlCollectors.SingleCollector.class);
        return status.to();
    }


}