package com.zp.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author ZP
 * @date 2020/8/30.
 * 要使用Swagger，我们需要编写一个配置类-SwaggerConfig来配置 Swagger
 */
@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
public class SwaggerConfig {
    /**
     * Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger。
     * @return
     */
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//Docket 实例关联上 apiInfo()
                .groupName("hello") // 配置分组
                .enable(true) //配置是否启用Swagger，如果是false，在这个bean里的设置浏览器将无法访问
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.zp.springbootswagger.controller"))
                // 配置如何通过path过滤,即这里只扫描请求以/kuang开头的接口
                .paths(PathSelectors.ant("/zp/**"))
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
        return new ApiInfo(
                "Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

    /**
     * 设置多分组
     * @return
     */
//    @Bean
//    public Docket docket1(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
//    }
//    @Bean
//    public Docket docket2(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
//    }
//    @Bean
//    public Docket docket3(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
//    }
}