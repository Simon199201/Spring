package com.itheima.aop.impl;

import com.itheima.aop.TargetInterface;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running ......");
    }
}
