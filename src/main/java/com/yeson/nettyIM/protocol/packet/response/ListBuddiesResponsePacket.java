package com.yeson.nettyIM.protocol.packet.response;

import com.yeson.nettyIM.bean.Buddy;
import com.yeson.nettyIM.protocol.command.Command;
import com.yeson.nettyIM.protocol.packet.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ListBuddiesResponsePacket extends Packet {

    private List<Buddy> buddies;

    public ListBuddiesResponsePacket(List<Buddy> buddies) {
        this.buddies = buddies;
    }

    public void addBuddy(Buddy buddy) {
        if (buddy == null)
            return;
        if (buddies == null)
            buddies = new ArrayList<>();
        buddies.add(buddy);
    }

    @Override
    public Byte getCommand() {
        return Command.LIST_BUDDIES_RESPONSE;
    }
}
