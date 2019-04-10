package com.szu.nettyIM.client.console;

import com.szu.nettyIM.protocol.packet.request.LoginRequestPacket;
import io.netty.channel.Channel;
import java.util.Scanner;

public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        System.out.print("输入用户名登录: ");
        loginRequestPacket.setUserName(scanner.nextLine());

        System.out.print("输入用户名密码: ");
        loginRequestPacket.setPassword(scanner.nextLine());

        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
