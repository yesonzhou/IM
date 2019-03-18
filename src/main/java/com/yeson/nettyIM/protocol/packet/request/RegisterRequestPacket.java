package com.yeson.nettyIM.protocol.packet.request;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;
import lombok.Data;

@Data
public class RegisterRequestPacket extends Packet {

    private String userName;
    private String password;

    public RegisterRequestPacket(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Byte getCommand() {
        return Command.REGISTER_REQUEST;
    }
}
