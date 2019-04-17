package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.GetUserKeyRequestPacket;
import com.szu.nettyIM.protocol.packet.response.GetUserKeyResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Richard.Fu on 2019/4/15
 */
public class GetUserKeyRequestHandler extends
        SimpleChannelInboundHandler<GetUserKeyRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                GetUserKeyRequestPacket packet) throws Exception {
        String userName = packet.getUserName();

        //todo:从数据库中查询username对应的公钥
        String publicKey = "";

        GetUserKeyResponsePacket responsePacket = new GetUserKeyResponsePacket();
        responsePacket.setOK(true);
        responsePacket.setUserNameHoldKey(userName);
        responsePacket.setPublicKey(publicKey);

        channelHandlerContext.channel().writeAndFlush(responsePacket);
    }
}
