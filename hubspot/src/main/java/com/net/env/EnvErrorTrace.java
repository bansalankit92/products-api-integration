package com.net.env;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EnvErrorTrace
{
    public final Class<?> pipelineClass;
    public final Object eventIn;
    public Map<String, String> errorDetails;
    public List<Map<String, String>> latchDebugList;

    public EnvErrorTrace(Class<?> pipelineClass, Object eventIn) {
        this.pipelineClass = pipelineClass;
        this.eventIn = eventIn;
    }

    public void putLatch(String latchName, String latchValue) {
        assertThat(latchName).isNotNull();
        if (latchDebugList == null) {
            latchDebugList = new LinkedList<>();
        }
        latchDebugList.add(Map.of("LatchName", latchName, "LatchValue", latchValue));
    }

    public void put(String keyClass, long value) {
        put(keyClass, String.valueOf(value));
    }

    public void put(Class<?> keyClass, String value) {
        put(keyClass.getSimpleName(), value);
    }

    public void put(String key, String value) {
        assertThat(key).isNotNull();
        assertThat(value).isNotNull();

        if (errorDetails == null) {
            errorDetails = new LinkedHashMap<>();
        }

        errorDetails.put(key, value);
    }

}