package com.szu.nettyIM.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Buddy {
    private String name;
    private Class clazz = this.getClass();

    public Buddy(String name) {
        this.name = name;
    }
}
