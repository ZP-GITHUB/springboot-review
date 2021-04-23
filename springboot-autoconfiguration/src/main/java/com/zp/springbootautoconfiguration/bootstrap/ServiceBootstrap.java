package com.zp.springbootautoconfiguration.bootstrap;

import com.zp.springbootautoconfiguration.service.TestService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ZP
 * @date 2021/4/23.
 * 用于测试注册TestService并从IOC容器中获取它
 */
@ComponentScan("com.zp.springbootautoconfiguration.service")
public class ServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        TestService testService = context.getBean("testService", TestService.class);
        System.out.println("TestService Bean: " + testService);
        context.close();
    }
}