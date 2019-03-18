package com.yeson.nettyIM.bean;

import lombok.Data;

@Data
public class Buddy {
    private String name;

    public Buddy(String name) {
        this.name = name;
    }
}
