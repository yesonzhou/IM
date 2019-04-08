package com.szu.learning.protobuf;
/**
 * The demo is created by yesonzhou on 2019/3/21 19:13
 * Note: ***
 */

import java.util.UUID;

/**
 * ---------------------------------*、****------------------------------------------
 */

public class MessageBaseTest {
    public static void main(String[] args) {
        MessageBase.Message message = MessageBase.Message.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setContent("hello world").build();
        System.out.println("message: "+message.toString());
    }
}
