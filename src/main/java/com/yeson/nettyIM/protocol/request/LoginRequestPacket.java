package com.yeson.nettyIM.protocol.request;


import com.yeson.nettyIM.protocol.Packet;
import com.yeson.nettyIM.protocol.command.Command;
import lombok.Data;

/**
 * Created by y_s on 2019/3/5 1:14 PM
 */

@Data
public class LoginRequestPacket extends Packet {
    private String userName;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
