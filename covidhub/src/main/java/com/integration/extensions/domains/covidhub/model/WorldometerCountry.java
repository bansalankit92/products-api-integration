package com.integration.extensions.domains.covidhub.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.covidhub.dto.WorldometerCountryDto;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

import java.util.Date;

public class WorldometerCountry {


    @SerializedName("updated")
    public long updated;
    @SerializedName("country")
    public String country;
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
    public double casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    public double deathsPerOneMillion;
    @SerializedName("tests")
    public long tests;
    @SerializedName("testsPerOneMillion")
    public long testsPerOneMillion;
    @SerializedName("population")
    public long population;
    @SerializedName("continent")
    public String continent;
    @SerializedName("oneCasePerPeople")
    public long oneCasePerPeople;
    @SerializedName("oneDeathPerPeople")
    public long oneDeathPerPeople;
    @SerializedName("oneTestPerPeople")
    public long oneTestPerPeople;
    @SerializedName("activePerOneMillion")
    public double activePerOneMillion;
    @SerializedName("recoveredPerOneMillion")
    public double recoveredPerOneMillion;
    @SerializedName("criticalPerOneMillion")
    public double criticalPerOneMillion;

    public WorldometerCountryDto to() {
        WorldometerCountryDto w = new WorldometerCountryDto();
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
        w.activePerOneMillion = activePerOneMillion;
        w.testsPerOneMillion = String.valueOf(testsPerOneMillion);
        w.oneCasePerPeople = String.valueOf(oneCasePerPeople);
        w.oneDeathPerPeople = String.valueOf(oneDeathPerPeople);
        w.oneTestPerPeople = String.valueOf(oneTestPerPeople);
        w.activePerOneMillion = activePerOneMillion;
        w.recoveredPerOneMillion = recoveredPerOneMillion;
        w.criticalPerOneMillion = criticalPerOneMillion;
        w.todayRecovered = String.valueOf(todayRecovered);
        w.critical = String.valueOf(critical);
        w.ifr = DecimalUtil.getPercentFormatted(((double) deaths / cases) * 100);
        w.cfr = DecimalUtil.getPercentFormatted(((double) deaths / (deaths + recovered)) * 100);

        w.todayIfr = DecimalUtil.getPercentFormatted(((double) todayDeaths / todayCases) * 100);
        w.todayCfr = DecimalUtil.getPercentFormatted(((double) todayDeaths / (todayDeaths + todayRecovered)) * 100);

        w.ptr = DecimalUtil.getPercentFormatted(((double) cases / tests) * 100);
        w.ptrPM = DecimalUtil.getPercentFormatted((casesPerOneMillion / testsPerOneMillion) * 100);

        w.population = String.valueOf(population);
        w.country = country;
        w.continent = continent;
        return w;
    }
}