package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.packet.Packet;
import com.szu.nettyIM.protocol.command.Command;
import lombok.Data;


@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return Command.LOGOUT_RESPONSE;
    }
}
