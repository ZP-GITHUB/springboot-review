package com.zp.springbootfilterinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZP
 * @date 2021/4/22.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping("/getException/{id:\\d+}")
    public void getException(@PathVariable String id) {
        System.out.println(id);
        throw new RuntimeException("user not exist");
    }
}