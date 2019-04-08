package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.MessageRequestPacket;
import com.szu.nettyIM.protocol.packet.response.MessageResponsePacket;
import com.szu.nettyIM.session.Session;
import com.szu.nettyIM.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) {
        // 1.拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());

        // 2.通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());

        //todo:需要重新实现

        /*// 3.拿到消息接收方的 channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

        // 4.将消息发送给消息接收方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!");
        }*/
    }
}