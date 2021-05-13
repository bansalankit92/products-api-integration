package com.integration.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.integration.extensions.domains.sales.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SUsers {

    public static class Email {

        @SerializedName("email_address")
        public String emailAddress;
        @SerializedName("primary_address")
        public Boolean primaryAddress;
        @SerializedName("reply_to_address")
        public Boolean replyToAddress;
        @SerializedName("invalid_email")
        public Boolean invalidEmail;
        @SerializedName("opt_out")
        public Boolean optOut;
        @SerializedName("email_address_id")
        public String emailAddressId;
    }

    @SerializedName("id")
    public String id;
    @SerializedName("user_name")
    public String userName;
    @SerializedName("user_hash")
    public Boolean userHash;
    @SerializedName("system_generated_password")
    public Boolean systemGeneratedPassword;
    @SerializedName("pwd_last_changed")
    public String pwdLastChanged;
    @SerializedName("authenticate_id")
    public String authenticateId;
    @SerializedName("sugar_login")
    public Boolean sugarLogin;
    @SerializedName("picture")
    public String picture;
    @SerializedName("first_name")
    public String firstName;
    @SerializedName("last_name")
    public String lastName;
    @SerializedName("full_name")
    public String fullName;
    @SerializedName("name")
    public String name;
    @SerializedName("is_admin")
    public Boolean isAdmin;
    @SerializedName("external_auth_only")
    public Boolean externalAuthOnly;
    @SerializedName("receive_notifications")
    public Boolean receiveNotifications;
    @SerializedName("send_email_on_mention")
    public Boolean sendEmailOnMention;
    @SerializedName("description")
    public String description;
    @SerializedName("date_entered")
    public String dateEntered;
    @SerializedName("date_modified")
    public String dateModified;
    @SerializedName("last_login")
    public String lastLogin;
    @SerializedName("modified_user_id")
    public String modifiedUserId;
    @SerializedName("modified_by_name")
    public String modifiedByName;
    @SerializedName("created_by")
    public String createdBy;
    @SerializedName("created_by_name")
    public String createdByName;
    @SerializedName("title")
    public String title;
    @SerializedName("department")
    public String department;
    @SerializedName("phone_home")
    public String phoneHome;
    @SerializedName("phone_mobile")
    public String phoneMobile;
    @SerializedName("phone_work")
    public String phoneWork;
    @SerializedName("phone_other")
    public String phoneOther;
    @SerializedName("phone_fax")
    public String phoneFax;
    @SerializedName("status")
    public String status;
    @SerializedName("address_street")
    public String addressStreet;
    @SerializedName("address_city")
    public String addressCity;
    @SerializedName("address_state")
    public String addressState;
    @SerializedName("address_country")
    public String addressCountry;
    @SerializedName("address_postalcode")
    public String addressPostalcode;
    @SerializedName("UserType")
    public String userType;
    @SerializedName("default_team")
    public String defaultTeam;
    @SerializedName("team_count")
    public String teamCount;
    @SerializedName("email")
    public List<Email> email = null;
    @SerializedName("deleted")
    public Boolean deleted;
    @SerializedName("portal_only")
    public Boolean portalOnly;
    @SerializedName("show_on_employees")
    public Boolean showOnEmployees;
    @SerializedName("employee_status")
    public String employeeStatus;
    @SerializedName("messenger_id")
    public String messengerId;
    @SerializedName("messenger_type")
    public String messengerType;
    @SerializedName("reports_to_id")
    public String reportsToId;
    @SerializedName("reports_to_name")
    public String reportsToName;
    @SerializedName("preferred_language")
    public String preferredLanguage;
    @SerializedName("acl_role_set_id")
    public String aclRoleSetId;
    @SerializedName("site_user_id")
    public String siteUserId;
    @SerializedName("cookie_consent")
    public Boolean cookieConsent;
    @SerializedName("cookie_consent_received_on")
    public String cookieConsentReceivedOn;
    @SerializedName("customer_journey_access")
    public Boolean customerJourneyAccess;
    @SerializedName("customer_journey_last_active")
    public String customerJourneyLastActive;


    public static User to(SUsers sfUser) {
        User user = new User();
        //user.companyName = sfUser;
        user.mobileNumber = sfUser.phoneMobile;
        if (sfUser.email.size() > 0)
            user.email = sfUser.email.get(0).emailAddress;
        user.userName = sfUser.userName;
        user.alias = sfUser.title;
        user.firstName = sfUser.firstName;
        user.id = sfUser.id;
        user.lastName = sfUser.lastName;
        user.name = sfUser.name;
        user.communityNickname = sfUser.fullName;

        return user;
    }

    public static SUsers from(User sfUser) {
        SUsers user = new SUsers();
        //user.companyName = sfUser;
        user.phoneMobile = sfUser.mobileNumber;
//        if (sfUser.email.size() > 0)
//            user.email = sfUser.email.get(0).emailAddress;
        user.userName = sfUser.userName;
        user.title = sfUser.alias;
        user.firstName = sfUser.firstName;
        user.id = sfUser.id;
        user.lastName = sfUser.lastName;
        user.name = sfUser.name;
        user.fullName = sfUser.communityNickname;

        return user;
    }

    public static class Records {
           public SUsers[] records;
           public int next_offset;

           public List<User> to() {
               return Arrays.stream(records).map(SUsers::to).collect(Collectors.toList());
           }
       }

}