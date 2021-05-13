package com.serviceNow.drivers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SnLinkValue
{
  public final String link;
  public final String value;
  private transient final SnEntityDriver driver;
  private transient final String driverNotFoundMsg;

  SnLinkValue(String fromEntity, String fromLinkName, String link, String value)
  {
    this.link = link;
    this.value = value;

    URL url;
    try
    {
      url = new URL(link);
    }
    catch(MalformedURLException e)
    {
      throw new RuntimeException(e);
    }

    String path = url.getPath();
    StringTokenizer tzer = new StringTokenizer(path, "/");
    tzer.nextToken();
    tzer.nextToken();
    tzer.nextToken();
    String entityTable = tzer.nextToken();

    driverNotFoundMsg = "Driver not found for, " + fromEntity + "/" + fromLinkName + ", table, " + entityTable;
    driver = SnEntityDriverMap.getDriver(entityTable);
    if(driver == null && !SnEntityDriverMap.isSkipped(entityTable))
    {
      throw new RuntimeException(driverNotFoundMsg);
    }
  }

  //TODO: get access token context
  public <T extends SnEntity> T getActual() throws IOException
  {
    return (T) getDriver().getById(value);
  }

  public boolean hasDriver()
  {
    return driver != null;
  }

  public SnEntityDriver getDriver()
  {
    if(driver == null)
    {
      throw new RuntimeException(driverNotFoundMsg);
    }

    return driver;
  }

  @SuppressWarnings("ConstantConditions")
  public boolean equals(Object that)
  {
    return that != null && link.equals(((SnLinkValue) that).link);
  }

  public String toString()
  {
    return link;
  }
}