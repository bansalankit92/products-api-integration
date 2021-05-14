package com.integration.extensions.domains.devops;

import java.util.HashMap;
import org.codehaus.jettison.json.JSONObject;

public class HostMetrics extends HashMap<String, Object> {

    private static final String LOAD = "Load";
    private static final String IOWAIT = "IO Wait";
    private static final String CPU = "CPU";

    public double getCPU() {
        String cpu = (String) get(CPU);
        return cpu == null ? 0 : Double.parseDouble(cpu);
    }

    public double getLoad() {
        String load = (String) get(LOAD);
        return load == null ? 0 : Double.parseDouble(load);
    }

    public static HostMetrics create(JSONObject json) {
        HostMetrics metrics = new HostMetrics();
        if (json == null) {
            return metrics;
        }

        metrics.put(LOAD, json.optString("load"));
        metrics.put(IOWAIT, json.optString("iowait"));
        metrics.put(CPU, json.optString("cpu"));
        return metrics;
    }
}
