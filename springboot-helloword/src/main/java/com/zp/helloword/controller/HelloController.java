package com.zp.helloword.controller;

import com.zp.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZP
 * @date 2020/8/23.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello word";
    }

    /**
     * 这里测试自动装配
     */
    @Autowired
    HelloService helloService;

    @RequestMapping("/confighello")
    public String confighello(){
        return helloService.sayHello("zp");
    }
}
