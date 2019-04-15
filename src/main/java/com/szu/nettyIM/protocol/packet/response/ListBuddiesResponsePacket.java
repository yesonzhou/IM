package com.szu.nettyIM.protocol.packet.response;

import com.szu.nettyIM.bean.Buddy;
import com.szu.nettyIM.protocol.command.Command;
import com.szu.nettyIM.protocol.packet.Packet;
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
