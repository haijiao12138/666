package com.haijiao12138.demo.spring.agentLog0815;

import java.lang.reflect.Method;

/**
 * @author: haijiao12138
 * @ClassName: MyLogger
 * @description:日志类接口
 * @date: 2021/8/15 14:38
 */
public interface MyLogger {

    //记录进入方法时间
    public void saveIntoMethodTime(Method method);

    //记录退出方法的时间
    public void saveOutMethodTime(Method method);
}
