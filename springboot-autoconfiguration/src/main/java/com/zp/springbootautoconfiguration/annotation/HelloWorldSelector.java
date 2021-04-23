package com.zp.springbootautoconfiguration.annotation;

import com.zp.springbootautoconfiguration.selector.HelloWorldImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ZP
 * @date 2021/4/23.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldImportSelector.class)
public @interface HelloWorldSelector {
}
