package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

public class WorldoMeterAllDto {

    @SerializedName("Updated")
    public String updated;
    @SerializedName("Cases")
    public String cases;
    @SerializedName("Today Cases")
    public String todayCases;
    @SerializedName("Deaths")
    public String deaths;
    @SerializedName("Today Deaths")
    public String todayDeaths;
    @SerializedName("Recovered")
    public String recovered;
    @SerializedName("Today Recovered")
    public String todayRecovered;
    @SerializedName("Active")
    public String active;
    @SerializedName("Critical")
    public String critical;
    @SerializedName("Cases Per One Million")
    public String casesPerOneMillion;
    @SerializedName("Deaths Per One Million")
    public Double deathsPerOneMillion;
    @SerializedName("Tests")
    public String tests;
    @SerializedName("Tests Per One Million")
    public Double testsPerOneMillion;
    @SerializedName("Population")
    public String population;
    @SerializedName("One Case Per People")
    public String oneCasePerPeople;
    @SerializedName("One Death Per People")
    public String oneDeathPerPeople;
    @SerializedName("One Test Per People")
    public String oneTestPerPeople;
    @SerializedName("Active Per One Million")
    public Double activePerOneMillion;
    @SerializedName("Recovered Per One Million")
    public Double recoveredPerOneMillion;
    @SerializedName("Critical Per One Million")
    public Double criticalPerOneMillion;
    @SerializedName("Affected Countries")
    public String affectedCountries;
    @SerializedName("Total IFR")
    public String ifr;
    @SerializedName("Total CFR")
    public String cfr;

    @SerializedName("Today IFR")
    public String todayIfr;
    @SerializedName("Today CFR")
    public String todayCfr;

    @SerializedName("Positive Test Ratio Per One Million")
    public String ptr;
    @SerializedName("Source")
    public String source;


}