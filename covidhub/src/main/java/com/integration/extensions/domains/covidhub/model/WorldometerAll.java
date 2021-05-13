package com.integration.extensions.domains.covidhub.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.covidhub.dto.WorldoMeterAllDto;
import com.integration.extensions.domains.covidhub.util.DecimalUtil;

import java.util.Date;

public class WorldometerAll {
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
    public long casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    public Double deathsPerOneMillion;
    @SerializedName("tests")
    public long tests;
    @SerializedName("testsPerOneMillion")
    public Double testsPerOneMillion;
    @SerializedName("population")
    public long population;
    @SerializedName("oneCasePerPeople")
    public long oneCasePerPeople;
    @SerializedName("oneDeathPerPeople")
    public long oneDeathPerPeople;
    @SerializedName("oneTestPerPeople")
    public long oneTestPerPeople;
    @SerializedName("activePerOneMillion")
    public Double activePerOneMillion;
    @SerializedName("recoveredPerOneMillion")
    public Double recoveredPerOneMillion;
    @SerializedName("criticalPerOneMillion")
    public Double criticalPerOneMillion;
    @SerializedName("affectedCountries")
    public long affectedCountries;

    public WorldoMeterAllDto to() {
        WorldoMeterAllDto w = new WorldoMeterAllDto();
        w.updated = new Date(updated).toString();
        w.cases = String.valueOf(cases);
        w.todayCases = String.valueOf(todayCases);
        w.deaths = String.valueOf(deaths);
        w.todayDeaths = String.valueOf(todayDeaths);
        w.recovered = String.valueOf(recovered);
        w.todayRecovered = String.valueOf(todayRecovered);
        w.active = String.valueOf(active);
        w.critical = String.valueOf(critical);
        w.casesPerOneMillion = String.valueOf(casesPerOneMillion);
        w.deathsPerOneMillion = deathsPerOneMillion;
        w.tests = String.valueOf(tests);
        w.testsPerOneMillion = testsPerOneMillion;
        w.population = String.valueOf(population);
        w.oneCasePerPeople = String.valueOf(oneCasePerPeople);
        w.oneDeathPerPeople = String.valueOf(oneDeathPerPeople);
        w.oneTestPerPeople = String.valueOf(oneTestPerPeople);
        w.activePerOneMillion = activePerOneMillion;
        w.recoveredPerOneMillion = recoveredPerOneMillion;
        w.criticalPerOneMillion = criticalPerOneMillion;
        w.affectedCountries = String.valueOf(affectedCountries);
        w.ifr = DecimalUtil.getPercentFormatted(((double) deaths / cases) * 100);
        w.cfr = DecimalUtil.getPercentFormatted(((double) deaths / (deaths + recovered)) * 100);

        w.todayIfr = DecimalUtil.getPercentFormatted(((double) todayDeaths / todayCases) * 100);
        w.todayCfr = DecimalUtil.getPercentFormatted(((double) todayDeaths / (todayDeaths + todayRecovered)) * 100);

        w.ptr =   DecimalUtil.getPercentFormatted(( casesPerOneMillion / testsPerOneMillion) * 100);

        return w;
    }
}