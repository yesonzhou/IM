package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.protocol.packet.request.AddBuddyRequestPacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by y_s on 2019/3/10 9:17 AM
 */

public class AddBuddyConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogUtils.p("【添加好友】输入 userId ：");
        String buddyId = scanner.next();

        AddBuddyRequestPacket addBuddyRequestPacket = new AddBuddyRequestPacket();
        addBuddyRequestPacket.setBuddyName(buddyId);
        channel.writeAndFlush(addBuddyRequestPacket);
    }
}
