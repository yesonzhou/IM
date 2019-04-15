package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.protocol.packet.Packet;
import com.szu.nettyIM.protocol.command.Command;
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
