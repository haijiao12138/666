package com.haijiao12138.demo.spring.aop0813;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 海角12138
 * @ClassName: AopController
 * @description: TODO
 * @date: 2021/8/13 0:07
 *
 */
@RestController
@RequestMapping("/aop1")
public class AopController1 {

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
