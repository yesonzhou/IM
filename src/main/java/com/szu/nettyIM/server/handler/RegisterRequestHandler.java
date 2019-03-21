package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.RegisterRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RegisterRequestHandler extends SimpleChannelInboundHandler<RegisterRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterRequestPacket registerRequestPacket) throws Exception {
        // TODO: 2019/3/18 finish it
    }
}
