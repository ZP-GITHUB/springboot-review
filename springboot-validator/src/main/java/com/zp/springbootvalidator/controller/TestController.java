package com.zp.springbootvalidator.controller;

import com.zp.springbootvalidator.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author ZP
 * @date 2021/4/25.
 */
@RestController
@Validated
public class TestController {

    /**http://localhost:8080/test1?email=12345&name*/
    @GetMapping("test1")
    public String test1(
            @NotBlank(message = "{required}") String name,
            @Email(message = "{invalid}") String email) {
        return "success";
    }

    /**http://localhost:8080/test2?email=12345&name*/
    @GetMapping("test2")
    public String test2(@Valid User user) {
        return "success";
    }
}