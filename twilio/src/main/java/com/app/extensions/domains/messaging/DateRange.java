package com.app.extensions.domains.messaging;

import com.google.gson.annotations.SerializedName;

public final class DateRange {
  @SerializedName("from")
  public Long from;

  @SerializedName("to")
  public Long to;
}
