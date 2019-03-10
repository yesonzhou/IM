package com.yeson.nettyIM.protocol.packet.response;

import com.yeson.nettyIM.protocol.packet.Packet;
import com.yeson.nettyIM.protocol.command.Command;
import lombok.Data;


@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return Command.MESSAGE_RESPONSE;
    }
}
