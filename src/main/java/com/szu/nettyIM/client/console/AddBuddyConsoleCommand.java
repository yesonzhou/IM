package com.szu.nettyIM.client.console;

import com.szu.nettyIM.protocol.packet.request.AddBuddyPacketToServer;
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
        System.out.println("【添加好友】输入备注 ：");
        String message = scanner.next();

        AddBuddyPacketToServer addBuddyPacketToServer = new AddBuddyPacketToServer();
        addBuddyPacketToServer.setUserName(buddyId);
        addBuddyPacketToServer.setMessage(message);
        channel.writeAndFlush(addBuddyPacketToServer);
    }
}
