package com.hubspot.core.net.client.async;

import io.netty.channel.ChannelOption;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;

public class AsyncClient {

    public static final AsyncHttpClient client;

    static {
        DefaultAsyncHttpClientConfig.Builder builder = new DefaultAsyncHttpClientConfig.Builder();
        builder
                .setKeepAlive(false)
                .setFollowRedirect(true)
                .setUserAgent("Krista 2.0; Ant Brains Corporation")
                .setConnectTimeout(20000)
                .setRequestTimeout(10000)
                .setMaxConnections(16384)
                //.setWebSocketMaxFrameSize(65536 * 2)
                .addChannelOption(ChannelOption.ALLOW_HALF_CLOSURE, false)
                .addChannelOption(ChannelOption.TCP_NODELAY, true)
                .build();
        client = new DefaultAsyncHttpClient(builder.build());
    }
}