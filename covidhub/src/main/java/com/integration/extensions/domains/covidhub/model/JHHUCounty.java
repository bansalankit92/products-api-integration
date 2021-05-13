package com.integration.extensions.domains.covidhub.model;

import com.integration.extensions.domains.covidhub.dto.JHHUCountyDto;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

public class JHHUCounty {
    public String country, county, province, updatedAt;
    public Stats stats;

    public static class Stats {
        public int confirmed, deaths, recovered;
    }

    public JHHUCountyDto to() {
        JHHUCountyDto dto = new JHHUCountyDto();
        dto.country = country;
        dto.county = county;
        dto.province = province;
        dto.updatedAt = updatedAt;

        dto.confirmed = String.valueOf(stats.confirmed);
        dto.deaths = String.valueOf(stats.deaths);
        dto.recovered = String.valueOf(stats.recovered);

        dto.ifr = DecimalUtil.getPercentFormatted(((double) stats.deaths / stats.confirmed) * 100);
        dto.cfr = DecimalUtil.getPercentFormatted(((double) stats.deaths / (stats.deaths + stats.recovered)) * 100);

        return dto;
    }

}