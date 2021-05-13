package com.integration.extensions.domains.covidhub.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.covidhub.dto.WorldometerStateDto;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

import java.util.Date;

public class WorldometerState {

    @SerializedName("state")
    public String state;
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
    @SerializedName("active")
    public long active;
    @SerializedName("casesPerOneMillion")
    public long casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    public long deathsPerOneMillion;
    @SerializedName("tests")
    public long tests;
    @SerializedName("testsPerOneMillion")
    public long testsPerOneMillion;
    @SerializedName("population")
    public long population;

    public WorldometerStateDto to() {
        WorldometerStateDto w = new WorldometerStateDto();
        w.updated = new Date(updated).toString();
        w.cases = String.valueOf(cases);
        w.todayCases = String.valueOf(todayCases);
        w.deaths = String.valueOf(deaths);
        w.todayDeaths = String.valueOf(todayDeaths);
        w.recovered = String.valueOf(recovered);
        w.active = String.valueOf(active);
        w.casesPerOneMillion = String.valueOf(casesPerOneMillion);
        w.tests = String.valueOf(tests);
        w.population = String.valueOf(population);
        w.deathsPerOneMillion = String.valueOf(deathsPerOneMillion);
        w.testsPerOneMillion = String.valueOf(testsPerOneMillion);

        w.ifr = DecimalUtil.getPercentFormatted(((double) deaths / cases) * 100);
        w.cfr = DecimalUtil.getPercentFormatted(((double) deaths / (deaths + recovered)) * 100);

        w.todayIfr = DecimalUtil.getPercentFormatted(((double) todayDeaths / todayCases) * 100);
        //w.todayCfr = DecimalUtil.getFormatted(((double) todayDeaths / (todayDeaths + todayRecovered)) * 100);
        w.population = String.valueOf(population);
        w.state = state;
        w.ptr = DecimalUtil.getPercentFormatted(((double) cases / tests) * 100);
        w.ptrPM = DecimalUtil.getPercentFormatted(((double) casesPerOneMillion / testsPerOneMillion) * 100);

        return w;
    }
}