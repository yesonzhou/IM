package com.yeson.nettyIM.data;

/**
 * Created by y_s on 2019/1/31 下午10:57
 */

public class LoginRequestPacket extends Packet {
    public Integer userid;
    public String userName;
    public String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
