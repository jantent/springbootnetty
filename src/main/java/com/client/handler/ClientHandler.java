package com.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * @author tangj
 * @date 2018/5/6 22:59
 */
@Component
public class ClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端收到消息" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = "客户端发来消息";
        System.out.println(msg);
        byte[] req = msg.getBytes("utf-8");
        ByteBuf byteBuf = Unpooled.wrappedBuffer(req);
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
