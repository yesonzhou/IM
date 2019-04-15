package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/13 1:46 PM
 */

public class MessageResponseErrorPacket extends Packet {
    String accepter;
    String error;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_ERROR_RESPONSE;
    }
}
