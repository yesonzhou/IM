package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) {
        String fromUserName = messageResponsePacket.getFromUserName();
        System.out.println(fromUserName + " -> " + messageResponsePacket
                .getMessage());
    }
}
