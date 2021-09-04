package com.haijiao12138.demo.spring.反射代理0824.Cglib动态代理;

import com.haijiao12138.demo.spring.反射代理0824.Jdk动态代理.DebugInvocationHandler;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author: haijiao12138
 * @ClassName: CglibProxyFactory
 * @description: TODO  3.获取代理类
 * @date: 2021/8/24 21:54
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz){
        //创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        //创建代理类
        return enhancer.create();
    }
}
