package com.haijiao12138.demo.spring.反射代理0824.Jdk动态代理;

/**
 * @author: haijiao12138
 * @ClassName: SmsServiceImpl
 * @description: TODO 实现短信发送的接口
 * @date: 2021/8/24 20:16
 */
public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message!"+message);
        return message;
    }
}