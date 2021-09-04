package com.haijiao12138.demo.spring.reflection;


/**
 * @author: 候苑博
 * @ClassName: Test0815
 * @description: TODO
 * @date: 2021/8/15 2:02
 *
 */
public class Test0815 {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName(String.valueOf(Test0815.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
