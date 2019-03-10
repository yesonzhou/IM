package com.yeson.nettyIM.protocol.packet.response;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;

/**
 * Created by y_s on 2019/3/10 9:39 AM
 */

public class AddBuddyAskResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_ASK_RESPONSE;
    }
}