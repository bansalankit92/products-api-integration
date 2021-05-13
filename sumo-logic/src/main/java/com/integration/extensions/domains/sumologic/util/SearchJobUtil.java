package com.integration.extensions.domains.sumologic.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.sumologic.CreateSearchJob;
import com.integration.extensions.domains.sumologic.SearchJobMessage;
import com.integration.extensions.domains.sumologic.SearchJobRecord;
import com.integration.extensions.domains.sumologic.SearchJobStatus;
import com.integration.extensions.domains.sumologic.model.SlCreateSearchJob;
import com.integration.extensions.domains.sumologic.model.SlSearchJobMessage;
import com.integration.extensions.domains.sumologic.model.SlSearchJobRecord;
import com.integration.extensions.domains.sumologic.model.SlSearchJobStatus;
import com.integration.util.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchJobUtil {

    public static final String PATH = "/api/v1/search/jobs";
    public static final Gson GSON = new Gson();

    public static CreateSearchJob createSearchJob(RestClient restClient, String query, long from, long to) {
        SlCreateSearchJob c = new SlCreateSearchJob(from, to, query);

        String res = restClient.post(PATH, GSON.toJson(c));
        SlCreateSearchJob.Create create = GSON.fromJson(res, SlCreateSearchJob.Create.class);
        c.setId(create.id);
        return c.to();
    }

    public static SearchJobStatus getSearchJobStatus(RestClient restClient, String jobId) {
        String res = restClient.get(PATH + "/" + jobId, new HashMap<>());
        SlSearchJobStatus status = GSON.fromJson(res, SlSearchJobStatus.class);
        return status.to();
    }

    public static List<SearchJobMessage> getSearchJobMessages(RestClient restClient, String jobId, long offset, long limit) {
        Map<String, Object> qp = new HashMap<>();
        qp.put("limit", limit);
        qp.put("offset", offset);
        String res = restClient.get(PATH + "/" + jobId + "/messages", qp);
        SlSearchJobMessage status = GSON.fromJson(res, SlSearchJobMessage.class);
        return status.to();
    }

    public static List<SearchJobRecord> getSearchJobRecords(RestClient restClient, String jobId, long offset, long limit) {
        Map<String, Object> qp = new HashMap<>();
        qp.put("limit", limit);
        qp.put("offset", offset);
        String res = restClient.get(PATH + "/" + jobId + "/records", qp);
        SlSearchJobRecord status = GSON.fromJson(res, SlSearchJobRecord.class);
        return status.to();
    }


    public static void deleteSearchJob(RestClient restClient, String jobId) {
        restClient.delete(PATH + "/" + jobId, new HashMap<>());

    }

}