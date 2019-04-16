package com.szu.nettyIM.server.handler;

import com.szu.nettyIM.bean.Buddy;
import com.szu.nettyIM.protocol.packet.request.ListBuddiesRequestPacket;
import com.szu.nettyIM.protocol.packet.response.ListBuddiesResponsePacket;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.constant.Constant;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ListBuddiesRequestHandler extends SimpleChannelInboundHandler<ListBuddiesRequestPacket> {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListBuddiesRequestPacket listBuddiesRequestPacket) throws Exception {
        String uid = listBuddiesRequestPacket.getUserName();

        // 查询uid的好友列表
        Map<String,Object> strBuddies = ElasticsearchUtils.searchDataById(Constant.INDEX_User,Constant.TYPE_BUDDIES,uid,Constant.FIELD_USERNAME);

        // 装包
        List<Buddy> buddies = new ArrayList<>();
        for (String buddy : strBuddies.keySet()){

            buddies.add(new Buddy(buddy));
        }
        ListBuddiesResponsePacket lbrp = new ListBuddiesResponsePacket(buddies);

        ctx.channel().writeAndFlush(lbrp);
    }

}
