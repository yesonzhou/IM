package com.szu.nettyIM.protocol.packet.response;

/**
 * Created by y_s on 2019/3/5 1:16 PM
 */

import com.szu.nettyIM.protocol.packet.Packet;
import com.szu.nettyIM.protocol.command.Command;
import lombok.Data;

@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return Command.LOGIN_RESPONSE;
    }
}
