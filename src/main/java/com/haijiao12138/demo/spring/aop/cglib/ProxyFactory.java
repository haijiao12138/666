package com.haijiao12138.demo.spring.aop.cglib;/**
 * @author 候苑博
 * @date 2021/8/1 12:05
 * @description
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author
 * @description
 * @date 2021/8/1
 *
 */
public class ProxyFactory implements MethodInterceptor {

    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
    //为目标对象生成代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());//设置父类
        en.setCallback(this);//设置回调函数
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务！！！");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("关闭事务！！");
        return null;
    }
}
