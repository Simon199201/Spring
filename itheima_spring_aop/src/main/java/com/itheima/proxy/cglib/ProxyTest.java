package com.itheima.proxy.cglib;

import com.itheima.proxy.jdk.Advice;
import com.itheima.proxy.jdk.TargetInterface;
import com.itheima.proxy.jdk.impl.Target;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3、设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //执行前置
                advice.before();
                //执行目标
                Object invoke = method.invoke(target, args);
                //执行后置
                advice.afterRetruning();
                return invoke;
            }
        });

        //4、生成代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();

    }
}
