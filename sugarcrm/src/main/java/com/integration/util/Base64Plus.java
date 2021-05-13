package com.integration.util;

import java.util.Base64;

public class Base64Plus {

    public static class UsernamePassword {
        private String username, passowrd;

        @Override
        public String toString() {
            return "UsernamePassword{" +
                    "username='" + username + '\'' +
                    ", passowrd='" + passowrd + '\'' +
                    '}';
        }

        public UsernamePassword(String username, String passowrd) {
            this.username = username;
            this.passowrd = passowrd;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassowrd() {
            return passowrd;
        }

        public void setPassowrd(String passowrd) {
            this.passowrd = passowrd;
        }
    }

    public static String encode(UsernamePassword up) {
        return new String(Base64.getEncoder().encode((up.getUsername() + ":" + up.passowrd).getBytes()));
    }

    public static UsernamePassword decode(String usernamePasswordBase64) {
        String deocded = new String(Base64.getDecoder().decode((usernamePasswordBase64)));
        String[] usernamePassword = deocded.split(":");
        return new UsernamePassword(usernamePassword[0], usernamePassword[1]);
    }
}