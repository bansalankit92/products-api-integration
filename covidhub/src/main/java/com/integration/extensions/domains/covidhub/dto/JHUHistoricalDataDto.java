package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

public class JHUHistoricalDataDto {
    @SerializedName("Country")
    public String country;
    @SerializedName("County")
    public String county;
    @SerializedName("Province")
    public String province;
    @SerializedName("Total Cases")
    public String totalCases;
    @SerializedName("Total Deaths")
    public String totalDeaths;
    @SerializedName("Total Recovered")
    public String totalRecovered;

    @SerializedName("Total Cases In Given Range")
    public String casesDiff;
    @SerializedName("Total Deaths In Given Range")
    public String deathsDiff;
    @SerializedName("Total Recovered In Given Range")
    public String recoveredDiff;

    @SerializedName("Date From")
    public String dateFrom;
    @SerializedName("Date To")
    public String dateTo;
    @SerializedName("IFR")
    public String ifr;
    @SerializedName("CFR")
    public String cfr;
    @SerializedName("Source")
    public String source;

}