package com.haijiao12138.demo.spring.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: haijiao12138
 * @ClassName: RefulectDemo1
 * @description: TODO
 * @date: 2021/8/15 2:07
 *
 */
public class RefulectDemo1 {
    /**
     *1.Class.forName("全类名")：将字节码文件加载进内存，返回class对象
     *2.类名.class:通过类名的class获取
     *3.对象.getClass(): getClass()方法在object类当中定义着
     * @throws ClassNotFoundException
     */
    public static void main1(String[] args) throws Exception {
        // 1.Class.forName("全类名")：
        Class class1 = Class.forName("com.haijiao12138.demo.spring.reflection.Person");
        System.out.println(class1);

        //2.类名.class:通过类名的class获取
        Class class2 = Person.class;
        System.out.println(class2);

        //3.对象.getClass()
        Person person = new Person();
        Class class3 = person.getClass();
        System.out.println(class3);

        System.out.println(class1 == class2);
        System.out.println(class2==class3);

    }

    public static void main2(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
             1. 获取成员变量们
                 * Field[] getFields()
                 * Field getField(String name)

                 * Field[] getDeclaredFields()
                 * Field getDeclaredField(String name)

         */
        //1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("------------");
        //2.Field getField(String name)
        Field a = personClass.getField("age1");
        System.out.println(a);
        //获取成员变量a 的值
        Person p = new Person();
        System.out.println(p);
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"张三");
        System.out.println(p);

        System.out.println("===================");

        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("age");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
    }
    public static void main3(String[] args) throws Exception {
        //0.获取Person的class对象
        Class personClass = Person.class;

        //因为构造器的方法名称是相同的，不同的是参数列表，所以我们可以根据不同的参数列表来找到构造器
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象
        Object perObject = constructor.newInstance("张三",20);
        System.out.println(perObject);

        System.out.println("-------------------------------");

        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        //创建对象,newInstance简化创建
        Object perObject1 = constructor1.newInstance();
        System.out.println(perObject1);

        System.out.println("-------------------------------");
        Object o = personClass.newInstance();
        System.out.println(o);
    }
    public static void main4(String[] args) throws Exception {
        //0.获取Person的class对象
        Class personClass = Person.class;

        //获取指定名称的方法,方法无参
        Method eat_method = personClass.getMethod("eat1");
        //执行方法
        Person person =new Person();
        eat_method.invoke(person);

        //获取指定名称的方法，方法有参
        Method eat_method1 = personClass.getMethod("eat",String.class);
        //执行方法
        eat_method1.invoke(person,"饭");



        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            //获取方法的名称
            String name = method.getName();
            System.out.println(name);
        }
    }
    /**
     *  1.Class.forName("全类名")：将字节码文件加载进内存，返回class对象
     2.类名.class:通过类名的class获取
     3.对象.getClass():getClass()方法在object类当中定义着
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws Exception {
        // 1.Class.forName("全类名")：
        Class class1 = Class.forName("com.haijiao12138.demo.spring.reflection.Person");
        System.out.println(class1);

        //2.类名.class:通过类名的class获取
        Class class2 = Person.class;
        System.out.println(class2);

        //3.对象.getClass()
        Person person = new Person();
        Class class3 = person.getClass();
        System.out.println(class3);
        System.out.println("----------------------------");
        System.out.println(class1  == class2);
        System.out.println(class1  == class3);
    }

}
