package com.hubspot.core.net.rpc;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory
{
  private SSLSocketFactory internalSSLSocketFactory;

  private static TLSSocketFactory thirdPartySocketFactory = null;
  private static String[] PROTOCOLS = null;

  private TLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException
  {
    SSLContext context = SSLContext.getInstance("TLS");
    context.init(null, null, null);
    internalSSLSocketFactory = context.getSocketFactory();
  }

  public static TLSSocketFactory getThirdPartySocketFactory() throws NoSuchAlgorithmException, KeyManagementException
  {
    if(thirdPartySocketFactory == null)
    {
      synchronized(TLSSocketFactory.class)
      {
        if(thirdPartySocketFactory == null)
        {
          thirdPartySocketFactory = new TLSSocketFactory();
        }
      }
    }
    return thirdPartySocketFactory;
  }

  @Override
  public String[] getDefaultCipherSuites()
  {
    return internalSSLSocketFactory.getDefaultCipherSuites();
  }

  @Override
  public String[] getSupportedCipherSuites()
  {
    return internalSSLSocketFactory.getSupportedCipherSuites();
  }

  @Override
  public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException
  {
    return enableTLSOnSocket(internalSSLSocketFactory.createSocket(s, host, port, autoClose));
  }

  @Override
  public Socket createSocket(String host, int port) throws IOException
  {
    return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port));
  }

  @Override
  public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException
  {
    return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port, localHost, localPort));
  }

  @Override
  public Socket createSocket(InetAddress host, int port) throws IOException
  {
    return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port));
  }

  @Override
  public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException
  {
    return enableTLSOnSocket(internalSSLSocketFactory.createSocket(address, port, localAddress, localPort));
  }

  @Override
  public Socket createSocket() throws IOException
  {
    return enableTLSOnSocket(internalSSLSocketFactory.createSocket());
  }

  private Socket enableTLSOnSocket(Socket socket)
  {
    if(socket != null && socket instanceof SSLSocket)
    {
      // Use following configurations to allow all connections
      //((SSLSocket) socket).setEnabledProtocols(new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});

      // Use following configurations to allow only SSLv3 connections
      // ((SSLSocket) socket).setEnabledProtocols(new String[]{"SSLv3"});

      initSupportedProtocols((SSLSocket) socket);

      // Use following configurations to allow only TLS connections
      ((SSLSocket) socket).setEnabledProtocols(PROTOCOLS);
    }
    return socket;
  }

  private void initSupportedProtocols(SSLSocket socket)
  {
    if(PROTOCOLS == null)
    {
      synchronized(TLSSocketFactory.class)
      {
        String[] localProtocols = socket.getSupportedProtocols();
        String[] remoteProtocols = {"TLSv1", "TLSv1.1", "TLSv1.2"};

        for(String remote : remoteProtocols)
        {
          for(String local : localProtocols)
          {
            if(compareToIgnoreCase(remote, local) == 0)
            {
              if(PROTOCOLS == null)
              {
                PROTOCOLS = new String[0];
              }
              PROTOCOLS = concat(PROTOCOLS, remote);
              break;
            }
          }
        }
      }
    }
  }

  public static int compareToIgnoreCase(String v1, String v2) {
      return v1 == null ? v2 == null ? 0 : -1 : v2 == null ? 1 : v1.compareToIgnoreCase(v2);
  }

  @SuppressWarnings("unchecked")
  private static <T> T[] concat(T[] array, T obj) {
      int len = array.length;
      T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), len + 1);
      System.arraycopy(array, 0, result, 0, len);
      result[len] = obj;
      return result;
  }
}
