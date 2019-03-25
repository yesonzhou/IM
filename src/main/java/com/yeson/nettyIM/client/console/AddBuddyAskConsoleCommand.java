package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.protocol.packet.request.AddBuddyAskRequestPacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by y_s on 2019/3/10 9:42 AM
 */

public class AddBuddyAskConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogUtils.p("是否同意好友请求？");
        boolean isAccept = scanner.nextBoolean();
        AddBuddyAskRequestPacket addBuddyAskRequestPacket = new AddBuddyAskRequestPacket();
        LogUtils.p("输入接收者用户名：");
        String userName = scanner.next();
        addBuddyAskRequestPacket.setReceiverUserName(userName);
        addBuddyAskRequestPacket.setIsAccept(isAccept);

        channel.writeAndFlush(addBuddyAskRequestPacket);
    }
}
