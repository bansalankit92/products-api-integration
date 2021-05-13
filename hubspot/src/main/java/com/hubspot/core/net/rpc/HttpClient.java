package com.hubspot.core.net.rpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

public class HttpClient
{
  private static final byte[] emptyBytes = new byte[0];
  public static final int CONST_SocketTimeout = 20000;

  static
  {
    System.setProperty("http.keepAlive", "true");
  }

  public static void postText(String url, String text) throws HttpException
  {
    try
    {
      boolean https = url.startsWith("https");
      postLine(new URL(url), https, CONST_SocketTimeout, "text/plain; charset=UTF-8", toBytes(text));
    }
    catch(HttpException e)
    {
      throw e;
    }
    catch(Exception e)
    {
      throw new HttpException(e);
    }
  }

  public static void postJson(String url, String json) throws HttpException
  {
    try
    {
      boolean https = url.startsWith("https");
      postLine(new URL(url), https, CONST_SocketTimeout, "application/json; charset=UTF-8", toBytes(json));
    }
    catch(HttpException e)
    {
      throw e;
    }
    catch(Exception e)
    {
      throw new HttpException(e);
    }
  }

  private static byte[] postLine(URL url, boolean ssl, int timeout, String contentType, byte[] line) throws Exception
  {
    HttpURLConnection conn = null;

    try
    {
      conn = (HttpURLConnection) url.openConnection();
      conn.setConnectTimeout(timeout);
      conn.setReadTimeout(timeout);
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Connection", "Close"); // for HTTPS methods this is important
      conn.setRequestProperty("Cache-Control", "private, no-cache, no-store");
      conn.setRequestProperty("Content-Type", contentType);
      conn.setRequestProperty("Accept-Encoding", "gzip");

      // Pin certificate if ssl connection is used
      if(ssl)
      {
        HttpsURLConnection _conn = (HttpsURLConnection) conn;
        _conn.setSSLSocketFactory(TLSSocketFactory.getThirdPartySocketFactory());
      }

      writeBytes(conn, line);

      int responseCode = conn.getResponseCode();
      byte[] bytes = readBytes(responseCode, conn);

      if(responseCode == HttpURLConnection.HTTP_OK)
      {
        return bytes;
      }
      else
      {
        throw new HttpException(responseCode, bytes);
      }
    }
    finally
    {
      if(conn != null)
      {
        conn.disconnect();
      }
    }
  }

  private static void writeBytes(HttpURLConnection conn, byte[] bytes) throws IOException
  {
    if(bytes == null)
    {
      bytes = emptyBytes;
    }

    conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));

    OutputStream os = null;
    try
    {
      os = conn.getOutputStream();
      os.write(bytes);
      os.flush();
    }
    finally
    {
      if(os != null)
      {
        os.close();
      }
    }
  }

  // does not depend on content length
  private static byte[] readBytes(int responseCode, HttpURLConnection conn) throws IOException
  {
    int buffSize = 8192;
    List<byte[]> buffList = null;

    InputStream is = null;
    try
    {
      InputStream inputStream = responseCode < HttpURLConnection.HTTP_BAD_REQUEST ?
        conn.getInputStream() : conn.getErrorStream();

      if("gzip".equalsIgnoreCase(conn.getContentEncoding()))
      {
        is = new GZIPInputStream(inputStream);
      }
      else
      {
        is = inputStream;
      }

      byte[] bytes = null;
      int i = 0;
      int b;
      int total = 0;
      while((b = is.read()) != -1)
      {
        total++;

        if(buffList == null)
        {
          buffList = new ArrayList<>(1);
        }

        if(bytes == null)
        {
          bytes = new byte[buffSize];
          buffList.add(bytes);
        }

        bytes[i] = (byte) b;
        i++;

        if(i == buffSize)
        {
          bytes = null;
          i = 0;
        }
      }

      if(buffList == null)
      {
        return null;
      }

      byte[] result = new byte[total]; //TODO: should be free buffer
      for(int j = 0; j < total; j++)
      {
        result[j] = buffList.get(j / buffSize)[j % buffSize];
      }

      return result;
    }
    finally
    {
      if(is != null)
      {
        is.close();
      }
    }
  }

  public static byte[] toBytes(String str)
  {
    return str.getBytes(StandardCharsets.UTF_8);
  }

  public static String toString(byte[] bytes)
  {
    return new String(bytes, StandardCharsets.UTF_8);
  }
}