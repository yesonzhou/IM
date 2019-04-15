package com.szu.nettyIM.server.handler;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.szu.nettyIM.protocol.packet.request.AddBuddyAskRequestPacket;
import com.szu.nettyIM.protocol.packet.response.AddBuddyAskResponsePacket;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:57 PM
 */

public class AddBuddyAskRequestHandler extends SimpleChannelInboundHandler<AddBuddyAskRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyAskRequestPacket addBuddyAskRequestPacket) throws Exception {
        AddBuddyAskResponsePacket addBuddyAskResponsePacket = new AddBuddyAskResponsePacket();

        Boolean isAccept = addBuddyAskRequestPacket.getIsAccept();

        addBuddyAskResponsePacket.setIsAccept(isAccept);
        addBuddyAskResponsePacket.setMessage(addBuddyAskRequestPacket.getMessage());
        addBuddyAskResponsePacket.setAccepterName(addBuddyAskRequestPacket.getAccepterName());
        addBuddyAskResponsePacket.setSenderName(addBuddyAskRequestPacket.getSenderName());

        if (isAccept){
            // todo 双方添加好友数据库
        } else {
            System.out.println("拒绝添加好友");
        }
        channelHandlerContext.channel().writeAndFlush(addBuddyAskResponsePacket);

    }
}
