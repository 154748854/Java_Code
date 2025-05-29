package com.example.springblog.demos.web.service;

import com.example.springblog.demos.web.mapper.UserInfoMapper;
import com.example.springblog.demos.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo selectByName(String userName) {
        return userInfoMapper.selectByName(userName);
    }

    public UserInfo selectById(Integer userId) {
        return userInfoMapper.selectById(userId);
    }
}
