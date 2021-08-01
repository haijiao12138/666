package com.haijiao12138.demo.spring.aop.staticProxy;/**
 * @author 候苑博
 * @date 2021/8/1 11:24
 * @description
 */

/**
 * @author
 * @description 目标对象实现接口类
 * @date 2021/8/1
 *
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("保存数据！！");
    }
}
