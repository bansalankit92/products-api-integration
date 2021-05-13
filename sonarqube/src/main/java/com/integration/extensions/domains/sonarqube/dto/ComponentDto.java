package com.integration.extensions.domains.sonarqube.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComponentDto {

    @SerializedName("Key")
    public String key;
    @SerializedName("Name")
    public String name;
    @SerializedName("Description")
    public String description;
    @SerializedName("Qualifier")
    public String qualifier;
    @SerializedName("Path")
    public String path;
    @SerializedName("Language")
    public String language;
    @SerializedName("Metrics")
    public List<Measure> measures;


    public static class Measure {
        @SerializedName("Metric")
        public String metric;
        @SerializedName("Value")
        public String value;

        public Measure(String metric, String value) {
            this.metric = metric;
            this.value = value;
        }
    }
}