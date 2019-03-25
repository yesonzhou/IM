package com.yeson.nettyIM.protocol.packet.response;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by y_s on 2019/3/10 9:35 AM
 */

@Data
public class AddBuddyResponsePacket extends Packet {

    private String fromUserName;

    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_RESPONSE;
    }
}
