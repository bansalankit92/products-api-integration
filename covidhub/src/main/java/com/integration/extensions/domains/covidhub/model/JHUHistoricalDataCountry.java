package com.integration.extensions.domains.covidhub.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.integration.extensions.domains.covidhub.dto.JHUHistoricalDataDto;
import com.integration.extensions.domains.covidhub.util.DatePlus;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

import static com.integration.extensions.domains.covidhub.model.JHUHistoricalData.*;

public class JHUHistoricalDataCountry {

    public String country;
    public List<String> province;
    public Timeline timeline;

    public static class Timeline {

        public Map<String, Long> cases;
        public Map<String, Long> deaths;
        public Map<String, Long> recovered;

    }

    public JHUHistoricalDataDto to(Date from, Date to) {
        JHUHistoricalDataDto dto = new JHUHistoricalDataDto();
        dto.country = country;
        //dto.province = province;
        long tCase = 0, tDeath = 0, tRecovered = 0;
        if (timeline != null) {
            Pair<String, Long> highestPair = getTimelineHighestPair(from, to, timeline.cases);
            Pair<String, Long> lowestPair = getTimelineLowestPair(from, to, timeline.cases);
            System.out.println(highestPair);
            System.out.println(lowestPair);

            tCase += highestPair.getValue();
            tDeath += timeline.deaths.get(highestPair.getKey());
            tRecovered += timeline.recovered != null ? timeline.recovered.get(highestPair.getKey()) : 0;

            dto.totalCases = String.valueOf(tCase);
            dto.totalDeaths = String.valueOf(tDeath);
            dto.totalRecovered = timeline.recovered != null ? String.valueOf(tRecovered) : null;

            dto.casesDiff = String.valueOf(tCase - lowestPair.getValue());
            dto.deathsDiff = String.valueOf(tDeath - timeline.deaths.get(lowestPair.getKey()));
            dto.recoveredDiff = timeline.recovered != null ? String
                    .valueOf(tRecovered - timeline.recovered.get(lowestPair.getKey())) : null;
            dto.dateFrom = DatePlus.fromMDYY(lowestPair.getKey()).toString();
            dto.dateTo = DatePlus.fromMDYY(highestPair.getKey()).toString();
        }
        dto.ifr = DecimalUtil.getPercentFormatted(((double) tDeath / tCase) * 100);
        dto.cfr = DecimalUtil.getPercentFormatted(((double) tDeath / (tDeath + tRecovered)) * 100);
        return dto;

    }

}