package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.request.AddBuddyAskPacketToServer;
import com.szu.nettyIM.protocol.packet.response.AddBuddyPacketToUser;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Scanner;

/**
 * Created by y_s on 2019/4/11 7:52 PM
 */

public class AddBuddyResponseHandler extends SimpleChannelInboundHandler<AddBuddyPacketToUser> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyPacketToUser addBuddyPacketToUser) throws Exception {
        String fromUserName = addBuddyPacketToUser.getSenderName();
        String accepter = addBuddyPacketToUser.getAcceptName();
        String message = addBuddyPacketToUser.getMessage();


        Scanner scanner = new Scanner(System.in);
        System.out.println(fromUserName + "发起好友请求\n备注：" +
                message
                + "\n同意回复1，否则拒绝 : ");
        String isAccept = scanner.next();
        System.out.println("发送内容 ： ");
        String responseMess = scanner.next();

        AddBuddyAskPacketToServer addBuddyAskPacketToServer = new AddBuddyAskPacketToServer();
        addBuddyAskPacketToServer.setUserNameWaitAsk(fromUserName);
        addBuddyAskPacketToServer.setUserNameAsk(accepter);
        addBuddyAskPacketToServer.setMessage(responseMess);

        if ("1".equals(scanner.next().trim())){
            // 同意添加好友
            addBuddyAskPacketToServer.setIsAccept(true);
        } else {
            addBuddyAskPacketToServer.setIsAccept(false);
        }

        channelHandlerContext.channel().writeAndFlush(addBuddyAskPacketToServer);
    }
}
