package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before() {
        System.out.println("前置增强...");
    }

    public void afterReturning() {
        System.out.println("后置增强...");
    }
    //Proceeding JoinPoint 正在执行的连接点==切点
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("环绕前增强...");
        //切点方法
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后增强...");
    }
}
