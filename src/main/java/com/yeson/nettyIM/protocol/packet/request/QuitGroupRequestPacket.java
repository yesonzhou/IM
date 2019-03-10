package com.yeson.nettyIM.protocol.packet.request;

import com.yeson.nettyIM.protocol.packet.Packet;
import com.yeson.nettyIM.protocol.command.Command;
import lombok.Data;


@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return Command.QUIT_GROUP_REQUEST;
    }
}
