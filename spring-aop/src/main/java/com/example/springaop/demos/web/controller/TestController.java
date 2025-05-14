package com.example.springaop.demos.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
    @RequestMapping("t1")
    public String t1() {
        return "t1";
    }
}
