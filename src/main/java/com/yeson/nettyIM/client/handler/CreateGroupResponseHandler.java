package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.protocol.packet.response.CreateGroupResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CreateGroupResponseHandler extends
        SimpleChannelInboundHandler<CreateGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket createGroupResponsePacket) {
        LogUtils.p("群创建成功，id 为[" + createGroupResponsePacket.getGroupId());
        LogUtils.p("群成员列表："+ createGroupResponsePacket.getUserNameList());
    }
}
