package com.net.gson;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class GsonClassGen
{
  private static GsonObject getClipboard()
  {
    try
    {
      return new GsonObject((String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
    }
    catch(Exception e)
    {
      System.out.println("Copy the data JSON to clipboard");
      return null;
    }
  }

  public static void dumpVariables(GsonObject obj)
  {
    List<String> keys = new ArrayList<>(obj.keySet());
    Collections.sort(keys);

    StringBuilder buff = new StringBuilder();
    for(String key : keys)
    {
      JsonElement elem = obj.opt(key);
      if(elem.isJsonPrimitive())
      {
        buff.append("\n public ");
        JsonPrimitive primitive = (JsonPrimitive) elem;
        if(primitive.isBoolean())
        {
          buff.append("boolean ");
        }
        else if(primitive.isNumber())
        {
          buff.append(primitive.toString().contains(".") ? "double " : "long ");
        }
        else if(primitive.isString())
        {
          buff.append("String ");
        }
        else
        {
          buff.append("XXX ");
        }
      }
      else if(elem.isJsonArray())
      {
        buff.append("\n public Array ");
      }
      else if(elem.isJsonObject())
      {
        buff.append("\n //public SnLinkValue ");
      }
      else
      {
        buff.append("AAA ");
      }

      buff.append(key);
      buff.append(";");
    }

    System.out.println(buff.toString());
  }

  public static void main(String[] args)
  {
    GsonObject obj = getClipboard();
    if(obj == null)
    {
      return;
    }

    dumpVariables(obj);
  }
}