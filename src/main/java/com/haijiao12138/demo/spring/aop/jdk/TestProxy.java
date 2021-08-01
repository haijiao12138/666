package com.haijiao12138.demo.spring.aop.jdk;/**
 * @author 候苑博
 * @date 2021/8/1 11:57
 * @description
 */

import org.junit.Test;

/**
 * @author
 * @description
 * @date 2021/8/1
 *
 */
public class TestProxy {

    @Test
    public void testProxy(){
        IUserDao target = new UserDao();
        System.out.println("目标对象信息是："+target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象信息是："+proxy.getClass());
        proxy.run();

    }
}
