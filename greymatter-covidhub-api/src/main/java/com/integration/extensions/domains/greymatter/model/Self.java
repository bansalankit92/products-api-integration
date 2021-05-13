package com.integration.extensions.domains.greymatter.model;

import java.util.List;

public class Self {
    public String label,iss;
    public Long exp;
    public Values values;

    public static class Values{
        private List<String> email;
        private List<String> org;

        public List<String> getEmail() {
            return email;
        }

        public List<String> getOrg() {
            return org;
        }
    }

    public List<String> getEmails() {
        if (values!=null){
           return values.getEmail();
        } throw new RuntimeException("Email Not found!");
    }
    
}