package com.zp.springbootautoconfiguration.annotation;

import java.lang.annotation.*;

/**
 * @author ZP
 * @date 2021/4/23.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelService
public @interface SecondLevelService {
    String value() default "";
}