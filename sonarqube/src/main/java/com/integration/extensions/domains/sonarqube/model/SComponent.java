package com.integration.extensions.domains.sonarqube.model;

import com.integration.extensions.domains.sonarqube.dto.ComponentDto;
import com.integration.extensions.domains.sonarqube.util.StringPlus;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SComponent {

    public String id, key, name, description, qualifier, path, language;
    public SMeasure[] measures;


    public static class SMeasure {
        public String metric, value, bestValue;
    }

    public ComponentDto to() {
        ComponentDto dto = new ComponentDto();
        dto.description = description;
        dto.key = key;
        dto.language = language;
        dto.name = name;
        dto.path = path;
        dto.qualifier = qualifier;

        dto.measures = Arrays.stream(measures).map(m -> new ComponentDto.Measure(StringPlus.caps(m.metric), m.value)).collect(Collectors.toList());

        return dto;
    }
}