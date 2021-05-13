package com.integration.extensions.domains.sonarqube.model;

import com.integration.extensions.domains.sonarqube.dto.MetricsDto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SMetrics {
    public SComponent component;
    public MetricDetail[] metrics;

    public static class MetricDetail {
        public String name, key, description;
    }

    public MetricsDto to() {
        MetricsDto dto = new MetricsDto();
        dto.key = component.key;
        dto.Description = component.description;
        dto.name = component.name;
        Map<String, MetricDetail> metricDetailMap = Arrays.stream(metrics).collect(Collectors.toMap(m -> m.key, x -> x));
        dto.metrics = Arrays.stream(component.measures).map(x -> new MetricsDto.Metric(metricDetailMap.get(x.metric).name, x.value, metricDetailMap.get(x.metric).description)).collect(Collectors.toList());
        return dto;
    }

}