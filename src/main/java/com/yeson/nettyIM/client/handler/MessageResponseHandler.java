package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.protocol.packet.response.MessageResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) {
        String fromUserId = messageResponsePacket.getFromUserId();
        String fromUserName = messageResponsePacket.getFromUserName();
        LogUtils.p(fromUserId + ":" + fromUserName + " -> " + messageResponsePacket
                .getMessage());

    }
}
