package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sales.User;

public class Me {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("timepref")
    @Expose
    public String timepref;
    @SerializedName("timezone")
    @Expose
    public String timezone;
    @SerializedName("user_name")
    @Expose
    public String userName;

    public static class CurrentUser {
        @SerializedName("current_user")
        @Expose
        public Me currentUser;
    }

    public User to(){
        User user = new User();
        user.userName = userName;
      //  user.alias = sfUser.title;
       // user.firstName = sfUser.firstName;
        user.id = id;
     //   user.lastName = sfUser.lastName;
        user.name = fullName;
       // user.communityNickname = sfUser.fullName;

        return user;
    }
}