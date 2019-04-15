package com.szu.nettyIM.client.console;

import com.szu.nettyIM.protocol.packet.request.MessageRequestPacket;
import io.netty.channel.Channel;
import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给用户名：");
        String toUserId = scanner.next();
        System.out.print("发送消息：");
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
