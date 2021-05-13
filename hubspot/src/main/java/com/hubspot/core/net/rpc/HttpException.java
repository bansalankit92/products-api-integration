package com.hubspot.core.net.rpc;

import java.nio.charset.StandardCharsets;

public class HttpException extends Exception
{
  private int responseCode;
  private byte[] response;

  public HttpException(String msg)
  {
    super(msg);
  }

  public HttpException(Exception e)
  {
    super(e);
  }

  public HttpException(int responseCode, byte[] response)
  {
    this.responseCode = responseCode;
    this.response = response;
  }

  public int getResponseCode()
  {
    return responseCode;
  }

  public String getErrorMessage()
  {
    try
    {
      return toString(this.response);
    }
    catch(Exception ex)
    {
      return "";
    }
  }

  public static String toString(byte[] bytes) {
      return new String(bytes, StandardCharsets.UTF_8);
  }
}