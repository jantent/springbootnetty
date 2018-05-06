package com.client.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangj
 * @date 2018/5/6 22:54
 */
@Configuration
public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    StringDecoder stringDecoder;

    @Autowired
    StringEncoder stringEncoder;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

    }
}
