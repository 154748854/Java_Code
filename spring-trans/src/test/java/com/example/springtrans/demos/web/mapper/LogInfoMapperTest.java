package com.example.springtrans.demos.web.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LogInfoMapperTest {
    @Autowired
    private LogInfoMapper logInfoMapper;

    @Test
    void insertLog() {
        logInfoMapper.insertLog("zhangsan","用户注册");
    }
}