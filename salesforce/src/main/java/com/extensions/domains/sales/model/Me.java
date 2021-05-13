package com.extensions.domains.sales.model;

import com.extensions.domains.sales.User;

import java.util.List;

public class Me {
    public String companyName;
    public String mobileNumber;
    public String email;
    public String username;
    public String displayName;
    public String alias;
    public String firstName;
    public String id;
    public String lastName;
    public String name;
    public String communityNickname;

    public List<PhoneNumber> phoneNumbers;

    public static class PhoneNumber {
        public String label;
        public String phoneNumber;
        public String phoneType;
    }

    public static User to(Me me) {
        User user = new User();
        user.id = me.id;
        user.name = me.name;
        user.companyName = me.companyName;
        user.email = me.email;
        user.userName = me.username;
        user.alias = me.alias;
        user.firstName = me.firstName;
        user.lastName = me.lastName;
        user.communityNickname = me.communityNickname;
        if (me.phoneNumbers != null && !me.phoneNumbers.isEmpty() && me.phoneNumbers.get(0) != null) {
            Me.PhoneNumber ph = me.phoneNumbers.get(0);
            user.mobileNumber = ph.phoneNumber;
        }

        return user;
    }

}