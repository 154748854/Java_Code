package com.example.springtrans.demos.web.controller;

import com.example.springtrans.demos.web.service.LogService;
import com.example.springtrans.demos.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController2 {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @Transactional
    @RequestMapping("/register")
    public boolean register(String userName, String password) {
        /**
         * 用户表的插入和日志表的插入,理应在service完成
         */
        Integer result = userService.insert(userName,password);
        System.out.println("result: "+result);
        // 插入日志表
        Integer logResult = logService.insert(userName,"用户注册");
        System.out.println("插入日志表"+logResult);
        return true;
    }
}
