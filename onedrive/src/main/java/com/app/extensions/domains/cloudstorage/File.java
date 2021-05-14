package com.app.extensions.domains.cloudstorage;

import com.google.gson.annotations.SerializedName;

public final class File {
  @SerializedName("length")
  public Long length;

  @SerializedName("fileName")
  public String fileName;

  @SerializedName("extension")
  public String extension;

  @SerializedName("mediaId")
  public String mediaId;
}
