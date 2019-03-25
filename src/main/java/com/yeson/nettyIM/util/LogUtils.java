package com.yeson.nettyIM.util;

import java.util.Date;

public class LogUtils {

    private static final String DEFAULT_TAG = "IM";

    public static void p(String msg) {
        p(DEFAULT_TAG, msg);
    }

    public static void p(String tag, String msg) {
        System.out.println(new Date() + " " + tag + " " + msg);
    }
}
