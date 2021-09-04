package com.haijiao12138.demo.spring.reflection1;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: haijiao12138
 * @ClassName: CommonReflect
 * @description: TODO
 * @date: 2021/8/15 2:52
 *
 */
public class CommonReflect {
    //获取该类的名称
    public static void getClassName(Object object) {
        //Class studentClass = Student.class;
        //String name = studentClass.getName().;
        String className = object.getClass().getSimpleName();
        System.out.println("类的名字是："+className);
    }

    //获取类的变量名称   不考虑修饰符
    public static void getField(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("成员变量的名称为："+fields[i].getName());
        }
    }

    //获取类的成员方法  所有private的方法
    public static void getMethod(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("成员方法的名称："+methods[i].getName());
        }
    }

    //调用该类的成员方法，以get为例
    public static void getAction(Object object) throws Exception {
        //获取到有多少get方法
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            String fistfont = fieldName.substring(0,1).toUpperCase();
            String methodname = "get"+fistfont+fieldName.substring(1); //get+N+name=getName; getAge  getAddress
            Method method = object.getClass().getMethod(methodname);

            System.out.println("get的输出结果："+method.invoke(object));

        }

    }


    public static void main(String[] args) throws Exception {
        Object studentObject = Student.class.getConstructor(String.class,int.class,String.class).newInstance("张三",20,"保定");
        getClassName(studentObject);//类名
        getField(studentObject);//成员变量名
        getMethod(studentObject);//成员方法名
        getAction(studentObject);//成员变量的输出结果

    }
}
