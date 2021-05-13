package com.integration.extensions.domains.sonarqube.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MetricsDto {
    @SerializedName("Key")
    public String key;
    @SerializedName("Name")
    public String name;
    @SerializedName("Description")
    public String Description;
    @SerializedName("Metrics")
    public List<Metric> metrics;

    public static class Metric {
        @SerializedName("Metric")
        public String metric;
        @SerializedName("Value")
        public String value;

        public Metric(String metric, String value, String description) {
            this.metric = metric;
            this.value = value;
            this.description = description;
        }
        @SerializedName("Description")
        public String description;

    }


}