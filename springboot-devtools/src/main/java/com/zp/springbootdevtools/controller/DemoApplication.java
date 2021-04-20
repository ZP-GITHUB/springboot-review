package com.zp.springbootdevtools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZP
 * @date 2021/4/20.
 * 参考文章：https://www.jianshu.com/p/f7cedd102551
 */
@RestController
public class DemoApplication {

    @RequestMapping("/")
    String index() {
        return "hello zp aaa spring boot";
    }

}
