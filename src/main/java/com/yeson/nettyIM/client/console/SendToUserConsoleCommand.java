package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.protocol.packet.request.MessageRequestPacket;
import io.netty.channel.Channel;
import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
