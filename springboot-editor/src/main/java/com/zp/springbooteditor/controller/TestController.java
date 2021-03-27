package com.zp.springbooteditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZP
 * @date 2020/9/5.
 */
@Controller
public class TestController {

    @RequestMapping("/t1")
    public String test1(){
        //classpath:/templates/test.html
        return "test";
    }

}