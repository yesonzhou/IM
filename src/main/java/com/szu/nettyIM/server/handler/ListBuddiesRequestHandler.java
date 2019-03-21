package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.ListBuddiesRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class ListBuddiesRequestHandler extends SimpleChannelInboundHandler<ListBuddiesRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListBuddiesRequestPacket listBuddiesRequestPacket) throws Exception {
        // TODO: 2019/3/18 finish it
    }

}
