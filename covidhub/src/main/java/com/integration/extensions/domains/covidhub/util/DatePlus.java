package com.integration.extensions.domains.covidhub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DatePlus {

//    public static String getISODate(Date date) {
//        SimpleDateFormat sdf;
//        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//        return sdf.format(date);
//    }

    public static String getYYYYMMDD(Long date) {
        if (date != null) {
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(new Date(date));
        } else return null;
    }


    public static Date fromYYYYMMDD(String date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    public static Date fromMDYY(String date) {
           if (date != null) {
               SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy");
               try {
                   return sdf.parse(date);
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
        if (date != null) {
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

    public static long getDateDiffFromToday(Date date) {
        long duration = new Date().getTime() - date.getTime();
        return TimeUnit.MILLISECONDS.toDays(duration);
    }
}