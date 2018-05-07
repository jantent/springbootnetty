package com.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
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

    public void connect() throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(serverIp, tcpPort);
        // 发起异步连接
        ChannelFuture future = bootstrap.connect(inetSocketAddress);
        channel = future.sync().channel();
        System.out.println("connect server success|");
    }

    public void stop() throws Exception {
        channel.close();

    }

    public void sendMessage(String msg) {
        try {
            ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.getBytes("utf-8"));
            channel.writeAndFlush(byteBuf);
        } catch (UnsupportedEncodingException e) {
            System.out.println("数据发送失败");
        }

    }
}
