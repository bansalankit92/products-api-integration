package com.hubspot;

import java.util.LinkedList;
import java.util.List;
import com.net.gson.GsonArray;
import com.net.gson.GsonObject;

public class XformDeal
{
  public static List<Deal> createList(GsonObject gson)
  {
    List<Deal> list = new LinkedList<>();
    GsonArray results = gson.getArray("results");
    for(int i = 0; i < results.size(); i++)
    {
      GsonObject result = results.getJson(i);
      String id = result.optString("id");
      GsonObject properties = result.optJson("properties");
      if(id != null && properties != null)
      {
        Deal deal = create(id, properties);
        list.add(deal);
      }
    }
    return list;
  }

  public static Deal create(String id, GsonObject properties)
  {
    Deal deal = new Deal();
    deal.id = id;
    deal.name = properties.optString("dealname");
    deal.stage = properties.optString("dealstage");
    deal.amount = properties.optDouble("amount");
    return deal;
  }

  public static GsonArray toArray(List<Deal> list)
  {
    GsonArray array = new GsonArray();
    for(Deal deal : list)
    {
      array.add(GsonObject.fromObject(deal));
    }
    return array;
  }
}