package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.response.RegisterResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RegisterResponseHandler extends SimpleChannelInboundHandler<RegisterResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterResponsePacket registerResponsePacket) throws Exception {
    }
}
