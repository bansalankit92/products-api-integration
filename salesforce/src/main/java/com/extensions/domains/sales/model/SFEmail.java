package com.extensions.domains.sales.model;

import java.util.ArrayList;
import java.util.List;

public class SFEmail {
    public String emailAddresses,emailSubject,emailBody;

    public SFEmail(String emailAddresses, String emailSubject, String emailBody) {
        this.emailAddresses = emailAddresses;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
    }

    public static class Body{
        public List<SFEmail> inputs = new ArrayList<>();
    }
}