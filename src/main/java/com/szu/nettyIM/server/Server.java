package com.szu.nettyIM.server;

/**
 * The demo is created by yesonzhou on 2019/1/16 16:38
 * Note: ***
 */

import com.szu.nettyIM.codec.PacketDecoder;
import com.szu.nettyIM.codec.PacketEncoder;
import com.szu.nettyIM.codec.Spliter;
import com.szu.nettyIM.handler.IMIdleStateHandler;
import com.szu.nettyIM.server.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ---------------------------------*、****------------------------------------------
 */
@Service("server")
class Server {
    private static final int PORT = 8000;

    public void run() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new IMIdleStateHandler());
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        // 登录请求处理器
                        ch.pipeline().addLast(new RegisterRequestHandler());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new AddBuddyToServerHandler());
                        ch.pipeline().addLast(new AddBuddyAskServerHandler());
                        ch.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
                        ch.pipeline().addLast(new AuthHandler());
                        ch.pipeline().addLast(new ListBuddiesRequestHandler());
                        // 单聊消息请求处理器
                        ch.pipeline().addLast(new MessageRequestHandler());
                        // 创建群请求处理器
                        ch.pipeline().addLast(new CreateGroupRequestHandler());
                        // 加群请求处理器
                        ch.pipeline().addLast(new JoinGroupRequestHandler());
                        // 退群请求处理器
                        ch.pipeline().addLast(new QuitGroupRequestHandler());
                        // 获取群成员请求处理器
                        ch.pipeline().addLast(new ListGroupMembersRequestHandler());
                        // 登出请求处理器
                        ch.pipeline().addLast(new LogoutRequestHandler());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });

        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }
}
