package com.haijiao12138.demo.spring.agentLog0815;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: haijiao12138
 * @ClassName: MyLoggerHandler
 * @description: TODO  日志类MyLoggerHandler 实现
 * @date: 2021/8/15 14:40
 */
public class MyLoggerHandler implements InvocationHandler {
    /** 原始对象 **/
    private Object objOriginal;

    /** 这里很关键 **/
    private MyLogger myLogger = new MyLoggerImpl();  //接口 = 类


    public MyLoggerHandler(Object obj){
        super();
        this.objOriginal = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        /** 日志类的方法 **/
        myLogger.saveIntoMethodTime(method);
        /** 调用代理类方法 **/
        result = method.invoke(this.objOriginal ,args);
        /** 日志类方法**/
        myLogger.saveOutMethodTime(method);

        return result;
    }

}
