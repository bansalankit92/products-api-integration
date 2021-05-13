package com.net.env;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public final class EnvError
{

    private static final Logger LOGGER = LoggerFactory.getLogger(EnvError.class);

    public final EnvErrorCode errorCode;
    private Map<String, Map<String, String>> errorDetails;
    private final Throwable thrown;
    private List<EnvErrorTrace> errorTraces = new ArrayList<>();
    private Object request;
    private String nameOfTheErrorProperty;

    public EnvError(EnvErrorCode errorCode, String errorMessage) {
        this(errorCode, new RuntimeException(errorMessage));
    }

    public EnvError(EnvErrorCode errorCode, Throwable thrown) {
        LOGGER.error(String.format("%s: %s", errorCode, thrown), thrown);
        Assertions.assertThat(errorCode).isNotNull();
        this.errorCode = errorCode;
        this.thrown = thrown;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public Throwable getThrown() {
        return thrown;
    }

    public String getNameOfTheErrorProperty() {
        return nameOfTheErrorProperty;
    }

    public void setNameOfTheErrorProperty(String nameOfTheErrorProperty) {
        this.nameOfTheErrorProperty = nameOfTheErrorProperty;
    }

    public String get(Class<?> callerCls, String key) {
        assertThat(callerCls).isNotNull();
        assertThat(key).isNotNull();

        if (errorDetails != null) {
            Map<String, String> clsDetails = errorDetails.get(callerCls.getSimpleName());
            if (clsDetails != null) {
                return clsDetails.get(key);
            }
        }
        return null;
    }

    public void addErrorTrace(EnvErrorTrace errorTrace) {
        Assertions.assertThat(errorTrace).isNotNull();
        errorTraces.add(errorTrace);
    }

    public void put(Class<?> callerCls, String keyClass, long value) {
        put(callerCls, keyClass, String.valueOf(value));
    }

    public void put(Class<?> callerCls, Class<?> keyClass, String value) {
        put(callerCls, keyClass.getSimpleName(), value);
    }

    public void put(Class<?> callerCls, String key, String value) {
        assertThat(callerCls).isNotNull();
        assertThat(key).isNotNull();
        assertThat(value).isNotNull();

        if (errorDetails == null) {
            errorDetails = new LinkedHashMap<>();
        }

        Map<String, String> clsDetails =
                errorDetails.computeIfAbsent(callerCls.getSimpleName(), k -> new LinkedHashMap<>());
        clsDetails.put(key, value);
    }

}