package com.yeson.nettyIM.client.handler;

import com.yeson.nettyIM.protocol.packet.response.RegisterResponsePacket;
import com.yeson.nettyIM.util.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RegisterResponseHandler extends SimpleChannelInboundHandler<RegisterResponsePacket> {

    private static final String TAG = RegisterResponseHandler.class.getName();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                RegisterResponsePacket registerResponsePacket) throws Exception {
        LogUtils.p(TAG, "服务器返回信息：" + registerResponsePacket.getMessage());
    }
}
