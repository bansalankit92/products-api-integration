package com.extensions.domains.sales;

import com.google.gson.annotations.SerializedName;
import java.lang.Long;

public final class DateRange {
  @SerializedName("from")
  public Long from;

  @SerializedName("to")
  public Long to;
}
