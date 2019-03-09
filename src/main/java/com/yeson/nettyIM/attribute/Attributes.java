package com.yeson.nettyIM.attribute;

import com.yeson.nettyIM.session.Session;
import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
