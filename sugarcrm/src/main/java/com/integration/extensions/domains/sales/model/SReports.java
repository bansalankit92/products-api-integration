package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;

public class SReports {
    
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("date_entered")
    public String dateEntered;
    @SerializedName("date_modified")
    public String dateModified;
    @SerializedName("modified_user_id")
    public String modifiedUserId;
    @SerializedName("modified_by_name")
    public String modifiedByName;
    @SerializedName("created_by")
    public String createdBy;
    @SerializedName("created_by_name")
    public String createdByName;
    @SerializedName("description")
    public String description;
    @SerializedName("deleted")
    public Boolean deleted;
    @SerializedName("module")
    public String module;
    @SerializedName("report_type")
    public String reportType;
    @SerializedName("content")
    public String content;
    @SerializedName("is_published")
    public Boolean isPublished;
    @SerializedName("last_run_date")
    public String lastRunDate;
    @SerializedName("report_cache_id")
    public String reportCacheId;
    @SerializedName("chart_type")
    public String chartType;
    @SerializedName("schedule_type")
    public String scheduleType;
    @SerializedName("favorite")
    public Boolean favorite;
    @SerializedName("my_favorite")
    public Boolean myFavorite;
    @SerializedName("assigned_user_id")
    public String assignedUserId;
    @SerializedName("assigned_user_name")
    public String assignedUserName;
}