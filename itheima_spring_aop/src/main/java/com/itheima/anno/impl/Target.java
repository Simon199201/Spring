package com.itheima.anno.impl;

import com.itheima.anno.TargetInterface;
import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    public void save() {
//        int i = 1 / 0;
        System.out.println("save running ......");
    }
}
