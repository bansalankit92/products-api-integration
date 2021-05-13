package com.integration.extensions.domains.covidhub.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.covidhub.dto.InPatientBedOccupiedDto;
import com.integration.extensions.domains.covidhub.model.InPatientBedOccupied;
import com.integration.util.RestClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CovidHubApiUtil {

    public static List<InPatientBedOccupiedDto> getAllInPatientBedOccupied(RestClient restClient) {
        String res = restClient.get("/", new HashMap<>());
        return Arrays.stream(new Gson().fromJson(res, InPatientBedOccupied[].class)).map(InPatientBedOccupied::to).collect(Collectors.toList());
    }

    public static List<InPatientBedOccupiedDto> getAllInPatientBedOccupied(RestClient restClient, String state) {
        return getAllInPatientBedOccupied(restClient).stream().filter(x -> x.state.toLowerCase().contains(state.toLowerCase())).collect(Collectors.toList());
    }
}