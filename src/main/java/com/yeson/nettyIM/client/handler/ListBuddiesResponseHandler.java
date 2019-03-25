package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.bean.Buddy;
import com.yeson.nettyIM.bean.Group;
import com.yeson.nettyIM.protocol.packet.response.ListBuddiesResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

public class ListBuddiesResponseHandler extends SimpleChannelInboundHandler<ListBuddiesResponsePacket> {

    private static final String TAG = ListBuddiesResponseHandler.class.getName();

    private static final String TYPE_GROUP = "【Group】";
    private static final String TYPE_USER = "【User】";

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                ListBuddiesResponsePacket listBuddiesResponsePacket) throws Exception {
        List<Buddy> buddies = listBuddiesResponsePacket.getBuddies();
        StringBuilder sb = new StringBuilder();
        sb.append("用户的好友列表\n");
        for (Buddy buddy : buddies) {
            sb.append(getBuddyType(buddy))
                    .append(buddy.getName())
                    .append("\n");
        }
        LogUtils.p(TAG, sb.toString());
    }

    private String getBuddyType(Buddy buddy) {
        if (buddy instanceof Group) {
            return TYPE_GROUP;
        } else {
            return TYPE_USER;
        }
    }
}
