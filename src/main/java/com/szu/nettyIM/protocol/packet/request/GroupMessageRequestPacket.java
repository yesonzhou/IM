package com.szu.nettyIM.protocol.packet.request;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;

/**
 * Created by y_s on 2019/4/13 1:55 PM
 */

public class GroupMessageRequestPacket extends Packet {
    String groupId;
    String speakerUserName;
    String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}
