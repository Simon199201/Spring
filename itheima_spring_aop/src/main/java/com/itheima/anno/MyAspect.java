package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前的MyAspect是一个切面
public class MyAspect {
    @Before("execution(* com.itheima.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强...");
    }
    @AfterReturning("execution(* com.itheima.anno.*.*(..))")
    public void afterReturning() {
        System.out.println("后置增强...");
    }

    //Proceeding JoinPoint 正在执行的连接点==切点
    @Around("pointcut()")
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
    @AfterThrowing("MyAspect.pointcut()")
    public void afterThrowing() {
        System.out.println("抛出异常增强...");
    }
//    @After("execution(* com.itheima.anno.*.*(..))")
    @After("MyAspect.pointcut()")
    public void after() {
        System.out.println("最终执行...");
    }
    //定义切点表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){

    }
}
