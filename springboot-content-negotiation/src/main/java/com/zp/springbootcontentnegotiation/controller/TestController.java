package com.zp.springbootcontentnegotiation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @author ZP
 * @date 2021/4/26.
 */
//@RestController
@Controller
public class TestController {

    @GetMapping(value = "test", consumes = "text/properties")
    public Properties test(@RequestBody Properties properties) {
        return properties;
    }

    @GetMapping(value = "test1", consumes = "text/properties")
//    @ResponseBody
    public Properties test1(Properties properties) {
        return properties;
    }
}