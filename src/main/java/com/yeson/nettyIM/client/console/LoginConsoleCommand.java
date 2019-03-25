package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.protocol.packet.request.LoginRequestPacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.Channel;

import java.util.Scanner;

public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        LogUtils.p("输入用户名: ");
        loginRequestPacket.setUserName(scanner.next());
        LogUtils.p("输入密码: ");
        loginRequestPacket.setPassword(scanner.next());

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
