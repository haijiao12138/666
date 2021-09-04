package com.haijiao12138.demo.spring.反射代理0824.Jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: haijiao12138
 * @ClassName: DebugInvocationHandler
 * @description: TODO
 * @date: 2021/8/24 20:18
 */
public class DebugInvocationHandler implements InvocationHandler {
     private final Object target;

    public DebugInvocationHandler(java.lang.Object target) {
        this.target = target;
    }

    @Override     //  动态生成的代理类   与代理对象调用的方法相呼应   当前method方法的参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法前 增加自己的操作
        System.out.println("动态代理方法执行前："+method.getName());
        Object result = method.invoke(target, args);//invoke方法代替我们去调用了被代理的原生方法
        //调用方法结束  添加自己的操作
        System.out.println("动态代理方法执行后："+method.getName());
        return result;
    }
}
