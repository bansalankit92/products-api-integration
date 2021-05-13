package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class WorldometerCountryDto {


    @SerializedName("Updated")
    public String updated;
    @SerializedName("Country")
    public String country;
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
    public double casesPerOneMillion;
    @SerializedName("Deaths Per One Million")
    public double deathsPerOneMillion;
    @SerializedName("Tests")
    public String tests;
    @SerializedName("Tests Per One Million")
    public String testsPerOneMillion;
    @SerializedName("Population")
    public String population;
    @SerializedName("Continent")
    public String continent;
    @SerializedName("One Case Per People")
    public String oneCasePerPeople;
    @SerializedName("One Death Per People")
    public String oneDeathPerPeople;
    @SerializedName("One Test Per People")
    public String oneTestPerPeople;
    @SerializedName("Active Per One Million")
    public Double activePerOneMillion;
    @SerializedName("Recovered Per One Million")
    public double recoveredPerOneMillion;
    @SerializedName("Critical Per One Million")
    public double criticalPerOneMillion;

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

    public String getCountry() {
        return country;
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

    public long getTodayRecovered() {
        return Long.parseLong(todayRecovered);
    }

    public long getCritical() {
        return Long.parseLong(critical);
    }

    public double getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public double getDeathsPerOneMillion() {
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

    public String getContinent() {
        return continent;
    }

    public String getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public String getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public String getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public Double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public Double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public double getCriticalPerOneMillion() {
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

    public static Comparator<WorldometerCountryDto> getKey(String key) {
        switch (key) {
            case "Total Cases":
                return Comparator.comparingLong(WorldometerCountryDto::getCases);
            case "Today Cases":
                return Comparator.comparingLong(WorldometerCountryDto::getTodayCases);
            case "Total Deaths":
                return Comparator.comparingLong(WorldometerCountryDto::getDeaths);
            case "Today Deaths":
                return Comparator.comparingLong(WorldometerCountryDto::getTodayDeaths);
            case "Recovered":
                return Comparator.comparingLong(WorldometerCountryDto::getRecovered);
            case "Today Recovered":
                return Comparator.comparingLong(WorldometerCountryDto::getTodayRecovered);

            case "Critical":
                return Comparator.comparingLong(WorldometerCountryDto::getCritical);

            case "Active":
                return Comparator.comparingLong(WorldometerCountryDto::getActive);

            default:
                return Comparator.comparingLong(WorldometerCountryDto::getTodayCases);
        }

    }
}