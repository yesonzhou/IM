package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.response.AddBuddyResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:52 PM
 */

public class AddBuddyResponseHandler extends SimpleChannelInboundHandler<AddBuddyResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyResponsePacket addBuddyResponsePacket) throws Exception {

    }
}
