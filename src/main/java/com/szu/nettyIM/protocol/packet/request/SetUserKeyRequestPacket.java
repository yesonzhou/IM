package com.szu.nettyIM.protocol.packet.request;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by Richard.Fu on 2019/4/15
 */
@Data
public class SetUserKeyRequestPacket extends Packet {

    private String userName;//发送者的Username
    private String publicKeyBase64;

    @Override
    public Byte getCommand() {
        return Command.SET_USER_KEY_REQUEST;
    }
}
