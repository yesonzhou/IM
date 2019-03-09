package com.yeson.nettyIM.protocol.request;

import com.yeson.nettyIM.protocol.Packet;
import com.yeson.nettyIM.protocol.command.Command;
import lombok.Data;
import java.util.List;


@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return Command.CREATE_GROUP_REQUEST;
    }
}
