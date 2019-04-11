package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by y_s on 2019/3/10 9:35 AM
 */

@Data
public class AddBuddyResponsePacket extends Packet {
    Boolean isOk;
    String message;

    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_RESPONSE;
    }
}
