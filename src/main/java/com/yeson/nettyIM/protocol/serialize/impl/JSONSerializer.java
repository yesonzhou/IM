package com.yeson.nettyIM.protocol.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.yeson.nettyIM.protocol.serialize.Serializer;
import com.yeson.nettyIM.protocol.serialize.SerializerAlgorithm;


public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
