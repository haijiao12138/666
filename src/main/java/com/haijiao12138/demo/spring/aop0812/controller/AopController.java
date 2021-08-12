package com.haijiao12138.demo.spring.aop0812.controller;
import com.haijiao12138.demo.spring.util.AutowireRedis;
import com.haijiao12138.demo.spring.util.DataChange;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: haijiao12138
 * @ClassName: AopController
 * @description: TODO
 * @date: 2021/8/12 19:35
 *
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    List<Object> list = new ArrayList<>();
    @RequestMapping("/data")
    @AutowireRedis
    public List<Object> test(){

        list.add("张三");
        list.add("李四");
        return list;
    }

    @RequestMapping("/addData")
    @DataChange(name = "AopController.test")
    public List<Object> addData(){

        list.add("王五");
        list.add("赵六");
        return list;
    }

    @RequestMapping("/test")
    public String testAop(String key){
        return "testAop: key = " + key;
    }

    @RequestMapping("testAfterThrowing")
    public String testAfterThrowing(String key){
        throw new NullPointerException(key);
    }


    @RequestMapping("/testAround")
    public String testAround(String key){
        return "环绕通知：key = " + key;
    }



}
