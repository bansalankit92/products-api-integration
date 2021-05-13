package com.integration.extensions.domains.covidhub.model;

public enum SortBy {
    cases,todayCases,deaths,todayDeaths,active ;

    public  static String getDefault(){
        return todayCases.name();
    }
}
