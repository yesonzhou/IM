package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;


/**
 * Created by y_s on 2019/3/22 1:23 PM
 */


public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}
