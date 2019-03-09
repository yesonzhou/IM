package com.yeson.nettyIM.protocol.response;

import com.yeson.nettyIM.protocol.Packet;
import com.yeson.nettyIM.protocol.command.Command;
import lombok.Data;
import java.util.List;


@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {

        return Command.CREATE_GROUP_RESPONSE;
    }
}
