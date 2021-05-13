package com.hubspot;

import java.util.LinkedList;
import java.util.List;
import com.net.gson.GsonArray;
import com.net.gson.GsonObject;

public class XformContact
{
  public static List<Contact> createList(GsonObject gson)
  {
    List<Contact> list = new LinkedList<>();
    GsonArray results = gson.getArray("results");
    for(int i = 0; i < results.size(); i++)
    {
      GsonObject result = results.getJson(i);
      String id = result.optString("id");
      GsonObject properties = result.optJson("properties");
      if(id != null && properties != null)
      {
        Contact contact = create(id, properties);
        list.add(contact);
      }
    }
    return list;
  }

  public static Contact create(String id, GsonObject properties)
  {
    Contact contact = new Contact();
    contact.id = id;
    contact.firstName = properties.optString("firstname");
    contact.lastName = properties.optString("lastname");
    contact.email = properties.optString("email");
    return contact;
  }

  public static GsonArray toArray(List<Contact> list)
  {
    GsonArray array = new GsonArray();
    for(Contact contact : list)
    {
      array.add(GsonObject.fromObject(contact));
    }
    return array;
  }
}