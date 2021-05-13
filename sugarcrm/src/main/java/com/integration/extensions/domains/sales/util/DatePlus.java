package com.integration.extensions.domains.sales.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DatePlus {

//    public static String getISODate(Date date) {
//        SimpleDateFormat sdf;
//        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//        return sdf.format(date);
//    }

    public static String getYYYYMMDD(Long date) {
        if (date!=null) {
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(new Date(date));
        }else return null;
    }


    public static Long fromYYYYMMDD(String date) {
        if (date!=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(date).getTime();
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    public static Date fromISO(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getISODate(Date date) {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public static String getISODate(Long date) {
          if (date!=null){
              return getISODate(new Date(date));
          }
          return null;
       }

    public static Long getISODate(String isoDate) {
        if (isoDate != null) {
            Date d = DatePlus.fromISO(isoDate);
            return d != null ? d.getTime() : null;
        }
        return null;

    }
}