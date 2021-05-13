package com.integration.extensions.domains.covidhub.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.covidhub.dto.InPatientBedOccupiedDto;

public class InPatientBedOccupied {

    @SerializedName("state")
    public String state;
    @SerializedName("collection_date")
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

    public InPatientBedOccupiedDto to() {
        InPatientBedOccupiedDto dto = new InPatientBedOccupiedDto();
        dto.state = state;
        dto.collectionDate = collectionDate;
        dto.countLL = countLL;
        dto.countUL = countUL;
        dto.iCUBedsOccupiedEstimated = iCUBedsOccupiedEstimated;
        dto.percentageOfICUBedsOccupiedEstimated = percentageOfICUBedsOccupiedEstimated;
        dto.percentageLL = percentageLL;
        dto.percentageUL = percentageUL;
        dto.totalICUBeds = totalICUBeds;
        dto.totalLL = totalLL;
        dto.totalUL = totalUL;
        return dto;
    }
}