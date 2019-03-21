package com.szu.nettyIM.attribute;

import com.szu.nettyIM.session.Session;
import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
