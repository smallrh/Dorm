package com.dorm.dorm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class modelController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginRegister() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
