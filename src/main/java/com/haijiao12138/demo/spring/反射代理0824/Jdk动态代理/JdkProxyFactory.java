package com.haijiao12138.demo.spring.反射代理0824.Jdk动态代理;

import java.lang.reflect.Proxy;

/**
 * @author: haijiao12138
 * @ClassName: JdkProxyFactory
 * @description: TODO  获取代理对象的工厂类
 * @date: 2021/8/24 20:40
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(   //此方法获取某个类的代理对象
                target.getClass().getClassLoader(),//目标类的加载
                target.getClass().getInterfaces(),//代理需要实现的接口  可指定多个
                new DebugInvocationHandler(target)//代理对象对应的自定义 InvocationHandler
        );
    }
}
