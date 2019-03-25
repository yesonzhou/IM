package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.protocol.packet.response.JoinGroupResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket responsePacket) {
        if (responsePacket.isSuccess()) {
            LogUtils.p("加入群[" + responsePacket.getGroupId() + "]成功!");
        } else {
            LogUtils.p("加入群[" + responsePacket.getGroupId() + "]失败，原因为：" + responsePacket.getReason());
        }
    }
}
