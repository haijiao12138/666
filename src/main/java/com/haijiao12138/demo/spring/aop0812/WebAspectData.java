package com.haijiao12138.demo.spring.aop0812;/**
 * @author 候苑博
 * @date 2021/8/12 19:32
 * @description
 */

import com.haijiao12138.demo.spring.util.DataChange;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: 候苑博
 * @ClassName: WebAspect
 * @description: TODO
 * @date: 2021/8/12 19:32
 *
 */
@Aspect
@Component
public class WebAspectData {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * @author haijiao12138
     * @Date 2021/8/01 17:29
     * @Description:redis实现分布式锁
     */
    public String lock(){
        String lock = "001";
        String clientId = UUID.randomUUID().toString();
        //加锁
        Boolean result = stringRedisTemplate.
                opsForValue().
                setIfAbsent(lock, clientId, 100, TimeUnit.SECONDS);//根据业务设置过期时间100s
        if (!result){
            //如果没有set成功，代表获取锁失败 直接返回友好提示
            return "请稍等！！！";
        }
        //中间执行业务代码
        //释放锁
        String s = stringRedisTemplate.opsForValue().get(lock);
        if (s.equals(clientId)){
            //通过当前的uuid的不同 判断是不是刚才那个线程用到了锁 如梭符合 就释放锁
            stringRedisTemplate.delete(lock);//释放锁

        }
        return "业务代码情况";
    }

    /**
     * 切入点
     *切入点,基于注解实现的切入点  加上该注解的都是Aop切面的切入点
     *
     */
    @Pointcut("@annotation(com.haijiao12138.demo.spring.util.DataChange)")
    public void pointCut(){

    }
    /**
     * 环绕通知
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     * @param proceedingJoinPoint
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("----------- 环绕通知 -----------");
        System.out.println("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());

        Signature signature1 = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature1;
        Method targetMethod = methodSignature.getMethod();//方法对象
        DataChange annotation = targetMethod.getAnnotation(DataChange.class);//反射得到自定义注解的方法对象

        String name = annotation.name();//获取自定义注解的方法对象的参数即name
        Set<String> keys = stringRedisTemplate.keys("*" + name + "*");//模糊定义key
        Long delete = stringRedisTemplate.delete(keys);//模糊删除redis的key值
        //执行加入双删注解的改动数据库的业务 即controller中的方法业务
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //开一个线程 延迟1秒（此处是1秒举例，可以改成自己的业务）
        // 在线程中延迟删除  同时将业务代码的结果返回 这样不影响业务代码的执行
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
                   Set<String> keys = stringRedisTemplate.keys("*" + name + "*");//模糊删除
                   Long delete = stringRedisTemplate.delete(keys);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();
        return proceed;//返回业务代码的值

    }

}
