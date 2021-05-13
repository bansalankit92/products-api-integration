package com.integration.extensions.domains.covidhub.dto;

import com.google.gson.annotations.SerializedName;

public class InPatientBedOccupiedDto {

    @SerializedName("State Code")
    public String state;
    @SerializedName("Collection Date")
    public String collectionDate;
    @SerializedName("ICU Beds Occupied Estimated")
    public String iCUBedsOccupiedEstimated;
    @SerializedName("Count LL")
    public String countLL;
    @SerializedName("Count UL")
    public String countUL;
    @SerializedName("Percentage of ICU Beds Occupied Estimated")
    public Double percentageOfICUBedsOccupiedEstimated;
    @SerializedName("Percentage LL")
    public Double percentageLL;
    @SerializedName("Percentage UL")
    public Double percentageUL;
    @SerializedName("Total ICU Beds")
    public String totalICUBeds;
    @SerializedName("Total LL")
    public String totalLL;
    @SerializedName("Total UL")
    public String totalUL;
    @SerializedName("Source")
    public String source;

}