package com.example.springtrans.demos.web.service;

import com.example.springtrans.demos.web.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insert(String userName, String password) {
        return userInfoMapper.insert(userName,password);
    }
}
