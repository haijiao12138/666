package com.haijiao12138.demo.spring.aop0812;

import com.haijiao12138.demo.spring.util.AutowireRedis;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: haijiao12138
 * @ClassName: WebAspect
 * @description: TODO
 * @date: 2021/8/12 19:32
 */
@Aspect
@Component
public class WebAspect {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 切入点,基于注解实现的切入点  加上该注解的都是Aop切面的切入点
     *
     */
    @Pointcut("@annotation(com.haijiao12138.demo.spring.util.AutowireRedis)")
    public void pointCut() {
    }


    /**
     * 环绕通知
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     *
     * @param proceedingJoinPoint
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("----------- 环绕通知 -----------");
        Signature signature = proceedingJoinPoint.getSignature();

        System.out.println("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());

        String key1 = new StringBuilder().append(signature).toString();
        String key = key1.replace(" ", ".");
        String s = stringRedisTemplate.opsForValue().get(key);
        if (s == null) {//如果在redis中没取到值 将方法的路径作为key  将切面运行结果作为value存入redis中 供下一次查询使用
            try {
                Object proceed = proceedingJoinPoint.proceed();
                stringRedisTemplate.opsForValue().set(key, String.valueOf(proceed));
                return proceed;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        //如果第一次在redis中能取到值  s就不为空  直接将s返回
        return Arrays.asList(s.replace("[", "").replace("]", "").split(","));

    }

}
