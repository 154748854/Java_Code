package com.example.book.demos.web.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        // 1. 校验参数
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        // 验证账号密码是否正确
        // 账号密码正确
        if ("admin".equals(userName) && "123".equals(password)) {
            session.setAttribute("userName",userName);
            return true;
        }
        // userName 可能为null,如果是username.equals 就会空指针异常
        // 这是一种开发习惯,后面不管什么时候写都要这么写
        return false;
    }
}
