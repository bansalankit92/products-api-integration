package com.serviceNow.drivers;

import java.io.IOException;
import com.net.gson.GsonObject;

public class SnException extends IOException
{
  public final String uri;
  public final String message;
  public final String detail;
  public final String status;

  public SnException(String uri, GsonObject gson)
  {
    this.uri = uri;

    GsonObject error = gson.getJson("error");
    message = error.getString("message");
    detail = error.optString("detail");
    status = gson.getString("status");
  }

  @Override
  public String getMessage()
  {
    return toString();
  }

  public String toString()
  {
    return uri + " => " + (detail == null ? message : detail);
  }
}