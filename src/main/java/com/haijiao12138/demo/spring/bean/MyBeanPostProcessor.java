package com.haijiao12138.demo.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: haijiao12138
 * @ClassName: MyBeanPostProcessor
 * @description: TODO
 * @date: 2021/8/16 12:00
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor(){
        super();
        System.out.println("这是BeanPostProcessor类构造器！");
    }

    @Override
     public Object postProcessAfterInitialization(Object arg0, String arg1)
             throws BeansException {
                System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
                return arg0;
            }

             @Override
     public Object postProcessBeforeInitialization(Object arg0, String arg1)
             throws BeansException {
                 System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
                return arg0;
            }
}
