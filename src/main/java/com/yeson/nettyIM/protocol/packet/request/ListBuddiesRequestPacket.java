package com.yeson.nettyIM.protocol.packet.request;

import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;
import lombok.Data;

@Data
public class ListBuddiesRequestPacket extends Packet {

    private String userName;//查找该userName的好友

    public ListBuddiesRequestPacket(String userName) {
        this.userName = userName;
    }

    @Override
    public Byte getCommand() {
        return Command.LIST_BUDDIES_REQUEST;
    }
}
