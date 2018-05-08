package com.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.net.InetSocketAddress;

@Component
public class NettyTcpServer {

    @Resource
    private ServerBootstrap bootstrap;

    @Resource
    private InetSocketAddress tcpPort;

    private ChannelFuture serverChannelFuture;

    /**
     * 在启动servlet的时候，启动netty
     * @throws Exception
     */
    @PostConstruct
    public void start() throws Exception{
        System.out.printf("netty服务器启动");
        serverChannelFuture = bootstrap.bind(tcpPort);
        serverChannelFuture.channel().closeFuture().sync();
    }

    /**
     * servlet关闭的时候，关闭netty服务
     * @throws Exception
     */
    @PreDestroy
    public void stop() throws Exception{
        serverChannelFuture.channel().closeFuture().sync();
    }
}
