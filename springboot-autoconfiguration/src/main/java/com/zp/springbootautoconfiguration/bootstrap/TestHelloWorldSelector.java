package com.zp.springbootautoconfiguration.bootstrap;

import com.zp.springbootautoconfiguration.annotation.EnableHelloWorld;
import com.zp.springbootautoconfiguration.annotation.HelloWorldSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ZP
 * @date 2021/4/23.
 * 以通过接口编程实现@Enable模块驱动的本质是：通过@Import来导入接口ImportSelector实现类，
 * 该实现类里可以定义需要注册到IOC容器中的组件，以此实现相应模块对应组件的注册。
 */
@HelloWorldSelector
public class TestHelloWorldSelector {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestHelloWorldSelector.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String hello = context.getBean("hello", String.class);
        System.out.println("hello Bean: " + hello);
        context.close();
    }
}