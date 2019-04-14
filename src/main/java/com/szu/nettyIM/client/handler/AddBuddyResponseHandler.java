package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.request.AddBuddyAskRequestPacket;
import com.szu.nettyIM.protocol.packet.response.AddBuddyResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Scanner;

/**
 * Created by y_s on 2019/4/11 7:52 PM
 */

public class AddBuddyResponseHandler extends SimpleChannelInboundHandler<AddBuddyResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyResponsePacket addBuddyResponsePacket) throws Exception {
        String fromUserName = addBuddyResponsePacket.getSenderName();
        String accepter = addBuddyResponsePacket.getAcceptName();
        String message = addBuddyResponsePacket.getMessage();


        Scanner scanner = new Scanner(System.in);
        System.out.println(fromUserName + "发起好友请求\n备注：" +
                message
                + "\n同意回复1，否则拒绝 : ");
        String isAccept = scanner.next();
        System.out.println("发送内容 ： ");
        String responseMess = scanner.next();

        AddBuddyAskRequestPacket addBuddyAskRequestPacket = new AddBuddyAskRequestPacket();
        addBuddyAskRequestPacket.setSenderName(fromUserName);
        addBuddyAskRequestPacket.setAccepterName(accepter);
        addBuddyAskRequestPacket.setMessage(responseMess);

        if ("1".equals(scanner.next().trim())){
            // 同意添加好友
            addBuddyAskRequestPacket.setIsAccept(true);
        } else {
            addBuddyAskRequestPacket.setIsAccept(false);
        }

        channelHandlerContext.channel().writeAndFlush(addBuddyAskRequestPacket);
    }
}
