package com.szu.nettyIM.client;/**
 * The demo is created by yesonzhou on 2019/4/9 21:37
 * Note: ***
 */
import com.szu.nettyIM.server.ServerApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * ---------------------------------*、****------------------------------------------
 */

@SpringBootApplication
public class ClientApp {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ServerApp.class, args);
        Client nettyClient = context.getBean(Client.class);
        nettyClient.run();
    }
}
