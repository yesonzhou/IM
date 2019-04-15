package com.szu.nettyIM.server.handler;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.szu.nettyIM.protocol.packet.request.AddBuddyAskRequestPacket;
import com.szu.nettyIM.protocol.packet.response.AddBuddyAskResponsePacket;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.constant.Constant;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Collections;
import java.util.List;

/**
 * Created by y_s on 2019/4/11 7:57 PM
 */

public class AddBuddyAskRequestHandler extends SimpleChannelInboundHandler<AddBuddyAskRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyAskRequestPacket addBuddyAskRequestPacket) throws Exception {
        AddBuddyAskResponsePacket addBuddyAskResponsePacket = new AddBuddyAskResponsePacket();

        Boolean isAccept = addBuddyAskRequestPacket.getIsAccept();
        String sender = addBuddyAskRequestPacket.getSenderName();
        String accepter = addBuddyAskRequestPacket.getAccepterName();

        addBuddyAskResponsePacket.setIsAccept(isAccept);
        addBuddyAskResponsePacket.setMessage(addBuddyAskRequestPacket.getMessage());
        addBuddyAskResponsePacket.setAccepterName(addBuddyAskRequestPacket.getAccepterName());
        addBuddyAskResponsePacket.setSenderName(addBuddyAskRequestPacket.getSenderName());

        if (isAccept){
            addBuddies(sender,accepter);
            addBuddies(accepter,sender);
        } else {
            System.out.println("拒绝添加好友");
        }
        channelHandlerContext.channel().writeAndFlush(addBuddyAskResponsePacket);

    }

    private void addBuddies(String userName,String addUser){
        JSONObject json = new JSONObject();
        json.put(addUser,"基本数据");
        ElasticsearchUtils.addData(json,Constant.INDEX_User
        ,Constant.TYPE_BUDDIES
        ,userName);

    }

}
