package com.example.demo.demos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
@ResponseBody
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "测试Controller和其他注解的区别";
    }
}
