package com.ceaser.netty.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Created by Administrator on 2017/5/20.
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output "+msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // ctx.writeAndFlush(123456L);
    /*
        都可以发送
        ctx.writeAndFlush(1L);
        ctx.writeAndFlush(2L);
        ctx.writeAndFlush(3L);
        ctx.writeAndFlush(4L);*/

        ctx.writeAndFlush(Unpooled.copiedBuffer("helloworld", Charset.forName("utf-8")));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}

