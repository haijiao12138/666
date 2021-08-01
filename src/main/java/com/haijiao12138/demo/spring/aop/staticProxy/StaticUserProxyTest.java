package com.haijiao12138.demo.spring.aop.staticProxy;/**
 * @author 候苑博
 * @date 2021/8/1 11:31
 * @description
 */

import org.junit.Test;

/**
 * @author
 * @description:测试类TestProxy
 * @date 2021/8/1
 *
 */
public class StaticUserProxyTest {



    @Test
    public void testStaticProxy(){
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
