package com.integration.extensions.domains.sonarqube.model;

import com.integration.extensions.domains.sonarqube.dto.MeasuresDto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SMeasures {
    public SPaging paging;
    public SComponent baseComponent;
    public SComponent[] components;


    public MeasuresDto to() {
        MeasuresDto dto = new MeasuresDto();
        dto.baseComponent = baseComponent.to();
        dto.components = Arrays.stream(components).map(SComponent::to).collect(Collectors.toList());
        return dto;
    }

}