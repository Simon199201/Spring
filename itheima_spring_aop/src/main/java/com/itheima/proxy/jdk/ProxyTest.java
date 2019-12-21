package com.itheima.proxy.jdk;

import com.itheima.proxy.jdk.impl.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //前置增强
                advice.before();
                Object invoke = method.invoke(target, args);//执行目标方法
                advice.afterRetruning();
                //后置增强
                return invoke;
            }
        });
        proxy.save();

    }
}
