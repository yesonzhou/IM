package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.protocol.packet.response.AddBuddyResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class AddBuddyResponseHandler extends
        SimpleChannelInboundHandler<AddBuddyResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                AddBuddyResponsePacket addBuddyResponsePacket) throws Exception {
        LogUtils.p("收到[" + addBuddyResponsePacket.getFromUserName()+"]的好友請求");
    }
}
