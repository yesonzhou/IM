package com.yeson.nettyIM.bean;

import lombok.Data;

@Data
public class Group extends Buddy {

    public Group(String name) {
        super(name);
    }
}
