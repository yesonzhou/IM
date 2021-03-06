package com.szu.nettyIM.server.handler;


import com.alibaba.fastjson.JSONObject;
import com.szu.nettyIM.protocol.packet.request.AddBuddyAskPacketToServer;
import com.szu.nettyIM.protocol.packet.response.AddBuddyAskPacketToUser;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.constant.Constant;
import com.szu.nettyIM.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by y_s on 2019/4/11 7:57 PM
 */

public class AddBuddyAskServerHandler extends
        SimpleChannelInboundHandler<AddBuddyAskPacketToServer> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                AddBuddyAskPacketToServer addBuddyAskPacketToServer) throws Exception {

        Boolean isAccept = addBuddyAskPacketToServer.getIsAccept();
        String userNameWaitAsk = addBuddyAskPacketToServer.getUserNameWaitAsk();
        String userNameAsk = addBuddyAskPacketToServer.getUserNameAsk();

        if (isAccept) {
            addBuddies(userNameWaitAsk, userNameAsk);
            addBuddies(userNameAsk, userNameWaitAsk);
        } else {
            System.out.println("拒绝添加好友");
        }

        Channel targetChannel = SessionUtil.getChannel(userNameWaitAsk);
        if (SessionUtil.hasLogin(targetChannel)) {
            //转发包给等待回应的用户
            AddBuddyAskPacketToUser addBuddyAskPacketToUser = new AddBuddyAskPacketToUser();
            addBuddyAskPacketToUser.setIsAccept(isAccept);
            addBuddyAskPacketToUser.setMessage(addBuddyAskPacketToServer.getMessage());
            addBuddyAskPacketToUser.setUserNameAsk(userNameAsk);
            addBuddyAskPacketToUser.setUserNameWaitAsk(userNameWaitAsk);
            targetChannel.writeAndFlush(addBuddyAskPacketToUser);

            //重要：交换参数回发给该包的发起者以更新数据
            addBuddyAskPacketToUser.setUserNameAsk(userNameWaitAsk);
            addBuddyAskPacketToUser.setUserNameWaitAsk(userNameAsk);
            channelHandlerContext.channel().writeAndFlush(addBuddyAskPacketToUser);
        } else {
            //todo 发给不在线的用户
            System.out.println("用户不在线");
        }
    }


    public static void addBuddies(String userName, String addUser) {
        // 查询好友列表
        Map<String,Object> strBuddies = ElasticsearchUtils
                .searchDataById(Constant.INDEX_User, Constant.TYPE_BUDDIES,
                        userName, null);

        // 如果为空
        if (null == strBuddies){
            strBuddies = new HashMap<String,Object>();
        }

        strBuddies.put(addUser,"基本数据");

        // 添加好友列表到数据库
        ElasticsearchUtils.addData(strBuddies, Constant.INDEX_User
                , Constant.TYPE_BUDDIES
                , userName);
    }
}
