package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.protocol.packet.request.MessageRequestPacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.Channel;

import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogUtils.p("输入接受方用户名：");
        String toUserId = scanner.next();
        LogUtils.p("输入消息：");
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
