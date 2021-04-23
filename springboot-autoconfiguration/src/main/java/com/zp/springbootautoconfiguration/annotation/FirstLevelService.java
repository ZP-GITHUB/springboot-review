package com.zp.springbootautoconfiguration.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author ZP
 * @date 2021/4/23.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface FirstLevelService {
    String value() default "";
}