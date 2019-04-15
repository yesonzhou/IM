package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.bean.Group;
import com.szu.nettyIM.bean.User;
import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import com.szu.nettyIM.server.handler.constant.Constant;

/**
 * Created by y_s on 2019/4/13 1:57 PM
 */

public class GroupMessageResponsePacket extends Packet {
    Group group;
    User speakerName;
    String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
