package com.serviceNow.xfers;

import com.google.gson.Gson;

public class XferBase {

    private static final Gson gson = new Gson();
    public static final XferEnum enumUrgency = new XferEnum();
    public static final XferEnum enumImpact = new XferEnum();
    public static final XferEnum enumState = new XferEnum();

    static {
        enumUrgency.add("High", "Medium", "Low");
        enumImpact.add("High", "Medium", "Low");
        enumState.add("New", "In Progress", "On Hold", "Resolved", "Closed", "Canceled");
    }

}