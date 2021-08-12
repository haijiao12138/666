package com.haijiao12138.demo.spring.util;
import java.lang.annotation.*;

/**
 * @author haijiao12138
 * @date 2021/8/12 20:57
 * @description
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutowireRedis {
}
