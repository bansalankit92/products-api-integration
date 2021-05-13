package com.serviceNow.drivers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.net.gson.GsonBuilder;
import com.net.gson.GsonObject;

public class SnEntityDriver<T extends SnEntity> extends SnDriver implements Comparable<SnEntityDriver<T>>
{
  public static final String API_NOW_TABLE = "/api/now/table/";
  
  public final String entityTable;
  public final Class<T> entityClass;

  SnEntityDriver(String entityTable, Class<T> entityClass)
  {
    this.entityTable = entityTable;
    this.entityClass = entityClass;
  }

  public String getTableUri()
  {
    return API_NOW_TABLE + entityTable;
  }

  public final T getSample() throws IOException
  {
    List<T> list = getList(10);
    Collections.shuffle(list);
    return list.iterator().next();
  }
  
  public final List<T> getList(int count) throws IOException
  {
    GsonObject response = get(getTableUri() + "?sysparm_limit=" + count);
    return SnEntity.createList(response, entityClass);
  }

  public final List<T> getList(int count, String key, String value) throws IOException
  {
    GsonObject response = get(getTableUri()
      + "?sysparm_limit=" + count
      + "&sysparm_query=" + and(key, value));
    return SnEntity.createList(response, entityClass);
  }

  public final List<T> getList(int count, Map<String, String> varMap) throws IOException
  {
    GsonObject response = get(getTableUri()
      + "?sysparm_limit=" + count
      + "&sysparm_query=" + and(varMap));
    return SnEntity.createList(response, entityClass);
  }

  public final T getById(String sysId) throws IOException
  {
    String query = getTableUri() + "/" + sysId;
    GsonObject response = get(query);
    return SnEntity.createFirst(response, entityClass);
  }

  public final T getByNumber(String number) throws IOException
  {
    return getByKey("number", number);
  }

  public final T getByKey(String key, String value) throws IOException
  {
    String query = getTableUri() + "?sysparm_query=" + and(key, value);
    GsonObject response = get(query);
    return SnEntity.createFirst(response, entityClass);
  }

  public final T update(String sysId, String key, String value) throws IOException
  {
    String json = String.format("{\"%s\":\"%s\"}", key, value);
    String query = getTableUri() + "/" + sysId;
    GsonObject response = put(query, json);
    return SnEntity.createFirst(response, entityClass);
  }

  public final T update(String sysId, Map<String, String> varMap) throws IOException
  {
    GsonObject json = mapToJson(varMap);
    String query = getTableUri() + "/" + sysId;
    GsonObject response = put(query, json.toString());
    return SnEntity.createFirst(response, entityClass);
  }

  public final T insert(SnEntity entity, Map<String, String> varMap) throws IOException
  {
    GsonObject json = entity == null ? new GsonObject() : GsonBuilder.toJsonObject(entity);
    if(varMap != null)
    {
      for(Map.Entry<String, String> entry : varMap.entrySet())
      {
        json.put(entry.getKey(), entry.getValue());
      }
    }

    String query = getTableUri();
    GsonObject response = post(query, json.toString());
    return SnEntity.createFirst(response, entityClass);
  }

  public final T insert(Map<String, String> varMap) throws IOException
  {
    GsonObject json = mapToJson(varMap);
    GsonObject response = post(getTableUri(), json.toString());
    return SnEntity.createFirst(response, entityClass);
  }

  public final T deleteById(String sysId) throws IOException
  {
    String query = getTableUri() + "/" + sysId;
    GsonObject response = delete(query);
    return SnEntity.createFirst(response, entityClass);
  }

  private GsonObject mapToJson(Map<String, String> varMap)
  {
    GsonObject json = new GsonObject();
    for(Map.Entry<String, String> entry : varMap.entrySet())
    {
      json.put(entry.getKey(), entry.getValue());
    }
    return json;
  }

  @Override
  public int compareTo(SnEntityDriver<T> entityDriver)
  {
    return entityClass.getName().compareTo(entityDriver.entityClass.getName());
  }
}