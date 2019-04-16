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

        AddBuddyAskPacketToUser addBuddyAskPacketToUser = new AddBuddyAskPacketToUser();
        addBuddyAskPacketToUser.setIsAccept(isAccept);
        addBuddyAskPacketToUser.setMessage(addBuddyAskPacketToServer.getMessage());
        addBuddyAskPacketToUser.setUserNameAsk(userNameAsk);
        addBuddyAskPacketToUser.setUserNameWaitAsk(userNameWaitAsk);

        System.out.println("接收到返回数据");

        if (isAccept) {
            System.out.println("添加好友");
            addBuddies(userNameWaitAsk, userNameAsk);
            addBuddies(userNameAsk, userNameWaitAsk);
        } else {
            System.out.println("拒绝添加好友");
        }

        //转发包给等待回应的用户
        Channel targetChannel = SessionUtil.getChannel(userNameAsk);
        if (SessionUtil.hasLogin(targetChannel)) {
            targetChannel.writeAndFlush(addBuddyAskPacketToUser);
        } else {
            //todo 发给不在线的用户
            System.out.println("用户不在线");
        }
    }


    private void addBuddies(String userName, String addUser) {
        JSONObject json = new JSONObject();
        json.put(addUser, "基本数据");
        ElasticsearchUtils.addData(json, Constant.INDEX_User
                , Constant.TYPE_BUDDIES
                , userName);
    }
}
