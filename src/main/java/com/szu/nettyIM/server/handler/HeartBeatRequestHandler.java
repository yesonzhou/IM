package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.HeartBeatRequestPacket;
import com.szu.nettyIM.protocol.packet.response.HeartBeatResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/3/22 1:22 PM
 */

@ChannelHandler.Sharable
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

    public HeartBeatRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatRequestPacket requestPacket) {
        System.out.println("接收到心跳包，返回数据");
    }
}

