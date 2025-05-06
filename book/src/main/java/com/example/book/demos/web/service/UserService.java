package com.example.book.demos.web.service;

import com.example.book.demos.web.mapper.UserInfoMapper;
import com.example.book.demos.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoByName(String name) {
        return userInfoMapper.selectUserByName(name);
    }
}
