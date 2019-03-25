package com.yeson.nettyIM.protocol.packet.response;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by y_s on 2019/3/10 9:39 AM
 */

@Data
public class AddBuddyAskResponsePacket extends Packet {

    private String senderUsername;
    private boolean isAccept;

    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_ASK_RESPONSE;
    }
}
