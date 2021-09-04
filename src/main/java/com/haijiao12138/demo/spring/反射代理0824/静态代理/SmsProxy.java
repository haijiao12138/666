package com.haijiao12138.demo.spring.反射代理0824.静态代理;

/**
 * @author: haijiao12138
 * @ClassName: SmsProxy
 * @description: TODO  创建代理类 并同样实现发送短信的接口
 * @date: 2021/8/24 19:43
 */
public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {

        //调用方法之前 添加自己的操作
        System.out.println("调用短信发送接口之前");
        smsService.send(message);
        //掉用方法之后  添加自己的操作
        System.out.println("调用短信发送方法之后");
        return null;
    }
}
