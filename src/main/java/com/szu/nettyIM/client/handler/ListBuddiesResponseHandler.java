package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.response.ListBuddiesResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

public class ListBuddiesResponseHandler extends SimpleChannelInboundHandler<ListBuddiesResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListBuddiesResponsePacket listBuddiesResponsePacket) throws Exception {

    }
}
