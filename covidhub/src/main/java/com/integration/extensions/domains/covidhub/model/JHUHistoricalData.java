package com.integration.extensions.domains.covidhub.model;

import java.util.Date;
import java.util.Map;
import com.integration.extensions.domains.covidhub.dto.JHUHistoricalDataDto;
import com.integration.extensions.domains.covidhub.util.DatePlus;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

public class JHUHistoricalData {

    public String country, province, county;
    public Timeline timeline;

    public static class Timeline {

        public Map<String, Long> cases;
        public Map<String, Long> deaths;
        public Map<String, Long> recovered;

    }

    public JHUHistoricalDataDto to(Date from, Date to) {
        JHUHistoricalDataDto dto = new JHUHistoricalDataDto();
        dto.country = country;
        dto.province = province;
        dto.county = county;
        long tCase = 0, tDeath = 0, tRecovered = 0;
        if (timeline != null) {
            Pair<String, Long> highestPair = getTimelineHighestPair(from, to, timeline.cases);
            Pair<String, Long> lowestPair = getTimelineLowestPair(from, to, timeline.cases);

            tCase = highestPair.getValue();
            tDeath = timeline.deaths.get(highestPair.getKey());
            tRecovered = timeline.recovered != null ? timeline.recovered.get(highestPair.getKey()) : 0;

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
//
//    public static JHUHistoricalDataDto toState(JHUHistoricalData[] data, Date from, Date to) {
//        JHUHistoricalDataDto dto = new JHUHistoricalDataDto();
//        //dto.country = country;
//        //dto.province = province;
//
//        long tCase = 0, tDeath = 0, tRecovered = 0;
//        long lCase = 0, lDeath = 0, lRecovered = 0;
//        for (JHUHistoricalData d : data) {
//            if (d.timeline != null) {
//                Pair<String, Long> highestPair = getTimelineHighestPair(from, to, d.timeline.cases);
//                Pair<String, Long> lowestPair = getTimelineLowestPair(from, to, d.timeline.cases);
//
//                tCase += highestPair.getValue();
//                tDeath += d.timeline.deaths.get(highestPair.getKey());
//                tRecovered += d.timeline.recovered != null ? d.timeline.recovered.get(highestPair.getKey()) : 0;
//
//                dto.totalCases = String.valueOf(tCase);
//                dto.totalDeaths = String.valueOf(tDeath);
//                dto.totalRecovered = d.timeline.recovered != null ? String.valueOf(tRecovered) : null;
//
//
//                dto.casesDiff = String.valueOf(tCase - lowestPair.getValue());
//                dto.deathsDiff = String.valueOf(tDeath - d.timeline.deaths.get(lowestPair.getKey()));
//                dto.recoveredDiff = d.timeline.recovered != null ? String.valueOf(tRecovered - d.timeline.recovered.get(lowestPair.getKey())) : null;
//
//
//                dto.dateFrom = DatePlus.fromMDYY(lowestPair.getKey()).toString();
//                dto.dateTo = DatePlus.fromMDYY(highestPair.getKey()).toString();
//            }
//        }
//
//        dto.ifr = DecimalUtil.getFormatted(((double) tDeath / tCase) * 100);
//        dto.cfr = DecimalUtil.getFormatted(((double) tDeath / (tDeath + tRecovered)) * 100);
//        return dto;
//
//    }
//
//    public static JHUHistoricalDataDto toCounty(JHUHistoricalData[] data, String county, Date from, Date to) {
//        JHUHistoricalDataDto dto = new JHUHistoricalDataDto();
//        //dto.country = country;
//        //dto.province = province;
//
//        long tCase = 0, tDeath = 0, tRecovered = 0;
//        for (JHUHistoricalData d : data) {
//            if (d.county.equalsIgnoreCase(county)) {
//                dto.province = d.province;
//                if (d.timeline != null) {
//
//                    Pair<String, Long> highestPair = getTimelineHighestPair(from, to, d.timeline.cases);
//                    Pair<String, Long> lowestPair = getTimelineLowestPair(from, to, d.timeline.cases);
//
//                    System.out.println(highestPair);
//                    System.out.println(lowestPair);
//
//                    tCase += highestPair.getValue();
//                    tDeath += d.timeline.deaths.get(highestPair.getKey());
//                    tRecovered += d.timeline.recovered != null ? d.timeline.recovered.get(highestPair.getKey()) : 0;
//
//                    dto.totalCases = String.valueOf(tCase);
//                    dto.totalDeaths = String.valueOf(tDeath);
//                    dto.totalRecovered = d.timeline.recovered != null ? String.valueOf(tRecovered) : null;
//
//                    dto.casesDiff = String.valueOf(tCase - lowestPair.getValue());
//                    dto.deathsDiff = String.valueOf(tDeath - d.timeline.deaths.get(lowestPair.getKey()));
//                    dto.recoveredDiff = d.timeline.recovered != null ? String.valueOf(tRecovered - d.timeline.recovered.get(lowestPair.getKey())) : null;
//                    dto.dateFrom = DatePlus.fromMDYY(lowestPair.getKey()).toString();
//                    dto.dateTo = DatePlus.fromMDYY(highestPair.getKey()).toString();
//                }
//
//                dto.ifr = DecimalUtil.getFormatted(((double) tDeath / tCase) * 100);
//                dto.cfr = DecimalUtil.getFormatted(((double) tDeath / (tDeath + tRecovered)) * 100);
//            }
//        }
//        return dto;
//
//    }

    public static Pair<String, Long> getTimelineHighestPair(Date from, Date to, Map<String, Long> deaths) {
        long tDeath = -1;
        Pair<String, Long> p = new Pair<>(null, 0l);
        if (deaths != null) {
            for (Map.Entry<String, Long> c : deaths.entrySet()) {
                Date d = DatePlus.fromMDYY(c.getKey());
                if (!from.after(d) && !to.before(d)) {
                    if (tDeath <= c.getValue()) {
                        tDeath = c.getValue();
                        p = new Pair<String, Long>(c.getKey(), c.getValue());
                    }
                }
            }
        }
        return p;
    }

    public static Pair<String, Long> getTimelineLowestPair(Date from, Date to, Map<String, Long> deaths) {
        long tDeath = Integer.MAX_VALUE;
        Pair<String, Long> p = new Pair<>(null, 0l);
        if (deaths != null) {
            for (Map.Entry<String, Long> c : deaths.entrySet()) {
                Date d = DatePlus.fromMDYY(c.getKey());
                if (!d.before(from) && !d.after(to)) {
                    if (tDeath > c.getValue()) {
                        tDeath = c.getValue();
                        p = new Pair<>(c.getKey(), c.getValue());
                    }
                }
            }
        }
        return p;
    }

}