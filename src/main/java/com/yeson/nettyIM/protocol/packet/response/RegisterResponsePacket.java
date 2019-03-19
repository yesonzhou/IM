package com.yeson.nettyIM.protocol.packet.response;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;
import lombok.Data;

@Data
public class RegisterResponsePacket extends Packet {

    private boolean isOk;
    private String message;

    public RegisterResponsePacket(boolean isOk, String message) {
        this.isOk = isOk;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.REGISTER_RESPONSE;
    }
}
