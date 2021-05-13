package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class JHHUCountyDto {
    @SerializedName("Country")
    public String country;
    @SerializedName("County")
    public String county;
    @SerializedName("Province")
    public String province ;
    @SerializedName("Updated At")
    public String updatedAt;
    @SerializedName("Confirmed")
    public String confirmed;
    @SerializedName("Deaths")
    public String deaths;
    @SerializedName("Recovered")
    public String recovered;

    @SerializedName("Infection Fatality Ratio")
    public String ifr;
    @SerializedName("Case Fatality Ratio")
    public String cfr;
    @SerializedName("Source")
    public String source;

    public String getCountry() {
        return country;
    }

    public String getCounty() {
        return county;
    }

    public String getProvince() {
        return province;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getIfr() {
        return ifr;
    }

    public String getCfr() {
        return cfr;
    }
    
    public static Comparator<JHHUCountyDto> getKey(String key) {
            switch (key) {
                case "Total Cases":
                    return Comparator.comparing(JHHUCountyDto::getConfirmed);
                case "Today Cases":
                    throw new RuntimeException("JHUCSSE doesn't support sorting on today cases");
                case "Total Deaths":
                    return Comparator.comparing(JHHUCountyDto::getDeaths);
                case "Today Deaths":
                    throw new RuntimeException("JHUCSSE doesn't support sorting on today Deaths");
                case "Recovered":
                    return Comparator.comparing(JHHUCountyDto::getRecovered);
                case "Today Recovered":
                    throw new RuntimeException("JHUCSSE doesn't support sorting on today Recovered");
    
                default:
                    return Comparator.comparing(JHHUCountyDto::getConfirmed);
            }
    
        }
    
}