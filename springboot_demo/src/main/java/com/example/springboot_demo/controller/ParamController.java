package com.example.springboot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/param")
@RestController
public class ParamController {
    @RequestMapping("/m1")
    public String m1(String name) {
        return "接收到的参数:" + name;
    }

    @RequestMapping("/m2")
    public String m2(String name, Integer age) {
        return "接收到的参数:" + name + " age:" + age;
    }

    @RequestMapping("/m5")
    public String m5(@RequestParam(value = "name",required = false) String username) {
        return "接受到的参数name:"+username;
    }
}
