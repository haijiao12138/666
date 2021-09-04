package com.haijiao12138.demo.spring.反射代理0824;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: haijiao12138
 * @ClassName: DebugInvocationHandler
 * @description: TODO 通过 JDK 实现动态代理的示例代码，其中就使用了反射类 Method 来调用指定的方法。
 * @date: 2021/8/24 17:06
 */
public class DebugInvocationHandler implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class alunbarClass1 = Class.forName("com.mysql.jdbc.Driver");
        Class alunbarClass = Student.class;


        Object o1 = alunbarClass1.newInstance();
        System.out.println(o1);

        Student o = new Student();
        Class alunbarClass2 = o.getClass();


    }
}
