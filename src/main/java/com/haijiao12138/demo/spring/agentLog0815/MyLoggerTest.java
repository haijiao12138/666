package com.haijiao12138.demo.spring.agentLog0815;

import java.lang.reflect.Proxy;

/**
 * @author: haijiao12138
 * @ClassName: MyLoggerTest
 * @description: TODO 日志测试类
 * @date: 2021/8/15 14:43
 */
public class MyLoggerTest {
    public static void main(String[] args) {
        /** 实例化真实项目中业务类 **/
        BusinessClassService businessClassService = new BusinessClassServiceImpl();
        /** 日志类的handler **/
        MyLoggerHandler myLoggerHandler = new MyLoggerHandler(businessClassService);
        /** 获得代理类对象 **/
        BusinessClassService businessClass = (BusinessClassService) Proxy.newProxyInstance(businessClassService.getClass().getClassLoader(), businessClassService.getClass().getInterfaces(),myLoggerHandler);
        /** 执行代理类方法 **/
        businessClass.doSomeThing();

    }

}
