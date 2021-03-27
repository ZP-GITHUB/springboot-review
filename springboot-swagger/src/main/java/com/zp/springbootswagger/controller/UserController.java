package com.zp.springbootswagger.controller;

import com.zp.springbootswagger.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZP
 * @date 2020/8/30.
 */
@Controller
public class UserController {

    @RequestMapping("/zp/getUser")
    public User getUser(){
        return new User();
    }

    @ApiOperation("鹏帅帅的接口")
    @PostMapping("/zp")
    @ResponseBody
    public String zp(@ApiParam("这个名字会被返回")String username){
        return username;
    }
}
