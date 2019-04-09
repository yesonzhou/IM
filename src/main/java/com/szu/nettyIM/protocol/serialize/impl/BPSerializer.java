package com.szu.nettyIM.protocol.serialize.impl;/**
 * The demo is created by yesonzhou on 2019/4/8 20:43
 * Note: ***
 */

import com.szu.nettyIM.protocol.serialize.Serializer;
import com.szu.nettyIM.protocol.serialize.SerializerAlgorithm;

/**
 * ---------------------------------*、****------------------------------------------
 */

public class BPSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.BP;
    }

    @Override
    public byte[] serialize(Object object) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return null;
    }
}
