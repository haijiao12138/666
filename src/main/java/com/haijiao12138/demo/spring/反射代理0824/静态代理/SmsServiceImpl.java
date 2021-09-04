package com.haijiao12138.demo.spring.反射代理0824.静态代理;

/**
 * @author: haijiao12138
 * @ClassName: SmsServiceImpl
 * @description: TODO  实现发送短信的接口
 * @date: 2021/8/24 19:39
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:"+message);
        return message;
    }
}
