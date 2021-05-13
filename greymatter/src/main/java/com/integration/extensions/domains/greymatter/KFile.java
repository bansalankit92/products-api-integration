package com.integration.extensions.domains.greymatter;

import com.google.gson.annotations.SerializedName;
import java.lang.Long;
import java.lang.String;

public final class KFile {
  @SerializedName("length")
  public Long length;

  @SerializedName("fileName")
  public String fileName;

  @SerializedName("extension")
  public String extension;

  @SerializedName("mediaId")
  public String mediaId;
}
