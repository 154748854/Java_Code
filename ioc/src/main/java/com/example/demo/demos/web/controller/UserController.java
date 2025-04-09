package com.example.demo.demos.web.controller;

import com.example.demo.demos.web.User;
import com.example.demo.demos.web.config.UserInfo;
import com.example.demo.demos.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    // 这样写就是controller依赖userService

    // Autowired 属性注入
//    @Autowired
//    private UserService userService;

    // 构造方法注入
    @Autowired
    private UserService us;


    // @Qualifier("userInfo2")
    // @Autowired

    // 使用@Resource指定Bean
    @Resource(name = "userInfo2")
    private UserInfo userInfo;
//
//    public UserController(UserService userService, UserInfo userInfo) {
//        this.userService = userService;
//        this.userInfo = userInfo;
//    }
//
//    @Autowired
//    public UserController(UserService us) {
//        this.userService = us;
//    }

    @Autowired
    public void setUs(UserService us) {
        this.us = us;
    }

    public void doController() {
        us.doService();
        System.out.println("do Controller");
        System.out.println(userInfo);
    }

}
