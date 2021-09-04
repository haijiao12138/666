package com.haijiao12138.demo.spring.反射代理0824.静态代理;

/**
 * @author: haijiao12138
 * @ClassName: Main
 * @description: TODO
 * @date: 2021/8/24 19:49
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
