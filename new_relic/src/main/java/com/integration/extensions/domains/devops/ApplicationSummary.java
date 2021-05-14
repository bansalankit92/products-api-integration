package com.integration.extensions.domains.devops;

import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;

public class ApplicationSummary extends HashMap<String, Object> {

    private static final String RESPONSE_TIME = "Response time";
    private static final String THROUGHPUT = "Throughput";
    public static final String ERROR_RATE = "Error rate";
    public static final String APDEX_TARGET = "APDEX target";
    public static final String APDEX_SCORE = "APDEX score";
    private static final String HOST_COUNT = "Host count";
    private static final String INSTANCE_COUNT = "Instance count";
    private static final String CONCURRENT_INSTANCE_COUNT = "Concurrent instance count";

    public float getApdexTarget() {
        String target = (String) get(APDEX_TARGET);
        return target == null ? 0 : Float.parseFloat(target);
    }

    public float getApdexScore() {
        String score = (String) get(APDEX_SCORE);
        return score == null ? 0 : Float.parseFloat(score);
    }

    public float getErrorRate() {
        String score = (String) get(ERROR_RATE);
        return score == null ? 0F : Float.parseFloat(score);
    }

    public static ApplicationSummary create(JSONObject json) {
        ApplicationSummary applicationSummary = new ApplicationSummary();
        applicationSummary.put(RESPONSE_TIME, json.optString("response_time"));
        applicationSummary.put(THROUGHPUT, json.optString("throughput"));
        applicationSummary.put(ERROR_RATE, json.optString("error_rate"));
        applicationSummary.put(APDEX_TARGET, json.optString("apdex_target"));
        applicationSummary.put(APDEX_SCORE, json.optString("apdex_score"));
        applicationSummary.put(HOST_COUNT, json.optString("host_count"));
        applicationSummary.put(INSTANCE_COUNT, json.optString("instance_count"));
        applicationSummary.put(CONCURRENT_INSTANCE_COUNT, json.optString("concurrent_instance_count"));
        return applicationSummary;
    }
}
