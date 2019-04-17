package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.GetServerKeyRequestPacket;
import com.szu.nettyIM.protocol.packet.response.GetServerKeyResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Richard.Fu on 2019/4/15
 */
public class GetServerKeyRequsetHandler extends
        SimpleChannelInboundHandler<GetServerKeyRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                GetServerKeyRequestPacket packet) throws Exception {
        //todo:从数据库中查询服务端的公钥
        String publicKey = "";

        GetServerKeyResponsePacket responsePacket = new GetServerKeyResponsePacket();
        responsePacket.setPublicKey(publicKey);
        channelHandlerContext.channel().writeAndFlush(publicKey);
    }
}
