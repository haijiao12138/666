package com.haijiao12138.demo.spring.reflection1;


/**
 * @author: haijiao12138
 * @ClassName: Student
 * @description: TODO
 * @date: 2021/8/15 2:51
 *
 */
public class Student {
    private String name;
    private int age;
    private String address;

    public Student(String name,int age,String address) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
