package com.yeson.nettyIM.protocol.response;

import com.yeson.nettyIM.protocol.Packet;
import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.session.Session;
import lombok.Data;

import java.util.List;


@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
