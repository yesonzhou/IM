package com.szu.nettyIM.protocol.packet.request;

import com.szu.nettyIM.protocol.packet.Packet;
import com.szu.nettyIM.protocol.command.Command;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String toUserName;
    private String message;

    public MessageRequestPacket(String toUserName, String message) {
        this.toUserName = toUserName;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
