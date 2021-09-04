package com.haijiao12138.demo.spring.反射代理0824.Jdk动态代理;

/**
 * @author: haijiao12138
 * @ClassName: main
 * @description: TODO  测试类
 *
 * @date: 2021/8/24 20:44
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");

    }
}
