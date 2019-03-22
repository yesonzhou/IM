package com.szu.nettyIM.protocol.command;

import com.sun.beans.editors.ByteEditor;

public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

    Byte LOGOUT_REQUEST = 5;

    Byte LOGOUT_RESPONSE = 6;

    Byte CREATE_GROUP_REQUEST = 7;

    Byte CREATE_GROUP_RESPONSE = 8;

    Byte LIST_GROUP_MEMBERS_REQUEST = 9;

    Byte LIST_GROUP_MEMBERS_RESPONSE = 10;

    Byte JOIN_GROUP_REQUEST = 11;

    Byte JOIN_GROUP_RESPONSE = 12;

    Byte QUIT_GROUP_REQUEST = 13;

    Byte QUIT_GROUP_RESPONSE = 14;

    Byte ADD_BUDDY_REQUEST = 15;

    Byte ADD_BUDDY_RESPONSE = 16;

    Byte ADD_BUDDY_ASK_REQUEST = 17;

    Byte ADD_BUDDY_ASK_RESPONSE = 18;

    Byte MODIFY_ACCOUNT_REQUEST = 19;

    Byte MODIFY_ACCOUNT_RESPONSE = 20;

    Byte HEARTBEAT_REQUEST = 21;

    Byte LIST_BUDDIES_REQUEST = 22;

    Byte LIST_BUDDIES_RESPONSE = 23;

    Byte REGISTER_REQUEST = 24;

    Byte REGISTER_RESPONSE = 25;

    Byte HEARTBEAT_RESPONSE = 26;


}
