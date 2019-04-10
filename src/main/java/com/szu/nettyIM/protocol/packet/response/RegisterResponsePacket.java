package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import lombok.Data;

@Data
public class RegisterResponsePacket extends Packet {

    private boolean isOk;
    private String message;

    public RegisterResponsePacket(){}


    public RegisterResponsePacket(boolean isOk, String message) {
        this.isOk = isOk;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.REGISTER_RESPONSE;
    }
}
