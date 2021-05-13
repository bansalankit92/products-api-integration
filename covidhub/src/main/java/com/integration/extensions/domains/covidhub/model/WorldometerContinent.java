package com.integration.extensions.domains.covidhub.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.covidhub.dto.WorldometerContinentDto;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

import java.util.Date;

public class WorldometerContinent {

    @SerializedName("updated")
    public long updated;
    @SerializedName("cases")
    public long cases;
    @SerializedName("todayCases")
    public long todayCases;
    @SerializedName("deaths")
    public long deaths;
    @SerializedName("todayDeaths")
    public long todayDeaths;
    @SerializedName("recovered")
    public long recovered;
    @SerializedName("todayRecovered")
    public long todayRecovered;
    @SerializedName("active")
    public long active;
    @SerializedName("critical")
    public long critical;
    @SerializedName("casesPerOneMillion")
    public Double casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    public Double deathsPerOneMillion;
    @SerializedName("tests")
    public long tests;
    @SerializedName("testsPerOneMillion")
    public Double testsPerOneMillion;
    @SerializedName("population")
    public long population;
    @SerializedName("continent")
    public String continent;
    @SerializedName("activePerOneMillion")
    public Double activePerOneMillion;
    @SerializedName("recoveredPerOneMillion")
    public Double recoveredPerOneMillion;
    @SerializedName("criticalPerOneMillion")
    public Double criticalPerOneMillion;

    public WorldometerContinentDto to() {
        WorldometerContinentDto w = new WorldometerContinentDto();
        w.updated = new Date(updated).toString();
        w.cases = String.valueOf(cases);
        w.todayCases = String.valueOf(todayCases);
        w.deaths = String.valueOf(deaths);
        w.todayDeaths = String.valueOf(todayDeaths);
        w.recovered = String.valueOf(recovered);
        w.active = String.valueOf(active);
        w.casesPerOneMillion = casesPerOneMillion;
        w.tests = String.valueOf(tests);
        w.population = String.valueOf(population);
        w.deathsPerOneMillion = deathsPerOneMillion;
        w.testsPerOneMillion = testsPerOneMillion;
        w.activePerOneMillion = activePerOneMillion;
        w.recoveredPerOneMillion = recoveredPerOneMillion;
        w.criticalPerOneMillion = criticalPerOneMillion;
        w.critical = String.valueOf(critical);
        w.todayRecovered = String.valueOf(todayRecovered);
        w.ifr = DecimalUtil.getPercentFormatted(((double) deaths / cases) * 100);
        w.cfr = DecimalUtil.getPercentFormatted(((double) deaths / (deaths + recovered)) * 100);
        w.todayIfr = DecimalUtil.getPercentFormatted(((double) todayDeaths / todayCases) * 100);
        w.todayCfr = DecimalUtil.getPercentFormatted(((double) todayDeaths / (todayDeaths + todayRecovered)) * 100);
        w.population = String.valueOf(population);
        w.continent = continent;
        w.ptr = DecimalUtil.getPercentFormatted(((double) cases / tests) * 100);
        w.ptrPM = DecimalUtil.getPercentFormatted(( casesPerOneMillion / testsPerOneMillion) * 100);

        return w;
    }
}