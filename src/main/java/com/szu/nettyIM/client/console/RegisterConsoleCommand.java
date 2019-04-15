package com.szu.nettyIM.client.console;

import com.szu.nettyIM.protocol.packet.request.RegisterRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

public class RegisterConsoleCommand  implements ConsoleCommand  {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        RegisterRequestPacket packet = new RegisterRequestPacket("test", "123456");
        channel.writeAndFlush(packet);
    }
}
