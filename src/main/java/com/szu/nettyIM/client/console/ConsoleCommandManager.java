package com.szu.nettyIM.client.console;

import com.szu.nettyIM.util.SessionUtil;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        // 1.注册、登录、退出模块
        consoleCommandMap.put("register", new RegisterConsoleCommand());
        consoleCommandMap.put("logon", new LogonConsoleCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("listBuddies", new ListBuddiesConsoleCommand());
        // 2.添加好友模块
        consoleCommandMap.put("addBuddy", new AddBuddyConsoleCommand());
        consoleCommandMap.put("addBuddyAsk", new AddBuddyAskConsole());
        consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
        // 3.群用户功能模块
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
        consoleCommandMap.put("joinGroup", new JoinGroupConsoleCommand());
        consoleCommandMap.put("sendToGroup", new SendToGroupConsoleCommand());
        consoleCommandMap.put("quitGroup", new QuitGroupConsoleCommand());
        consoleCommandMap.put("listGroupMembers", new ListGroupMembersConsoleCommand());
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
        } else {
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }
}
