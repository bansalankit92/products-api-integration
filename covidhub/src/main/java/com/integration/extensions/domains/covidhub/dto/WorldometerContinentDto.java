package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class WorldometerContinentDto {

    @SerializedName("Updated")
    public String updated;
    @SerializedName("Total Cases")
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
    public Double casesPerOneMillion;
    @SerializedName("Deaths Per One Million")
    public Double deathsPerOneMillion;
    @SerializedName("Tests")
    public String tests;
    @SerializedName("TestsPerOneMillion")
    public Double testsPerOneMillion;
    @SerializedName("Population")
    public String population;
    @SerializedName("Continent")
    public String continent;
    @SerializedName("Active Per One Million")
    public Double activePerOneMillion;
    @SerializedName("Recovered Per One Million")
    public Double recoveredPerOneMillion;
    @SerializedName("Critical Per One Million")
    public Double criticalPerOneMillion;

    @SerializedName("Total IFR")
    public String ifr;
    @SerializedName("Total CFR")
    public String cfr;

    @SerializedName("Today IFR")
    public String todayIfr;
    @SerializedName("Today CFR")
    public String todayCfr;

    @SerializedName("Positive Test Ratio")
    public String ptr;

    @SerializedName("Positive Test Ratio Per One Million")
    public String ptrPM;
    @SerializedName("Source")
    public String source;


    public String getUpdated() {
        return updated;
    }

    public long getCases() {
        return Long.parseLong(cases);
    }

    public long getTodayCases() {
        return Long.parseLong(todayCases);
    }

    public long getDeaths() {
        return Long.parseLong(deaths);
    }

    public long getTodayDeaths() {
        return Long.parseLong(todayDeaths);
    }

    public long getRecovered() {
        return Long.parseLong(recovered);
    }

    public long getTodayRecovered() {
        return Long.parseLong(todayRecovered);
    }

    public long getActive() {
        return Long.parseLong(active);
    }

    public String getCritical() {
        return critical;
    }

    public Double getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public Double getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public String getTests() {
        return tests;
    }

    public Double getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public String getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public Double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public Double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public Double getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public String getIfr() {
        return ifr;
    }

    public String getCfr() {
        return cfr;
    }

    public String getTodayIfr() {
        return todayIfr;
    }

    public String getTodayCfr() {
        return todayCfr;
    }

    public static Comparator<WorldometerContinentDto> getKey(String key) {
        switch (key) {
            case "Total Cases":
                return Comparator.comparingLong(WorldometerContinentDto::getCases);
            case "Today Cases":
                return Comparator.comparingLong(WorldometerContinentDto::getTodayCases);
            case "Total Deaths":
                return Comparator.comparingLong(WorldometerContinentDto::getDeaths);
            case "Today Deaths":
                return Comparator.comparingLong(WorldometerContinentDto::getTodayDeaths);
            case "Recovered":
                return Comparator.comparingLong(WorldometerContinentDto::getRecovered);
            case "Today Recovered":
                return Comparator.comparingLong(WorldometerContinentDto::getTodayRecovered);
            case "Active":
                return Comparator.comparingLong(WorldometerContinentDto::getActive);

            default:
                return Comparator.comparing(WorldometerContinentDto::getTodayCases);
        }

    }

}