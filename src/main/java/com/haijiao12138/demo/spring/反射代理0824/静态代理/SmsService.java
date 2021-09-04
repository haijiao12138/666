package com.haijiao12138.demo.spring.反射代理0824.静态代理;

/**
 * @author: haijiao12138
 * @ClassName: SmsService
 * @description: 实现步骤
 *  静态代理实现步骤:
 *
 * 1-定义一个接口及其实现类；
 * 2-创建一个代理类同样实现这个接口
 * 3-将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法。这样的话，我们就可以通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些自己想做的事情。
 * @date: 2021/8/24 19:27
 *  定义发送短信的接口
 */
public interface SmsService {
    String send(String message);//短信发送接口
}
