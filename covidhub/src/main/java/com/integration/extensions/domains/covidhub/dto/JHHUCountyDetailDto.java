package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

public class JHHUCountyDetailDto {
    @SerializedName("Country")
    public String country;
    @SerializedName("County")
    public String county;
    @SerializedName("Province")
    public String province;
    @SerializedName("Updated At")
    public String updatedAt;
    @SerializedName("Confirmed")
    public int confirmed;
    @SerializedName("Deaths")
    public int deaths;
    @SerializedName("Recovered")
    public int recovered;

    @SerializedName("Today Confirmed")
    public int todayConfirmed;
    @SerializedName("Today Deaths")
    public int todayDeaths;
    @SerializedName("Today Recovered")
    public int todayRecovered;

    @SerializedName("Infection Fatality Ratio")
    public String ifr;
    @SerializedName("Case Fatality Ratio")
    public String cfr;

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

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public String getIfr() {
        return ifr;
    }

    public String getCfr() {
        return cfr;
    }

    public int getTodayConfirmed() {
        return todayConfirmed;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public int getTodayRecovered() {
        return todayRecovered;
    }


}