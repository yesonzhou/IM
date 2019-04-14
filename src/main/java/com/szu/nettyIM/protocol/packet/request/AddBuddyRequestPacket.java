package com.szu.nettyIM.protocol.packet.request;

import com.szu.nettyIM.protocol.packet.Packet;
import com.szu.nettyIM.protocol.command.Command;
import lombok.Data;

/**
 * Created by y_s on 2019/3/10 9:23 AM
 */

@Data
public class AddBuddyRequestPacket extends Packet {
    String userName;
    String buddyUserName;
    String message;

    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_REQUEST;
    }
}
