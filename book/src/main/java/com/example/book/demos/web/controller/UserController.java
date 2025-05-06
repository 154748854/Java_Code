package com.example.book.demos.web.controller;

import com.example.book.demos.web.mapper.UserInfoMapper;
import com.example.book.demos.web.model.UserInfo;
import com.example.book.demos.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        // 1. 校验参数
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        //1. 根据用户名去查询用户信息
        UserInfo userInfo = userService.getUserInfoByName(userName);

        // 再去比对该用户的密码是否正确
        if (userInfo==null || userInfo.getId()<=0) {
            return false;
        }

        if (password.equals(userInfo.getPassword())) {
            // 账号密码正确
            // 存session
            userInfo.setPassword("");
            session.setAttribute("username",userInfo);
            return true;
        }

        return false;
    }
}
