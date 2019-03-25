package com.yeson.nettyIM.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User extends Buddy {
    public User(String name) {
        super(name);
    }
}
