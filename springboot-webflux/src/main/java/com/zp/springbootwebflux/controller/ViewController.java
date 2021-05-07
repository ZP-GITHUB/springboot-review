package com.zp.springbootwebflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ZP
 * @date 2021/5/7.
 */
@Controller
public class ViewController {

    @GetMapping("flux")
    public String flux() {
        return "flux";
    }
}