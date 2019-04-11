package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.AddBuddyRequestPacket;
import com.szu.nettyIM.protocol.packet.response.AddBuddyAskResponsePacket;
import com.szu.nettyIM.protocol.packet.response.AddBuddyResponsePacket;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.constant.Constant;
import com.szu.nettyIM.session.Session;
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
        String uid = addBuddyRequestPacket.getBuddyId();

        AddBuddyResponsePacket addBuddyResponsePacket = new AddBuddyResponsePacket();

        // 查询数据库，判断是否有效用户
        Boolean isExist = ElasticsearchUtils.isIDExist(Constant.INDEX_User,Constant.TYPE_REGISTER,uid);
        if (isExist){
            addBuddyResponsePacket.setIsOk(true);

            // todo 发送给登录用户
            Channel buddyChannel = SessionUtil.getChannel(addBuddyRequestPacket.getBuddyId());
            if (SessionUtil.hasLogin(buddyChannel)){

            }




            addBuddyResponsePacket.setMessage("发送完成");
        } else {
            System.err.println(uid + "用户不存在");
        }

//        channelHandlerContext.channel().writeAndFlush(addBuddyResponsePacket);


    }
}
