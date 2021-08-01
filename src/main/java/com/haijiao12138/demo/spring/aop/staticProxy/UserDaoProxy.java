package com.haijiao12138.demo.spring.aop.staticProxy;/**
 * @author 候苑博
 * @date 2021/8/1 11:26
 * @description
 */

/**
 * @author
 * @description：UserDapProxy需要实现IUserDao接口
 * @date 2021/8/1
 *
 */
public class UserDaoProxy implements IUserDao{

    private IUserDao target;

    public UserDaoProxy(IUserDao target){
        //构造方法
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务！");//扩展了额外的功能
        target.save();
        System.out.println("提交事务！");

    }
}
