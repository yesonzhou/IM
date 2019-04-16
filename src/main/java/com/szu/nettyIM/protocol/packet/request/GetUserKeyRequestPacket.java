package com.szu.nettyIM.protocol.packet.request;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by Richard.Fu on 2019/4/15
 */
@Data
public class GetUserKeyRequestPacket extends Packet {

    private String userName;

    @Override
    public Byte getCommand() {
        return Command.GET_USER_KEY_REQUEST;
    }
}
