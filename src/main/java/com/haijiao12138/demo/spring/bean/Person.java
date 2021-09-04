package com.haijiao12138.demo.spring.bean;

import com.sun.mail.util.BEncoderStream;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: haijiao12138
 * @ClassName: Person
 * @description: TODO
 * @date: 2021/8/16 10:55
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;
    private int phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person(){
        System.out.println("构造器 调用Person的构造器实例化！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name!");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("[注入属性]注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    //这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
    }

    //这是BeanNameAware接口方法
    @Override
    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBaneName()");

    }



    //这是IntializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    //这是DisposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");

    }

    //通过<bean>的init-method属性指定 的初始化方法
    public void myInit(){
        System.out.println("【init-method】调用<bean>的destory-method属性指定的初始化方法！");
    }
    public void myDestory(){
        System.out.println("【destory-method】调用<bean>的destory-method属性指定的初始化方法！");
    }

}
