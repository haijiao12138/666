package com.haijiao12138.demo.spring.agentLog0815;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author: haijiao12138
 * @ClassName: MyLoggerImpl
 * @description: TODO  日志实现类
 * @date: 2021/8/15 14:40
 */
public class MyLoggerImpl  implements MyLogger{
    @Override
    public void saveIntoMethodTime(Method method) {
        System.out.println("进入" + method.getName()  +"方法时间为: " + new Date());
    }

    @Override
    public void saveOutMethodTime(Method method) {
        System.out.println("退出" + method.getName() + "方法时间为：" + new Date());
    }
}
