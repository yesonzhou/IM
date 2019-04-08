package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.bean.Buddy;
import com.szu.nettyIM.protocol.packet.request.ListBuddiesRequestPacket;
import com.szu.nettyIM.protocol.packet.response.ListBuddiesResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;


public class ListBuddiesRequestHandler extends SimpleChannelInboundHandler<ListBuddiesRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListBuddiesRequestPacket listBuddiesRequestPacket) throws Exception {
        // TODO: 2019/3/18 finish it
        String uid = listBuddiesRequestPacket.getUserName();

        // 查询uid的好友列表

        System.out.println("好友列表为：test");

        List<Buddy> buddies = new ArrayList<>();
        buddies.add(new Buddy("buddies1"));
        ListBuddiesResponsePacket lbrp = new ListBuddiesResponsePacket(buddies);

        ctx.channel().writeAndFlush(lbrp);
    }

}
