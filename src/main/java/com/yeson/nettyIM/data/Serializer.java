package com.yeson.nettyIM.data;

/**
 * Created by y_s on 2019/1/31 下午11:01
 */

public interface Serializer {
    /**
     * json 序列化
     */
    byte JSON_SERIALIZER = 1;

    Serializer DEFAULT = new JSONSerializer();


    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * java对象转化为二进制
     */
    byte[] serialize(Object obj);

    /**
     * 二进制转化为java对象
     */
    <T> T deserialize(Class<T> obj,byte[] bytes);

}
