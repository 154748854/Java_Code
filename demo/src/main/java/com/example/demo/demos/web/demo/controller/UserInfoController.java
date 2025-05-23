package com.example.demo.demos.web.demo.controller;

import com.example.demo.demos.web.demo.mapper.UserInfoMapper;
import com.example.demo.demos.web.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ListResourceBundle;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/selectAll")
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }
}
