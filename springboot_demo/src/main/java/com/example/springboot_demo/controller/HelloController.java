package com.example.springboot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/hello")
@RestController
public class HelloController {
    @RequestMapping("/sayhi")
    public String sayHi() {
        return "hello, SpringBoot";
    }
}
