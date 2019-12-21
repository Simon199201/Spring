package com.itheima.proxy.jdk.impl;

import com.itheima.proxy.jdk.TargetInterface;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running ......");
    }
}
