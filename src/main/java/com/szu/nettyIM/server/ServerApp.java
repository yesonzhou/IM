package com.szu.nettyIM.server;/**
 * The demo is created by yesonzhou on 2019/4/9 21:30
 * Note: ***
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import com.szu.nettyIM.server.handler.AddBuddyAskServerHandler;
import com.szu.nettyIM.server.handler.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * ---------------------------------*、****------------------------------------------
 */

@SpringBootApplication
public class ServerApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        ApplicationContext context = SpringApplication.run(ServerApp.class, args);
        Server nettyServer = context.getBean(Server.class);
        nettyServer.run();


    }

}

