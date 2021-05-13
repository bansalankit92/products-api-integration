package com.integration.extensions.domains.sumologic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.integration.extensions.domains.sumologic.*;
import com.integration.extensions.domains.sumologic.util.CollectorUtil;
import com.integration.extensions.domains.sumologic.util.SearchJobUtil;
import com.integration.util.RestClient;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class SumoLogicExtensionImpl {

    public static final String ACCESS_TOKEN = "Base 64 Access Token";
    public static final String HOST_URL = "Host Url";
    private static final Gson gson = new Gson();

    /**
     * Fetch Create Search Job By Primary Key
     */

    public CreateSearchJob fetchCreateSearchJobByPrimaryKey(String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search For Create Search Job
     */

    public List fetchFieldsSupportingSearchForCreateSearchJob() {
        throw new UnsupportedOperationException();
    }

    /**
     * For Generic Search for entity selector for Create Search Job. The List is a List<Pair<String, Pair<String, String>>>
     */

    public List genericSearchForEntitySelectorForCreateSearchJob(List searchParams, long fetchSize,
            long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Create Create Search Job
     */

    public String createCreateSearchJob(CreateSearchJob entityDefinition) throws Exception {
        return SearchJobUtil
                .createSearchJob(restClient, entityDefinition.query, entityDefinition.from, entityDefinition.to).id;
    }

    /**
     * Update Create Search Job
     */

    public String updateCreateSearchJob(CreateSearchJob entityDefinition, String primaryKey) throws
            Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Histogram Buckets By Primary Key
     */

    public HistogramBuckets fetchHistogramBucketsByPrimaryKey(String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search For Histogram Buckets
     */

    public List fetchFieldsSupportingSearchForHistogramBuckets() {
        throw new UnsupportedOperationException();
    }

    /**
     * For Generic Search for entity selector for Histogram Buckets. The List is a List<Pair<String, Pair<String, String>>>
     */

    public List genericSearchForEntitySelectorForHistogramBuckets(List searchParams, long fetchSize,
            long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Create Histogram Buckets
     */

    public String createHistogramBuckets(HistogramBuckets entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Histogram Buckets
     */

    public String updateHistogramBuckets(HistogramBuckets entityDefinition, String primaryKey) throws
            Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Search Job Message By Primary Key
     */

    public SearchJobMessage fetchSearchJobMessageByPrimaryKey(String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search For Search Job Message
     */

    public List fetchFieldsSupportingSearchForSearchJobMessage() {
        throw new UnsupportedOperationException();
    }

    /**
     * For Generic Search for entity selector for Search Job Message. The List is a List<Pair<String, Pair<String, String>>>
     */

    public List genericSearchForEntitySelectorForSearchJobMessage(List searchParams, long fetchSize,
            long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Create Search Job Message
     */

    public String createSearchJobMessage(SearchJobMessage entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Search Job Message
     */

    public String updateSearchJobMessage(SearchJobMessage entityDefinition, String primaryKey) throws
            Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Search Job Record By Primary Key
     */

    public SearchJobRecord fetchSearchJobRecordByPrimaryKey(String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search For Search Job Record
     */

    public List fetchFieldsSupportingSearchForSearchJobRecord() {
        throw new UnsupportedOperationException();
    }

    /**
     * For Generic Search for entity selector for Search Job Record. The List is a List<Pair<String, Pair<String, String>>>
     */

    public List genericSearchForEntitySelectorForSearchJobRecord(List searchParams, long fetchSize,
            long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Create Search Job Record
     */

    public String createSearchJobRecord(SearchJobRecord entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Search Job Record
     */

    public String updateSearchJobRecord(SearchJobRecord entityDefinition, String primaryKey) throws
            Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Collectors By Primary Key
     */

    public Collectors fetchCollectorsByPrimaryKey(String primaryKey) throws Exception {
        return CollectorUtil.getCollectorById(restClient, primaryKey);
    }

    /**
     * Fetch Fields Supporting Search For Collectors
     */

    public List fetchFieldsSupportingSearchForCollectors() {
        return List.of("Name");
    }

    /**
     * Create Collectors
     */

    public String createCollectors(Collectors entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Collectors
     */

    public String updateCollectors(Collectors entityDefinition, String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search For Source API
     */

    public List fetchFieldsSupportingSearchForSourceAPI() {
        return List.of("Name");
    }

    /**
     * Create Source API
     */

    public String createSourceAPI(HostedSources entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Source API
     */

    public String updateSourceAPI(HostedSources entityDefinition, String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Create a Search Job
     */

    public CreateSearchJob createSearchJob(String query, Long from, Long to) throws Exception {

        return SearchJobUtil.createSearchJob(restClient, query, from, to);
    }

    /**
     * Get Search Job Status
     */

    public SearchJobStatus getSearchJobStatus(String jobId) throws Exception {
        return SearchJobUtil.getSearchJobStatus(restClient, jobId);
    }

    /**
     * Get Search Job Messages
     */

    public List<SearchJobMessage> getSearchJobMessages(String jobId, long pageNumber, long size) throws Exception {
        return SearchJobUtil.getSearchJobMessages(restClient, jobId, Math.max((pageNumber - 1) * size, 0), size);
    }

    /**
     * Delete Search Job
     */

    public void deleteSearchJob(String searchJobId) throws Exception {
        SearchJobUtil.deleteSearchJob(restClient, searchJobId);
    }

    /**
     * Fetch Search Job Status By Primary Key
     */

    public SearchJobStatus fetchSearchJobStatusByPrimaryKey(String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Fields Supporting Search For Search Job Status
     */

    public List fetchFieldsSupportingSearchForSearchJobStatus() {
        throw new UnsupportedOperationException();
    }

    /**
     * For Generic Search for entity selector for Search Job Status. The List is a List<Pair<String, Pair<String, String>>>
     */

    public List genericSearchForEntitySelectorForSearchJobStatus(List searchParams, long fetchSize,
            long fetchPageNumber) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Create Search Job Status
     */

    public String createSearchJobStatus(SearchJobStatus entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Search Job Status
     */

    public String updateSearchJobStatus(SearchJobStatus entityDefinition, String primaryKey) throws
            Exception {
        throw new UnsupportedOperationException();
    }

    private Map<String, Object> attributes = new HashMap<>();
    private RestClient restClient;

    public void init(final Map arg0) {
        // This is a lifecycle method.;
        attributes = arg0;
        Object url = attributes.get(HOST_URL);
        Object token = attributes.get(ACCESS_TOKEN);

        if (url == null || token == null) {
            throw new RuntimeException("Host Url or Access token cant be empty");
        }
        restClient = new RestClient(String.valueOf(url), String.valueOf(token));
    }

    private RestClient getRestClient() {
        return restClient;
    }

}
