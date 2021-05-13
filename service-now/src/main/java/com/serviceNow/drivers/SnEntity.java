package com.serviceNow.drivers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.net.gson.GsonArray;
import com.net.gson.GsonBuilder;
import com.net.gson.GsonObject;

public class SnEntity implements Comparable<SnEntity>
{
  private transient GsonObject original;
  transient Map<String, SnLinkValue> linkMap;

  public GsonObject getOriginal()
  {
    return original;
  }

  public String getNumber()
  {
    try
    {
      return (String) getClass().getField("number").get(this);
    }
    catch(Exception e)
    {
      return null;
    }
  }

  public String getSysId()
  {
    try
    {
      return (String) getClass().getField("sys_id").get(this);
    }
    catch(Exception e)
    {
      // sys id should always be there
      throw new RuntimeException(e);
    }
  }

  public void setFields(Map<String, String> fieldMap)
  {
    Class<? extends SnEntity> entityClass = getClass();

    try
    {
      for(Map.Entry<String, String> entry : fieldMap.entrySet())
      {
        Field field = entityClass.getField(entry.getKey());
        field.set(this, entry.getValue());
      }
    }
    catch(Exception e)
    {
      throw new RuntimeException(e);
    }
  }

  public void setLinks(Map<String, SnEntity> linkMap)
  {
    for(Map.Entry<String, SnEntity> entry : linkMap.entrySet())
    {
      setLink(entry.getKey(), entry.getValue());
    }
  }

  public void setLink(String linkName, SnEntity linkEntity)
  {
    setLink(linkName, linkEntity.getClass(), linkEntity.getSysId());
  }

  public void setLink(String linkName, Class<? extends SnEntity> linkEntityClass, String linkEntitySysId)
  {
    if(linkMap == null)
    {
      linkMap = new LinkedHashMap<>();
    }

    String tableUri = SnEntityDriverMap.getDriver(linkEntityClass).getTableUri();
    String link = SnDriver.envUrl + tableUri + "/" + linkEntitySysId;
    linkMap.put(linkName, new SnLinkValue(getClass().getSimpleName(), linkName, link, linkEntitySysId));
  }
  
  public <T extends SnEntity> T copy()
  {
    try
    {
      @SuppressWarnings("unchecked")
      Class<T> entityClass = (Class<T>) getClass();
      T instance = entityClass.getConstructor().newInstance();
      for(Field field : entityClass.getFields())
      {
        field.set(instance, field.get(this));
      }

      if(linkMap != null)
      {
        instance.linkMap = new LinkedHashMap<>(linkMap);
      }

      return instance;
    }
    catch(Exception e)
    {
      throw new RuntimeException(e);
    }
  }

  public <T extends SnEntity> T getLinkActual(String linkName) throws IOException
  {
    SnLinkValue linkValue = getLinkValue(linkName);
    return linkValue == null ? null : linkValue.getActual();
  }

  public SnLinkValue getLinkValue(String linkName)
  {
    return linkMap == null ? null : linkMap.get(linkName);
  }

  public String toString()
  {
    return GsonBuilder.toJson(this);
  }

  public String toPrettyString()
  {
    return GsonBuilder.toPrettyJson(this);
  }

  public boolean equals(Object that)
  {
    if(that == null)
    {
      return false;
    }

    if(getClass() != that.getClass())
    {
      return false;
    }

    try
    {
      for(Field field : getClass().getFields())
      {
        String fieldName = field.getName();
        if(fieldName.equals("sys_mod_count") || fieldName.equals("sys_updated_on"))
        {
          continue;
        }

        Object fldThis = field.get(this);
        Object fldThat = field.get(that);
        if(!Objects.equals(fldThis, fldThat))
        {
          //System.out.println(field + " not equal");
          return false;
        }
      }

      SnEntity thatEntity = (SnEntity) that;
      if(linkMap != null && thatEntity.linkMap != null)
      {
        for(Map.Entry<String, SnLinkValue> entry : linkMap.entrySet())
        {
          String thisLinkName = entry.getKey();
          SnLinkValue thisLinkValue = entry.getValue();
          SnLinkValue thatLinkValue = thatEntity.linkMap.get(thisLinkName);
          if(thisLinkValue != null && thatLinkValue != null && !thisLinkValue.equals(thatLinkValue))
          {
            // on update sometimes extra links gets added
            return false;
          }
        }

        return true;
      }
      else
      {
        return linkMap == null && thatEntity.linkMap == null;
      }
    }
    catch(IllegalAccessException e)
    {
      throw new RuntimeException(e);
    }
  }

  @SuppressWarnings("unchecked")
  static <T extends SnEntity> T create(GsonObject response, Class<T> cls)
  {
    if(response == null)
    {
      return null;
    }
    else
    {
      SnEntity entity = GsonBuilder.fromJson(response, cls);
      if(entity != null)
      {
        entity.original = response;

        for(Field field : cls.getFields())
        {
          response.remove(field.getName());
        }

        // this are link values
        Set<String> linkNames = response.keySet();
        if(linkNames.size() > 0)
        {
          Map<String, SnLinkValue> linkMap = new LinkedHashMap<>();
          entity.linkMap = linkMap;
          for(String linkName : linkNames)
          {
            JsonElement elem = response.opt(linkName);
            if(elem.isJsonPrimitive())
            {
              linkMap.put(linkName, null);
            }
            else if(elem.isJsonObject())
            {
              GsonObject linkObj = new GsonObject((JsonObject) elem);
              linkMap.put(linkName, new SnLinkValue(entity.getClass().getSimpleName(), linkName,
                linkObj.getString("link"), linkObj.getString("value")));
            }
          }
        }
      }
      return (T) entity;
    }
  }

  static <T extends SnEntity> T createFirst(GsonObject response, Class<T> cls)
  {
    if(response == null)
    {
      return null;
    }

    JsonElement elem = response.opt("result");
    if(elem == null || elem.isJsonNull())
    {
      return null;
    }

    if(elem.isJsonArray())
    {
      GsonArray array = new GsonArray(elem.getAsJsonArray());
      return create(array.size() != 1 ? null : array.getJson(0), cls);
    }

    return create(new GsonObject(elem.getAsJsonObject()), cls);
  }

  static <T extends SnEntity> List<T> createList(GsonObject response, Class<T> cls)
  {
    Set<String> errorSet = null;
    GsonArray records = response.getArray("result");
    List<T> list = new ArrayList<>(records.size());
    for(int i = 0; i < records.size(); i++)
    {
      try
      {
        GsonObject result = records.getJson(i);
        T entity = create(result, cls);
        list.add(entity);
      }
      catch(Exception e)
      {
        if(errorSet == null)
        {
          errorSet = new TreeSet<>();
        }

        errorSet.add(e.getMessage());
      }
    }

    if(errorSet != null)
    {
      for(String error : errorSet)
      {
        System.out.println(error);
      }
    }

    return list;
  }

  @Override
  public int compareTo(SnEntity that)
  {
    return getSysId().compareTo(that.getSysId());
  }
}