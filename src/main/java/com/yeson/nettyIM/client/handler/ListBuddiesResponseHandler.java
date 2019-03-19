package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.bean.Buddy;
import com.yeson.nettyIM.protocol.packet.response.ListBuddiesResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

public class ListBuddiesResponseHandler extends SimpleChannelInboundHandler<ListBuddiesResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListBuddiesResponsePacket listBuddiesResponsePacket) throws Exception {

    }
}
