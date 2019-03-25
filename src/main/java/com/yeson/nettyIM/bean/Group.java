package com.yeson.nettyIM.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Group extends Buddy {

    public Group(String name) {
        super(name);
    }
}
