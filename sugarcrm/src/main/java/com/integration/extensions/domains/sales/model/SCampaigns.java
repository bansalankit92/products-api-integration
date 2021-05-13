package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SCampaigns {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("date_entered")
    @Expose
    public String dateEntered;
    @SerializedName("date_modified")
    @Expose
    public String dateModified;
    @SerializedName("modified_user_id")
    @Expose
    public String modifiedUserId;
    @SerializedName("modified_by_name")
    @Expose
    public String modifiedByName;
    @SerializedName("created_by")
    @Expose
    public String createdBy;
    @SerializedName("created_by_name")
    @Expose
    public String createdByName;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("deleted")
    @Expose
    public Boolean deleted;
    @SerializedName("tracker_key")
    @Expose
    public Integer trackerKey;
    @SerializedName("tracker_count")
    @Expose
    public Integer trackerCount;
    @SerializedName("refer_url")
    @Expose
    public String referUrl;
    @SerializedName("tracker_text")
    @Expose
    public String trackerText;
    @SerializedName("start_date")
    @Expose
    public String startDate;
    @SerializedName("end_date")
    @Expose
    public String endDate;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("impressions")
    @Expose
    public Integer impressions;
    @SerializedName("budget")
    @Expose
    public String budget;
    @SerializedName("expected_cost")
    @Expose
    public String expectedCost;
    @SerializedName("actual_cost")
    @Expose
    public String actualCost;
    @SerializedName("expected_revenue")
    @Expose
    public String expectedRevenue;
    @SerializedName("campaign_type")
    @Expose
    public String campaignType;
    @SerializedName("objective")
    @Expose
    public String objective;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("frequency")
    @Expose
    public String frequency;
    @SerializedName("following")
    @Expose
    public Boolean following;
    @SerializedName("my_favorite")
    @Expose
    public Boolean myFavorite;
    @SerializedName("locked_fields")
    @Expose
    public List<Object> lockedFields = null;
    @SerializedName("assigned_user_id")
    @Expose
    public String assignedUserId;
    @SerializedName("assigned_user_name")
    @Expose
    public String assignedUserName;
    @SerializedName("team_count")
    @Expose
    public String teamCount;
    @SerializedName("currency_id")
    @Expose
    public String currencyId;
    @SerializedName("base_rate")
    @Expose
    public String baseRate;
    @SerializedName("currency_name")
    @Expose
    public String currencyName;
}