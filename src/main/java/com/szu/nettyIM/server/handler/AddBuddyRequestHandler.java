package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.AddBuddyRequestPacket;
import com.szu.nettyIM.protocol.packet.response.AddBuddyAskResponsePacket;
import com.szu.nettyIM.protocol.packet.response.AddBuddyResponsePacket;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.constant.Constant;
import com.szu.nettyIM.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:46 PM
 */

public class AddBuddyRequestHandler extends SimpleChannelInboundHandler<AddBuddyRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyRequestPacket addBuddyRequestPacket) throws Exception {
        String sender = addBuddyRequestPacket.getUserName();
        String accepter = addBuddyRequestPacket.getBuddyUserName();
        String message = addBuddyRequestPacket.getMessage();

        AddBuddyResponsePacket addBuddyResponsePacket = new AddBuddyResponsePacket();

        // 查询数据库，判断是否有效用户
        Boolean isExist = ElasticsearchUtils.isIDExist(Constant.INDEX_User
                ,Constant.TYPE_REGISTER,accepter);
        if (isExist){
            addBuddyResponsePacket.setSenderName(sender);
            addBuddyResponsePacket.setMessage(message);
            Channel buddyChannel = SessionUtil.getChannel(accepter);
            if (SessionUtil.hasLogin(buddyChannel)){
                buddyChannel.writeAndFlush(addBuddyRequestPacket);
            }

            // todo 发送给未登录登录用户
            addBuddyResponsePacket.setMessage("发送完成");
        } else {
            AddBuddyAskResponsePacket abar = new AddBuddyAskResponsePacket();
            abar.setError("用户不存在");
            System.err.println(accepter + "用户不存在");
        }

        channelHandlerContext.channel().writeAndFlush(addBuddyResponsePacket);
    }
}
