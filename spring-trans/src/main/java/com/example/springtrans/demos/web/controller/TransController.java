package com.example.springtrans.demos.web.controller;


import com.example.springtrans.demos.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/trans")
@RestController
public class TransController {
    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping("/register")
    public boolean register(String userName, String password) {
        Integer result = userService.insert(userName,password);
        System.out.println("输入用户表,result "+result);
        return true;
    }
}
