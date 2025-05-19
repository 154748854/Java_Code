package com.example.springtrans.demos.web.controller;

import com.example.springtrans.demos.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public boolean register(String userName, String password) {
        Integer result = userService.insert(userName,password);
        if (result >= 0) {
            return true;
        }
        return false;
    }
}
