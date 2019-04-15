package com.szu.nettyIM.client.console;

import com.szu.nettyIM.protocol.packet.request.ListBuddiesRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

public class ListBuddiesConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListBuddiesRequestPacket packet = new ListBuddiesRequestPacket("test");
        channel.writeAndFlush(packet);
    }
}
