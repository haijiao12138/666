package com.haijiao12138.demo.spring.反射代理0824.Cglib动态代理;

/**
 * @author: haijiao12138
 * @ClassName: Main
 * @description: TODO
 * @date: 2021/8/24 21:59
 */
public class Main {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
