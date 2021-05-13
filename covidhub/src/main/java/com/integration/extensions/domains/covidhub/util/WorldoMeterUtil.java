package com.integration.extensions.domains.covidhub.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.covidhub.State;
import com.integration.extensions.domains.covidhub.dto.WorldoMeterAllDto;
import com.integration.extensions.domains.covidhub.dto.WorldometerContinentDto;
import com.integration.extensions.domains.covidhub.dto.WorldometerCountryDto;
import com.integration.extensions.domains.covidhub.dto.WorldometerStateDto;
import com.integration.extensions.domains.covidhub.model.*;
import com.integration.util.RestClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorldoMeterUtil {

    public static final String WORLDOMETER = "Worldometers";


    public static WorldoMeterAllDto getAll(RestClient r, boolean yesterday, boolean twoDayAgo) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        qp.put("twoDaysAgo", String.valueOf(twoDayAgo));
        String res = r.get("/all", qp);
        WorldoMeterAllDto dto = new Gson().fromJson(res, WorldometerAll.class).to();
        dto.source = WORLDOMETER;
        return dto;
    }

    public static List<WorldometerStateDto> getAllStates(RestClient r, boolean yesterday, String sortBy) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        qp.put("sort", sortBy != null && !sortBy.isEmpty() ? sortBy : SortBy.getDefault());
        String res = r.get("/states", qp);
        return Arrays.stream(new Gson().fromJson(res, WorldometerState[].class)).map(WorldometerState::to).collect(Collectors.toList());
    }

    public static List<State> getAllStatesName(RestClient r) {
        return getAllStates(r, false, null).stream().map(x -> new State(x.state, StateCode.getCode(x.state))).collect(Collectors.toList());
    }

    public static WorldometerStateDto getStateByName(RestClient r, String stateName, boolean yesterday) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        String res = r.get("/states/" + stateName, qp);
        return new Gson().fromJson(res, WorldometerState.class).to();
    }

    public static List<WorldometerCountryDto> getAllCountries(RestClient r, boolean yesterday, boolean twoDayAgo, String sortBy) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        qp.put("sort", sortBy != null && !sortBy.isEmpty() ? sortBy : SortBy.getDefault());
        qp.put("twoDaysAgo", String.valueOf(twoDayAgo));
        String res = r.get("/countries", qp);
        return Arrays.stream(new Gson().fromJson(res, WorldometerCountry[].class)).map(WorldometerCountry::to).collect(Collectors.toList());
    }

    public static List<WorldometerCountryDto> getCountries(RestClient r, List<String> countries, boolean yesterday, boolean twoDayAgo, String sortBy) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        qp.put("sort", sortBy != null && !sortBy.isEmpty() ? sortBy : SortBy.getDefault());
        qp.put("twoDaysAgo", String.valueOf(twoDayAgo));
        qp.put("countries",String.join(",",countries));
        String res = r.get("/countries", qp);
        return Arrays.stream(new Gson().fromJson(res, WorldometerCountry[].class)).map(WorldometerCountry::to).collect(Collectors.toList());
    }

    public static WorldometerCountryDto getCountryByName(RestClient r, String countryName, boolean yesterday, boolean twoDayAgo) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        qp.put("twoDaysAgo", String.valueOf(twoDayAgo));
        String res = r.get("/countries/" + countryName, qp);
        return new Gson().fromJson(res, WorldometerCountry.class).to();
    }


    public static List<WorldometerContinentDto> getAllContinents(RestClient r, boolean yesterday, boolean twoDayAgo, String sortBy) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        qp.put("twoDaysAgo", String.valueOf(twoDayAgo));
        qp.put("sort", sortBy != null && !sortBy.isEmpty() ? sortBy : SortBy.getDefault());
        String res = r.get("/continents", qp);
        return Arrays.stream(new Gson().fromJson(res, WorldometerContinent[].class)).map(WorldometerContinent::to).collect(Collectors.toList());
    }

    public static List<String> getAllContinentsName(RestClient r) {
        return getAllContinents(r, false, false, null).stream().map(x -> x.continent).collect(Collectors.toList());
    }

    public static WorldometerContinentDto getContinentsByName(RestClient r, String stateName, boolean yesterday, boolean twoDayAgo) {
        Map<String, String> qp = new HashMap<>();
        qp.put("yesterday", String.valueOf(yesterday));
        qp.put("twoDaysAgo", String.valueOf(twoDayAgo));
        String res = r.get("/continents/" + stateName, qp);
        return new Gson().fromJson(res, WorldometerContinent.class).to();
    }

}