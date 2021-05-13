package com.serviceNow.xfers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class XferEnum
{
  private final Map<String, Integer> keyMap = new LinkedHashMap<>();
  private final Map<Integer, String> valueMap = new LinkedHashMap<>();

  public String getKey(String index)
  {
    try
    {
      return index == null || (index = index.trim()).isEmpty() ? null : valueMap.get(Integer.valueOf(index));
    }
    catch(NumberFormatException e)
    {
      return null;
    }
  }

  public String getIndex(String key)
  {
    Integer obj = keyMap.get(key.trim().toLowerCase());
    return obj == null ? null : String.valueOf(obj);
  }

  void add(String... keys)
  {
    for(String key : keys)
    {
      int index = keyMap.size() + 1;
      String trim = key.trim();
      keyMap.put(trim.toLowerCase(), index);
      valueMap.put(index, trim);
    }
  }

  public Set<String> keySet()
  {
    return keyMap.keySet();
  }
}