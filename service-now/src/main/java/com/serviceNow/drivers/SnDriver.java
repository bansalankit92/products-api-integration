package com.serviceNow.drivers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import com.net.gson.GsonObject;
import okhttp3.*;

public class SnDriver
{
  private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
  private static final OkHttpClient client = new OkHttpClient();
  private static final String clientId = "c6d61b1135631010aa4af0b126d2a201";
  private static final String clientSecret = "pwd123";
  public static final String envUrl = "https://dev98840.service-now.com";
  private static final String username = "admin";
  private static final String password = "AbcXyz$54";

  protected String and(Map<String, String> varMap)
  {
    StringBuilder buff = new StringBuilder();
    boolean and = false;
    for(Map.Entry<String, String> entry : varMap.entrySet())
    {
      if(and)
      {
        buff.append("^");
      }
      else
      {
        and = true;
      }
      buff.append(entry.getKey()).append("=").append(entry.getValue());
    }
    return encodeValue(buff.toString());
  }

  protected String and(String key, String value)
  {
    Map<String, String> varMap = new LinkedHashMap<>();
    varMap.put(key, value);
    return and(varMap);
  }

  protected String or(Map<String, String> varMap)
  {
    StringBuilder buff = new StringBuilder();
    boolean and = false;
    for(Map.Entry<String, String> entry : varMap.entrySet())
    {
      if(and)
      {
        buff.append("^OR");
      }
      else
      {
        and = true;
      }
      buff.append(entry.getKey()).append("=").append(entry.getValue());
    }
    return encodeValue(buff.toString());
  }

  protected String encodeValue(String value) {
      try {
          return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
      } catch (UnsupportedEncodingException ex) {
          throw new RuntimeException(ex.getCause());
      }
  }

  //region gson apis

  protected GsonObject get(String uri) throws IOException
  {
    return check(uri, new GsonObject(httpGet(getAccessToken(), uri)));
  }

  protected GsonObject put(String uri, String json) throws IOException
  {
    return check(uri, new GsonObject(httpPut(getAccessToken(), uri, json)));
  }

  protected GsonObject post(String uri, String json) throws IOException
  {
    return check(uri, new GsonObject(httpPost(getAccessToken(), uri, json)));
  }

  protected GsonObject delete(String uri) throws IOException
  {
    return check(uri, new GsonObject(httpGet(getAccessToken(), uri)));
  }

  protected GsonObject check(String uri, GsonObject response) throws SnException
  {
    if(response.has("error"))
    {
      throw new SnException(uri, response);
    }
    else
    {
      return response;
    }
  }

  //endregion

  //region http
  
  private String httpGet(String accessToken, String uri) throws IOException
  {
    String actualUrl = envUrl + uri;
    Request.Builder builder = new Request.Builder()
      .url(actualUrl)
      .addHeader("Cache-Control", "no-cache")
      .addHeader("Accept", "application/json")
      .addHeader("Content-Type", "application/json")
      .addHeader("Authorization", "Bearer " + accessToken);

    Request request = builder.get().build();
    try (Response response = client.newCall(request).execute())
    {
      return response.body().string();
    }
  }

  private String httpPut(String accessToken, String uri, String json) throws IOException
  {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
      .url(envUrl + uri)
      .addHeader("Cache-Control", "no-cache")
      .addHeader("Authorization", "Bearer " + accessToken)
      .put(body)
      .build();
    try (Response response = client.newCall(request).execute())
    {
      return response.body().string();
    }
  }

  private String httpPost(String accessToken, String uri, String json) throws IOException
  {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
      .url(envUrl + uri)
      .addHeader("Cache-Control", "no-cache")
      .addHeader("Authorization", "Bearer " + accessToken)
      .post(body)
      .build();
    try (Response response = client.newCall(request).execute())
    {
      return response.body().string();
    }
  }

  private String httpDelete(String accessToken, String uri) throws IOException
  {
    String actualUrl = envUrl + uri;
    Request.Builder builder = new Request.Builder()
      .url(actualUrl)
      .addHeader("Cache-Control", "no-cache")
      .addHeader("Accept", "application/json")
      .addHeader("Content-Type", "application/json")
      .addHeader("Authorization", "Bearer " + accessToken);

    Request request = builder.delete().build();
    try (Response response = client.newCall(request).execute())
    {
      return response.body().string();
    }
  }

  private String getAccessToken() throws IOException
  {
    return password(envUrl, clientId, clientSecret, username, password).getString("access_token");
  }

  private GsonObject password(String envUrl, String clientId, String clientSecret,
    String username, String password) throws IOException
  {
    RequestBody formBody = new FormBody.Builder()
      .add("grant_type", "password")
      .add("client_id", clientId)
      .add("client_secret", clientSecret)
      .add("username", username)
      .add("password", password)
      .build();
    Request request = new Request.Builder()
      .url(envUrl + "/oauth_token.do")
      .addHeader("Content-Type", "application/x-www-form-urlencoded")
      .post(formBody).build();
    try (Response response = client.newCall(request).execute())
    {
      return new GsonObject(response.body().string());
    }
  }

  //endregion
}