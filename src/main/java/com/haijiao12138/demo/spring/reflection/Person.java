package com.haijiao12138.demo.spring.reflection;

import java.lang.reflect.InvocationHandler;

/**
 * @author: 候苑博
 * @ClassName: Person
 * @description: TODO
 * @date: 2021/8/15 2:06
 *
 */
public class Person  {
    private String nameString;
    public String name;
    private int age;
    public String age1;

    public Person() {

    }

    public Person(String nameString, int age) {
        this.nameString = nameString;
        this.age = age;
    }




    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  void eat1(){
        System.out.println("吃的方法@！");
    }


    public  void eat(String name){
        System.out.println("我是吃的有参的方法！");
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameString='" + nameString + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", age1='" + age1 + '\'' +
                '}';
    }
}
