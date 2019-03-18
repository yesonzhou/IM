package com.yeson.nettyIM.bean;

import lombok.Data;

@Data
public class User extends Buddy {
    public User(String name) {
        super(name);
    }
}
