package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.SetUserKeyRequestPacket;
import com.szu.nettyIM.protocol.packet.response.SetUserKeyResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Richard.Fu on 2019/4/15
 */
public class SetUserKeyRequestHandler extends
        SimpleChannelInboundHandler<SetUserKeyRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                SetUserKeyRequestPacket packet) throws Exception {
        String userName = packet.getUserName();
        String publicKey = packet.getPublicKeyBase64();

        //todo:将name-公钥插入表中

        SetUserKeyResponsePacket responsePacket = new SetUserKeyResponsePacket();
        responsePacket.setOk(true);
        channelHandlerContext.channel().writeAndFlush(responsePacket);
    }
}
