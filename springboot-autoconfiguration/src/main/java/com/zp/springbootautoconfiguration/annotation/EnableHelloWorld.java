package com.zp.springbootautoconfiguration.annotation;

import com.zp.springbootautoconfiguration.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ZP
 * @date 2021/4/23.
 * @Import导入配置类
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}