package com.szu.nettyIM.protocol.serialize;

public interface SerializerAlgorithm {
    /**
     * json 序列化
     */
    byte JSON = 1;

    /**
     * protocol buffer
     */
    byte PB = 2;

}
