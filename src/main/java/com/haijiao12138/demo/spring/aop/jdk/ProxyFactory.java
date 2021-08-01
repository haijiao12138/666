package com.haijiao12138.demo.spring.aop.jdk;/**
 * @author 候苑博
 * @date 2021/8/1 11:51
 * @description
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author
 * @description：动态代理对象
 * @date 2021/8/1
 *
 */
public class ProxyFactory  {

    public Object target;//维护一个目标对象
    public ProxyFactory(Object target){
        this.target = target;
    }
    //为目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务！！！");

                //执行目标方法
                Object invoke = method.invoke(target, args);
                System.out.println("提交事务！！");
                return null;
            }
        });
    }
}
