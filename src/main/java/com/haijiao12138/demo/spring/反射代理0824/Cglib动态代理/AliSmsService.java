package com.haijiao12138.demo.spring.反射代理0824.Cglib动态代理;

/**
 * @author: haijiao12138
 * @ClassName: AliSmsService
 * @description: TODO 1.实现一个使用阿里云发送短信的类
 * @date: 2021/8/24 21:45
 */
public class AliSmsService {
    public String send(String message){
        System.out.println("send message:"+message);
        return message;
    }
}
