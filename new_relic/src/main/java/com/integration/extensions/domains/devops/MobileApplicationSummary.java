package com.integration.extensions.domains.devops;

import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;

public class MobileApplicationSummary extends HashMap<String, Object> {

    private static final String ACTIVE_USERS = "Active users";
    private static final String LAUNCH_COUNT = "Launch count";
    private static final String THROUGHPUT = "Throughput";
    private static final String RESPONSE_TIME = "Response time";
    private static final String CALLS_PER_SESSION = "Calls/session";
    private static final String INTERACTION_TIME = "Interaction time";
    private static final String FAILED_CALL_RATE = "Failed call rate";
    private static final String REMOTE_ERROR_RATE = "remote_error_rate";

    public static MobileApplicationSummary create(JSONObject json) {
        MobileApplicationSummary mobileAppSummary = new MobileApplicationSummary();
        mobileAppSummary.put(ACTIVE_USERS, json.optString("active_users"));
        mobileAppSummary.put(LAUNCH_COUNT, json.optString("launch_count"));
        mobileAppSummary.put(THROUGHPUT, json.optString("throughput"));
        mobileAppSummary.put(RESPONSE_TIME, json.optString("response_time"));
        mobileAppSummary.put(CALLS_PER_SESSION, json.optString("calls_per_session"));
        mobileAppSummary.put(INTERACTION_TIME, json.optString("interaction_time"));
        mobileAppSummary.put(FAILED_CALL_RATE, json.optString("failed_call_rate"));
        mobileAppSummary.put(REMOTE_ERROR_RATE, json.optString("remote_error_rate"));
        return mobileAppSummary;
    }
}
