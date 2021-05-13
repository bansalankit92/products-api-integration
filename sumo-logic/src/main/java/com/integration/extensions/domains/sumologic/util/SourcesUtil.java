package com.integration.extensions.domains.sumologic.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.sumologic.HostedSources;
import com.integration.extensions.domains.sumologic.model.SlHostedSources;
import com.integration.util.RestClient;

import java.util.HashMap;
import java.util.List;

public class SourcesUtil {

    public static final String PATH = "/api/v1/collectors";
    public static final Gson GSON = new Gson();

    public static List<HostedSources> getSources(RestClient restClient, String collectorId) {
        String res = restClient.get(PATH + "/" + collectorId + "/sources", new HashMap<>());
        SlHostedSources.SourceList status = GSON.fromJson(res, SlHostedSources.SourceList.class);
        return status.to();
    }

    public static HostedSources getSourcesById(RestClient restClient, String collectorId, String sourceId) {
        String res = restClient.get(PATH + "/" + collectorId + "/sources" + "/" + sourceId, new HashMap<>());
        SlHostedSources.SingleSource status = GSON.fromJson(res, SlHostedSources.SingleSource.class);
        return status.to();
    }

}