package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.protocol.packet.request.RegisterRequestPacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.Channel;

import java.util.Scanner;

public class RegisterConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogUtils.p("输入待注册的用户名：");
        String userName = scanner.next();
        LogUtils.p("输入密码：");
        String password1 = scanner.next();
        LogUtils.p("再次输入密码：");
        String password2 = scanner.next();

        if (password1.equals(password2)) {
            RegisterRequestPacket packet =
                    new RegisterRequestPacket(userName, password1);
            channel.writeAndFlush(packet);
        } else {
            LogUtils.p("两次密码输入不一致");
        }

    }
}
