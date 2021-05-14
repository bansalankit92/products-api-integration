package com.app.extensions.domains.messaging;

import com.google.gson.annotations.SerializedName;

public final class PhoneNumber {
  @SerializedName("countryCode")
  public Long countryCode;

  @SerializedName("nationalNumber")
  public Long nationalNumber;
}
