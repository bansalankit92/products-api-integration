package com.integration.extensions.domains.sonarqube.util;


import org.apache.commons.text.WordUtils;

public class StringPlus {

    public static String caps(String s){
        return WordUtils.capitalizeFully(s.replaceAll("_"," "));
    }
}