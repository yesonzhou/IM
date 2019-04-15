package com.szu.nettyIM.client.console;

import com.szu.nettyIM.protocol.packet.request.AddBuddyAskRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by y_s on 2019/3/10 9:42 AM
 */

public class AddBuddyAskConsole implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("是否添加为好友：");
        boolean isAccept = scanner.nextBoolean();
        AddBuddyAskRequestPacket addBuddyAskRequestPacket = new AddBuddyAskRequestPacket();
        addBuddyAskRequestPacket.setIsAccept(isAccept);

        channel.writeAndFlush(addBuddyAskRequestPacket);
    }
}
