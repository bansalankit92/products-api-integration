package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class WorldometerStateDto {

    @SerializedName("State")
    public String state;
    @SerializedName("Updated Date")
    public String updated;
    @SerializedName("Total Cases")
    public String cases;
    @SerializedName("Today Cases")
    public String todayCases;
    @SerializedName("Total Deaths")
    public String deaths;
    @SerializedName("Today Deaths")
    public String todayDeaths;
    @SerializedName("Recovered")
    public String recovered;
    @SerializedName("Active")
    public String active;
    @SerializedName("Cases Per One Million")
    public String casesPerOneMillion;
    @SerializedName("Deaths Per One Million")
    public String deathsPerOneMillion;
    @SerializedName("Tests")
    public String tests;
    @SerializedName("Tests Per One Million")
    public String testsPerOneMillion;
    @SerializedName("Population")
    public String population;

    @SerializedName("Source")
    public String source;


    @SerializedName("Total IFR")
    public String ifr;
    @SerializedName("Total CFR")
    public String cfr;

    @SerializedName("Today IFR")
    public String todayIfr;
//     @SerializedName("Today CFR")
//     public String todayCfr;

    @SerializedName("Positive Test Ratio")
    public String ptr;

    @SerializedName("Positive Test Ratio Per One Million")
    public String ptrPM;


    public String getState() {
        return state;
    }

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

    public long getActive() {
        return Long.parseLong(active);
    }

    public String getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public String getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public String getTests() {
        return tests;
    }

    public String getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public String getPopulation() {
        return population;
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

    public static Comparator<WorldometerStateDto> getKey(String key) {
        switch (key) {
            case "State":
                return Comparator.comparing(WorldometerStateDto::getState);
            case "Total Cases":
                return Comparator.comparingLong(WorldometerStateDto::getCases);
            case "Today Cases":
                return Comparator.comparingLong(WorldometerStateDto::getTodayCases);
            case "Total Deaths":
                return Comparator.comparingLong(WorldometerStateDto::getDeaths);
            case "Today Deaths":
                return Comparator.comparingLong(WorldometerStateDto::getTodayDeaths);
            case "Recovered":
                return Comparator.comparingLong(WorldometerStateDto::getRecovered);
            case "Active":
                return Comparator.comparingLong(WorldometerStateDto::getActive);

            default:
                throw new RuntimeException("Cant get data by "+ key);
        }

    }
}