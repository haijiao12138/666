package com.haijiao12138.demo.spring.aop.cglib;/**
 * @author 候苑博
 * @date 2021/8/1 12:10
 * @description
 */

import com.haijiao12138.demo.spring.aop.jdk.IUserDao;
import org.junit.Test;

/**
 * @author
 * @description
 * @date 2021/8/1
 *
 */
public class TestProxy {

    @Test
    public void testCglibProxy(){
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.run();


    }
}
