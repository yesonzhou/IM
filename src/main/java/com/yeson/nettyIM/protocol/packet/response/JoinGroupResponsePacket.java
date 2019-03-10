package com.yeson.nettyIM.protocol.packet.response;

import com.yeson.nettyIM.protocol.packet.Packet;
import com.yeson.nettyIM.protocol.command.Command;
import lombok.Data;


@Data
public class JoinGroupResponsePacket extends Packet {
    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return Command.JOIN_GROUP_RESPONSE;
    }
}
