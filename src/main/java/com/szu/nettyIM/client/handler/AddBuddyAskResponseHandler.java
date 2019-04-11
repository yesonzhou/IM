package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.response.AddBuddyAskResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:55 PM
 */

public class AddBuddyAskResponseHandler extends SimpleChannelInboundHandler<AddBuddyAskResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyAskResponsePacket addBuddyAskResponsePacket) throws Exception {

    }
}
