package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.bean.Buddy;
import com.szu.nettyIM.protocol.packet.response.ListBuddiesResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

public class ListBuddiesResponseHandler extends SimpleChannelInboundHandler<ListBuddiesResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListBuddiesResponsePacket listBuddiesResponsePacket) throws Exception {
        // todo 获取好友列表，并展示
        List<Buddy> buddies = listBuddiesResponsePacket.getBuddies();

        System.out.println("好友列表为：" + buddies.toString());
    }
}
