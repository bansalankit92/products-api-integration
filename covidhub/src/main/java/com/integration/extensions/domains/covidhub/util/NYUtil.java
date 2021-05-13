package com.integration.extensions.domains.covidhub.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.covidhub.dto.NYTDataDto;
import com.integration.extensions.domains.covidhub.model.NYTData;
import com.integration.util.RestClient;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NYUtil {

    public static final String NYDATA = "NYT";

    public static NYTDataDto getHistoricalByCounty(RestClient r, List<String> county, Date from, Date to) {
        Map<String, String> qp = new HashMap<>();
        qp.put("lastdays", String.valueOf(DatePlus.getDateDiffFromToday(from)+1));
        String res = r.get("/nyt/counties/" + String.join(",", county), qp);
        NYTDataDto dto = NYTData.toCounty(new Gson().fromJson(res, NYTData[].class), from, to);
        dto.source = NYDATA;
        return dto;
    }

    public static NYTDataDto getHistoricalByState(RestClient r, List<String> states, Date from, Date to) {
        Map<String, String> qp = new HashMap<>();
        qp.put("lastdays", String.valueOf(DatePlus.getDateDiffFromToday(from)+1));
        String res = r.get("/nyt/states/" + String.join(",", states), qp);
        NYTDataDto dto = NYTData.toCounty(new Gson().fromJson(res, NYTData[].class), from, to);
        dto.source = NYDATA;
        return dto;
    }

}