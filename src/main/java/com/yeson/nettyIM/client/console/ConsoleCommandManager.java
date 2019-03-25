package com.yeson.nettyIM.client.console;

import com.yeson.nettyIM.util.LogUtils;
import com.yeson.nettyIM.util.SessionUtil;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("help", new HelpConsoleCommand());//输出所有指令名方便输入
        consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
        consoleCommandMap.put("joinGroup", new JoinGroupConsoleCommand());
        consoleCommandMap.put("quitGroup", new QuitGroupConsoleCommand());
        consoleCommandMap.put("listGroupMembers", new ListGroupMembersConsoleCommand());
        consoleCommandMap.put("addBuddy", new AddBuddyConsoleCommand());
        consoleCommandMap.put("addBuddyAsk", new AddBuddyAskConsoleCommand());
        consoleCommandMap.put("register", new RegisterConsoleCommand());
        consoleCommandMap.put("listBuddies", new ListBuddiesConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        //  获取第一个指令
        String command = scanner.next();

        if (!SessionUtil.hasLogin(channel)) {
            return;
        }

        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
            LogUtils.p("命令[" + command + "]已执行");
        } else {
            LogUtils.p("无法识别[" + command + "]指令，请重新输入!");
        }
    }

    private class HelpConsoleCommand implements ConsoleCommand {

        @Override
        public void exec(Scanner scanner, Channel channel) {
            System.out.println("系统支持指令表：");
            for (String command : consoleCommandMap.keySet()) {
                System.out.println("["+command+"]");
            }
        }
    }
}
