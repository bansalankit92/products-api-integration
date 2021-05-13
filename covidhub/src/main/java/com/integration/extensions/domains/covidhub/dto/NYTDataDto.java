package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

public class NYTDataDto {
    @SerializedName("County")
    public String county;
    @SerializedName("State")
    public String state;
    @SerializedName("Total Cases")
    public String totalCases;
    @SerializedName("Total Deaths")
    public String totalDeaths;

    @SerializedName("Cases Difference")
    public String totalCasesDiff;
    @SerializedName("Deaths Difference")
    public String totalDeathsDiff;
    @SerializedName("Date From")
    public String dateFrom;
    @SerializedName("Date To")
    public String dateTo;
    @SerializedName("IFR")
    public String ifr;
    @SerializedName("Source")
    public String source;

}