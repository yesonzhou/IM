package com.yeson.nettyIM.data;

import com.alibaba.fastjson.JSON;

/**
 * Created by y_s on 2019/1/31 下午11:08
 */

public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object obj) {
        return JSON.toJSONBytes(obj);
    }

    @Override
    public <T> T deserialize(Class<T> obj, byte[] bytes) {
        return JSON.parseObject(bytes, obj);
    }
}
