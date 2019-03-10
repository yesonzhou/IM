package com.yeson.nettyIM.protocol.packet.request;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by y_s on 2019/3/10 9:38 AM
 */

@Data
public class AddBuddyAskRequestPacket extends Packet {
    private Boolean isAccept;
    private String otherUid;

    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_ASK_REQUEST;
    }
}
