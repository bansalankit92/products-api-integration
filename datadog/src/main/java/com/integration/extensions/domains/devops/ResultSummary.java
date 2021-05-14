package com.integration.extensions.domains.devops;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ResultSummary extends HashMap<String, Object> {

    //Common
    private static final String ERROR_MESSAGE = "Error message";
    private static final String TOTAL = "Total";

    //Browser test result
    private static final String STEPS = "Steps";
    private static final String ERROR_COUNT = "Error count";
    private static final String DURATION = "Duration";
    private static final String DEVICE = "Device";

    private static final String COMPLETED = "Completed";

    private static final String DEVICE_ID = "Device Id";
    private static final String NAME = "Name";
    private static final String HEIGHT = "Height";
    private static final String WIDTH = "width";
    private static final String USER_AGENT = "User agent";
    private static final String BROWSER = "Browser";
    private static final String IS_MOBILE = "Is Mobile";

    //API test result
    private static final String TIMINGS = "Timings";
    private static final String DNS = "DNS";
    private static final String DOWNLOAD = "Download";
    private static final String FIRST_BYTE = "First byte";
    private static final String HANDSHAKE = "Handshake";
    private static final String REDIRECT = "Redirect";
    private static final String SSL = "SSL";
    private static final String TCP = "TCP";
    private static final String WAIT = "Wait";

    public static ResultSummary create(JSONObject json) throws JSONException {
        ResultSummary result = new ResultSummary();
        if (json == null) {
            return result;
        }

        result.put(ERROR_MESSAGE, json.optString("errorMessage"));
        result.put(TIMINGS, createTimings(json.optJSONObject("timings")));
        if (json.has("stepCountCompleted") && json.has("stepCountTotal")) {
            Map<String, Object> steps = new LinkedHashMap<>();
            steps.put(COMPLETED, json.getString("stepCountCompleted"));
            steps.put(TOTAL, json.getString("stepCountTotal"));
            result.put(STEPS, steps);
        }
        result.put(ERROR_COUNT, json.optString("errorCount", null));
        result.put(DURATION, json.optString("duration", null));
        result.put(DEVICE, createDevice(json.optJSONObject("device")));
        return result;
    }

    private static Map<String, Object> createTimings(JSONObject json) {
        if (json == null) {
            return null;
        }

        Map<String, Object> timings = new LinkedHashMap<>();
        timings.put(DNS, json.optString("dns", null));
        timings.put(DOWNLOAD, json.optString("download", null));
        timings.put(FIRST_BYTE, json.optString("firstByte", null));
        timings.put(HANDSHAKE, json.optString("handshake", null));
        timings.put(REDIRECT, json.optString("redirect", null));
        timings.put(SSL, json.optString("ssl", null));
        timings.put(TCP, json.optString("tcp", null));
        timings.put(TOTAL, json.optString("total", null));
        timings.put(WAIT, json.optString("wait", null));
        return timings;
    }

    private static Map<String, Object> createDevice(JSONObject json) {
        if (json == null) {
            return null;
        }

        Map<String, Object> device = new LinkedHashMap<>();
        device.put(DEVICE_ID, json.optString("id"));
        device.put(NAME, json.optString("name"));
        device.put(HEIGHT, json.optString("height"));
        device.put(WIDTH, json.optString("width"));
        device.put(USER_AGENT, json.optString("userAgent", null));
        device.put(BROWSER, json.optString("browser", null));
        device.put(IS_MOBILE, json.optBoolean("isMobile", false));
        return device;
    }
}
