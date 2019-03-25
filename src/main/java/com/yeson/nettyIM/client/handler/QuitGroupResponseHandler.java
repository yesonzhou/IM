package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.protocol.packet.response.QuitGroupResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket responsePacket) {
        if (responsePacket.isSuccess()) {
            LogUtils.p("退出群聊[" + responsePacket.getGroupId() + "]成功！");
        } else {
            LogUtils.p("退出群聊[" + responsePacket.getGroupId() + "]失败！");
        }

    }
}
