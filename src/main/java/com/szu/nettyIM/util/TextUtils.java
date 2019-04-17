package com.szu.nettyIM.util;

/**
 * Created by Richard.Fu on 2019/4/15
 */
public class TextUtils {

    public static boolean isEmpty(byte[] bytes){
        return bytes == null || bytes.length <= 0;
    }

    public static boolean isEmpty(String text) {
        return text == null || text.length() <= 0;
    }
}
