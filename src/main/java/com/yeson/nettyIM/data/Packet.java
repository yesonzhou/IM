package com.yeson.nettyIM.data;

/**
 * Created by y_s on 2019/1/31 下午10:52
 */

public abstract class Packet {
    /**
     * 协议版本
     */
    public int version = 0;

    /**
    * 指令
    */
    public abstract Byte getCommand();

}
