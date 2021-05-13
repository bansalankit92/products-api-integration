package com.integration.extensions.domains.covidhub.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.covidhub.County;
import com.integration.extensions.domains.covidhub.dto.JHHUCountyDto;
import com.integration.extensions.domains.covidhub.dto.JHUHistoricalDataDto;
import com.integration.extensions.domains.covidhub.model.JHHUCounty;
import com.integration.extensions.domains.covidhub.model.JHUHistoricalDataCountry;
import com.integration.extensions.domains.covidhub.model.RawCounty;
import com.integration.util.RestClient;

import java.util.*;
import java.util.stream.Collectors;

public class JHUUtil {

    public static final String JHUCSSE = "JHUCSSE";

    public static List<County> getCounties() {
        return Arrays.stream(RawCounty.counties).map(RawCounty::to).collect(Collectors.toList());
    }

    public static Set<String> getProvinces() {
        return Arrays.stream(RawCounty.counties).map(x -> x.province).collect(Collectors.toSet());
    }


    public static List<JHHUCountyDto> getAllCounties(RestClient r) {
        Map<String, String> qp = new HashMap<>();
        String res = r.get("/jhucsse/counties", qp);
        return Arrays.stream(new Gson().fromJson(res, JHHUCounty[].class)).map(JHHUCounty::to).collect(Collectors.toList());
    }


    public static JHHUCountyDto getCountiesByName(RestClient r, String countyName) {
        Map<String, String> qp = new HashMap<>();
        String res = r.get("/jhucsse/counties/" + countyName, qp);
        JHHUCountyDto dto = new Gson().fromJson(res, JHHUCounty.class).to();
        dto.source = JHUCSSE;
        return dto;
    }

    public static JHUHistoricalDataDto getHistoricalByCountries(RestClient r, List<String> countries, Date from, Date to) {
        Map<String, String> qp = new HashMap<>();
        System.out.println(DatePlus.getDateDiffFromToday(from));
        qp.put("lastdays", String.valueOf(DatePlus.getDateDiffFromToday(from)+1));
        String res = r.get("/historical/" + String.join(",", countries), qp);
        JHUHistoricalDataDto dto = new Gson().fromJson(res, JHUHistoricalDataCountry.class).to(from, to);
        dto.source = JHUCSSE;
        return dto;
    }

//    public static JHUHistoricalDataDto getHistoricalByState(RestClient r, String state, Date from, Date to) {
//        Map<String, String> qp = new HashMap<>();
//        qp.put("lastdays", String.valueOf(DatePlus.getDateDiffFromToday(from)+1));
//        String res = r.get("/historical/usacounties/" + state.toLowerCase(), qp);
//        JHUHistoricalDataDto dto = JHUHistoricalData.toState(new Gson().fromJson(res, JHUHistoricalData[].class), from, to);
//        dto.source = JHUCSSE;
//        return dto;
//    }
//
//    public static JHUHistoricalDataDto getHistoricalByCounty(RestClient r, String state, String county, Date from, Date to) {
//        Map<String, String> qp = new HashMap<>();
//        qp.put("lastdays", String.valueOf(DatePlus.getDateDiffFromToday(from)+1));
//        String res = r.get("/historical/usacounties/" + state.toLowerCase(), qp);
//        JHUHistoricalDataDto dto = JHUHistoricalData.toCounty(new Gson().fromJson(res, JHUHistoricalData[].class), county, from, to);
//        dto.source = JHUCSSE;
//        return dto;
//    }

}