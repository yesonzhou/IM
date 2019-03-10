package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.protocol.packet.request.AddBuddyRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by y_s on 2019/3/10 9:17 AM
 */

public class AddBuddyConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("【添加好友】输入 userId ：");
        String buddyId = scanner.next();

        AddBuddyRequestPacket addBuddyRequestPacket = new AddBuddyRequestPacket();
        addBuddyRequestPacket.setBuddyId(buddyId);
        channel.writeAndFlush(addBuddyRequestPacket);
    }
}
