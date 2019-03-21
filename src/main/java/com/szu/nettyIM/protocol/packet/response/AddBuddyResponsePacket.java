package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;

/**
 * Created by y_s on 2019/3/10 9:35 AM
 */

public class AddBuddyResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_RESPONSE;
    }
}
