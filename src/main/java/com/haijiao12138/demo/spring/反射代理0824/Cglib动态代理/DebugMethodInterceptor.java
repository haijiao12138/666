package com.haijiao12138.demo.spring.反射代理0824.Cglib动态代理;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: haijiao12138
 * @ClassName: MethodInterceptor
 * @description: TODO 2.自定义 MethodInterceptor（方法拦截器）
 * @date: 2021/8/24 21:50
 */
public class DebugMethodInterceptor  implements net.sf.cglib.proxy.MethodInterceptor {


    /**
     * @param o           代理对象（增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //调用方法之前 可以添加自己的操作
        System.out.println("Cglib调用方法之前："+method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        //调用方法之后  添加自己的操作
        System.out.println("Cglib方法调用之后："+method.getName());
        return object;
    }
}
