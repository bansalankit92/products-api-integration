package com.integration.extensions.domains.covidhub.model;

import com.integration.extensions.domains.covidhub.dto.NYTDataDto;
import com.integration.extensions.domains.covidhub.util.DatePlus;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

import java.util.Date;

public class NYTData {

    public String date, county, state, fips;
    long cases, deaths;


    public static NYTDataDto toCounty(NYTData[] data, Date from, Date to) {
        NYTDataDto dto = new NYTDataDto();

        long tCase = 0;
        long tDeath = 0;
        if (data.length > 0) {
            dto.county = data[0].county;
            dto.state = data[0].state;
            NYTData high = getHighest(data);
            NYTData low = getLowest(data);

            dto.totalCases = String.valueOf(high.cases);
            dto.totalDeaths = String.valueOf(high.deaths);
            dto.totalCasesDiff = String.valueOf(high.cases - low.cases);
            dto.totalDeathsDiff = String.valueOf(high.deaths - low.deaths);
            dto.dateFrom = low.date;
            dto.dateTo = high.date;
            dto.ifr = DecimalUtil.getPercentFormatted(((double) tDeath / tCase) * 100);
        }
        return dto;

    }

    public static NYTData getHighest(NYTData[] data) {
        Date date = DatePlus.fromYYYYMMDD(data[0].date);
        NYTData nytData = data[0];
        for (NYTData d : data) {
            Date dat = DatePlus.fromYYYYMMDD(d.date);
            if (!date.after(dat)) {
                date = dat;
                nytData = d;
            }
        }
        return nytData;
    }

    public static NYTData getLowest(NYTData[] data) {
        Date date = DatePlus.fromYYYYMMDD(data[0].date);
        NYTData nytData = data[0];
        for (NYTData d : data) {
            Date dat = DatePlus.fromYYYYMMDD(d.date);
            if (!date.before(dat)) {
                date = dat;
                nytData = d;
            }
        }
        return nytData;
    }

}