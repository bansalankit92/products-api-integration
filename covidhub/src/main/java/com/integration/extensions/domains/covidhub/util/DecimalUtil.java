package com.integration.extensions.domains.covidhub.util;

import java.text.DecimalFormat;

public class DecimalUtil {
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static String getPercentFormatted(Double val) {
        if (val ==0) return "0";
        if (val.isNaN() || val.isInfinite()) return "NA";
        return df2.format(val) + "%";
    }
}