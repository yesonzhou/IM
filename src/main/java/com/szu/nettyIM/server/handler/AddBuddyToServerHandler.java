package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.AddBuddyPacketToServer;
import com.szu.nettyIM.protocol.packet.response.AddBuddyAskPacketToUser;
import com.szu.nettyIM.protocol.packet.response.AddBuddyPacketToUser;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.constant.Constant;
import com.szu.nettyIM.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:46 PM
 */

public class AddBuddyToServerHandler extends SimpleChannelInboundHandler<AddBuddyPacketToServer> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyPacketToServer addBuddyPacketToServer) throws Exception {

        String sender = addBuddyPacketToServer.getUserName();
        String accepter = addBuddyPacketToServer.getBuddyUserName();
        String message = addBuddyPacketToServer.getMessage();

        // 查询数据库，判断是否有效用户
        Boolean isExist = ElasticsearchUtils.isIDExist(Constant.INDEX_User
                , Constant.TYPE_REGISTER, accepter);
        if (isExist) {
            // 构建转发包转发给好友请求中的目标好友
            AddBuddyPacketToUser transPacket = new AddBuddyPacketToUser();
            transPacket.setSenderName(sender);
            transPacket.setMessage(message);
            Channel buddyChannel = SessionUtil.getChannel(accepter);
            if (SessionUtil.hasLogin(buddyChannel)) {
                buddyChannel.writeAndFlush(transPacket);
            } else {
                // todo 发送给未登录登录用户
                AddBuddyAskPacketToUser responsePacket = new AddBuddyAskPacketToUser();
                responsePacket.setError("用户不在线");
            }
        } else {
            AddBuddyAskPacketToUser responsePacket = new AddBuddyAskPacketToUser();
            responsePacket.setError("用户不存在");
            System.err.println(accepter + "用户不存在");
        }
    }
}
