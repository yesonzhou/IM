package com.szu.nettyIM.client.handler;

import com.szu.nettyIM.protocol.packet.response.AddBuddyAskPacketToUser;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by y_s on 2019/4/11 7:55 PM
 */

public class AddBuddyAskResponseHandler extends SimpleChannelInboundHandler<AddBuddyAskPacketToUser> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddBuddyAskPacketToUser addBuddyAskPacketToUser) throws Exception {
        // 用户添加成功

        // 用户添加失败
    }
}
