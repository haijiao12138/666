package com.haijiao12138.demo.spring.反射代理0824;

/**
 * @author: haijiao12138
 * @ClassName: Student
 * @description: TODO
 * @date: 2021/8/24 17:10
 */
public class Student {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
