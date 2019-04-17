package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by Richard.Fu on 2019/4/15
 */
@Data
public class SetUserKeyResponsePacket extends Packet {

    private boolean isOk;

    @Override
    public Byte getCommand() {
        return Command.SET_USER_KEY_RESPONSE;
    }
}
