package com.extensions.domains.sales.util;

import java.util.List;

public class SalesforceListResponse<T> {

    public int totalSize;
    public boolean done;
    public List<T> records;

}
