package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by y_s on 2019/3/10 9:39 AM
 */

@Data
public class AddBuddyAskResponsePacket extends Packet {
    private Boolean isAccept;
    private String accepterName;
    private String senderName;
    private String message;
    private String error;

    @Override
    public Byte getCommand() {
        return Command.ADD_BUDDY_ASK_RESPONSE;
    }
}