package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.protocol.packet.response.AddBuddyAskResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class AddBuddyAskResponseHandler extends
        SimpleChannelInboundHandler<AddBuddyAskResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyAskResponsePacket addBuddyAskResponsePacket) throws Exception {
        if (addBuddyAskResponsePacket.isAccept()) {
            LogUtils.p("用户[" + addBuddyAskResponsePacket.getSenderUsername() +
                    "]同意了你的好友请求");
        } else {
            LogUtils.p("用户[" + addBuddyAskResponsePacket.getSenderUsername() +
                    "]不同意你的好友请求");
        }
    }
}
