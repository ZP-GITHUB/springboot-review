package com.zp.springbootexception.controller;

import com.zp.springbootexception.exception.UserNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZP
 * @date 2021/4/21.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/500/{id:\\d+}")
    public void get500(@PathVariable String id) {
        throw new RuntimeException("user not exist");
    }

    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        throw new UserNotExistException(id);
    }
}