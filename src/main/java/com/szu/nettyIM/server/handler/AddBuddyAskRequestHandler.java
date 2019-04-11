package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.AddBuddyAskRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:57 PM
 */

public class AddBuddyAskRequestHandler extends SimpleChannelInboundHandler<AddBuddyAskRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyAskRequestPacket addBuddyAskRequestPacket) throws Exception {

    }
}
