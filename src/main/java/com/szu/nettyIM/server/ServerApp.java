package com.szu.nettyIM.server;/**
 * The demo is created by yesonzhou on 2019/4/9 21:30
 * Note: ***
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.szu.nettyIM.server.db.es.utils.ElasticsearchUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

//        JSONObject json = new JSONObject();
//        json.put("password","123456");
//        for (int i : new int[]{1,2,3,4,5})
//        ElasticsearchUtils.addData(json,"user","register","test" + i);




    }

}

