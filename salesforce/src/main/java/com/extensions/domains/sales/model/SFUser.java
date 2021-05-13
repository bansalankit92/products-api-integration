package com.extensions.domains.sales.model;

import com.extensions.domains.sales.User;

public class SFUser {

    public String Id;
    public String Username;
    public String LastName;
    public String FirstName;
    public String Name;
    public String CompanyName;
    public String Email;
    public String MobilePhone;
    public String Alias;
    public String CommunityNickname;

    public static User to(SFUser sfUser) {
        User user = new User();
        user.companyName = sfUser.CompanyName;
        user.mobileNumber = sfUser.MobilePhone;
        user.email = sfUser.Email;
        user.userName = sfUser.Username;
        user.alias = sfUser.Alias;
        user.firstName = sfUser.FirstName;
        user.id = sfUser.Id;
        user.lastName = sfUser.LastName;
        user.name = sfUser.Name;
        user.communityNickname = sfUser.CommunityNickname;

        return user;
    }

    public static SFUser from(User sfUser) {
        SFUser user = new SFUser();
        user.CompanyName = sfUser.companyName;
        user.MobilePhone = sfUser.mobileNumber;
        user.Email = sfUser.email;
        user.Username = sfUser.userName;
        user.Alias = sfUser.alias;
        user.FirstName = sfUser.firstName;
        user.Id = sfUser.id;
        user.LastName = sfUser.lastName;
        user.Name = sfUser.name;
        user.CommunityNickname = sfUser.communityNickname;

        return user;
    }

}