package com.yeson.nettyIM.protocol.packet.request;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;

/**
 * Created by y_s on 2019/3/10 7:47 PM
 */

public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_REQUEST;
    }
}
