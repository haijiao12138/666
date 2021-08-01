package com.haijiao12138.demo.spring.aop.jdk;/**
 * @author 候苑博
 * @date 2021/8/1 11:50
 * @description
 */

/**
 * @author
 * @description:目标对象
 * @date 2021/8/1
 *
 */
public class UserDao implements IUserDao{
    @Override
    public void run() {
        System.out.println("保存数据！！！");
    }
}
