package com.integration.extensions.domains.devops;

import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;

public class CrashSummary extends HashMap<String, Object> {

    private static final String SUPPORTS_CRASH_DATA = "Supports crash data";
    private static final String UNRESOLVED_CRASH_COUNT = "Unresolved crash count";
    private static final String CRASH_COUNT = "Crash count";
    private static final String CRASH_RATE = "Crash rate";

    public static CrashSummary create(JSONObject json) {
        CrashSummary crashSummary = new CrashSummary();
        crashSummary.put(SUPPORTS_CRASH_DATA, json.optBoolean("supports_crash_data"));
        crashSummary.put(UNRESOLVED_CRASH_COUNT, json.optString("unresolved_crash_count"));
        crashSummary.put(CRASH_COUNT, json.optString("crash_count"));
        crashSummary.put(CRASH_RATE, json.optString("crash_rate"));
        return crashSummary;
    }
}
