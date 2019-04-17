package com.szu.nettyIM.protocol.packet.request;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import lombok.Data;

/**
 * Created by Richard.Fu on 2019/4/15
 */
@Data
public class GetServerKeyRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.GET_SERVER_KEY_REQUEST;
    }
}
