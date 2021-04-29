package com.zp.springbootcros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZP
 * @date 2021/4/29.
 */
@Controller
public class TestController {

    @RequestMapping("index")
    public String index () {
        return "index";
    }

    @RequestMapping("hello")
    @ResponseBody
//    @CrossOrigin(value = "*")  //加上这个注解后访问http://localhost:8080/，js会会跳到这里，表示允许所有请求支持跨域访问
    public String hello(){
        return "hello";
    }
}