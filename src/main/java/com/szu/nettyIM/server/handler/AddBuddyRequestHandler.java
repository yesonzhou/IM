package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.protocol.packet.request.AddBuddyRequestPacket;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:46 PM
 */

public class AddBuddyRequestHandler extends SimpleChannelInboundHandler<AddBuddyRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyRequestPacket addBuddyRequestPacket) throws Exception {
        String uid = addBuddyRequestPacket.getBuddyId();

//        ElasticsearchUtils.isIDExist()


    }
}
