package com.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

@Component
public class NettyTcpClient {
    @Resource
    private Bootstrap bootstrap;

    @Value("${tcp.port}")
    private int tcpPort;

    @Value(("${tcp.ip}"))
    private String serverIp;

    private Channel channel;

    public void connect() throws Exception{
        InetSocketAddress inetSocketAddress = new InetSocketAddress(serverIp,tcpPort);
        // 发起异步连接
        ChannelFuture future = bootstrap.connect(inetSocketAddress);
        future.channel().closeFuture().sync();
    }

    public void stop() throws Exception{
        channel.close();

    }
}
