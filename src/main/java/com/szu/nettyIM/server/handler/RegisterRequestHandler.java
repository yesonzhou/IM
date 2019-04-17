package com.szu.nettyIM.server.handler;

import com.alibaba.fastjson.JSONObject;
import com.szu.nettyIM.protocol.packet.request.RegisterRequestPacket;
import com.szu.nettyIM.protocol.packet.response.RegisterResponsePacket;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.constant.Constant;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RegisterRequestHandler extends SimpleChannelInboundHandler<RegisterRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterRequestPacket registerRequestPacket) throws Exception {
        // 用户注册信息
        String userName = registerRequestPacket.getUserName();
        String password = registerRequestPacket.getPassword();

        // 添加用户
        JSONObject json = new JSONObject();
        json.put("password",password);
        Boolean isIDExist = ElasticsearchUtils.isIDExist(Constant.INDEX_User,Constant.TYPE_REGISTER,userName);

        // 校验
        RegisterResponsePacket registerResponsePacket = new RegisterResponsePacket();
        if (!isIDExist){
            ElasticsearchUtils.addData(json,Constant.INDEX_User,Constant.TYPE_REGISTER,userName);
            registerResponsePacket.setOk(true);
            registerResponsePacket.setMessage("注册成功");
        } else {
            registerResponsePacket.setOk(false);
            registerResponsePacket.setMessage("用户id已经存在");
        }

        // 返回
        channelHandlerContext.channel().writeAndFlush(registerResponsePacket);
    }
}
