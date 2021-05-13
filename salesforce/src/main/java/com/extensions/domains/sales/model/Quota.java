package com.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;

public class Quota {
    @SerializedName("Owner Name")
    public String ownerName;
    @SerializedName("Quota Amount")
    public long quotaAmount;

    public Quota(String ownerName, long quotaAmount) {
        this.ownerName = ownerName;
        this.quotaAmount = quotaAmount;
    }

    public static class SFQuota {
        public QuotaOwner QuotaOwner;
        public Double QuotaAmount ;

        public Quota to(){
            return new Quota(QuotaOwner.Name,Math.round(QuotaAmount));
        }
    }


    public static class QuotaOwner {
        public String Name;
    }

}