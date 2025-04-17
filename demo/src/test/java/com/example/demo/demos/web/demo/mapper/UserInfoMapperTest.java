package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.controller.UserInfoController;
import com.example.demo.demos.web.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @BeforeEach
    void setUp() {
        log.info("setUp");
    }

    @AfterEach
    void tearDown() {
        log.info("After");
    }

    @Test
    void selectAll() {
        List<UserInfo> list = userInfoMapper.selectAll();
        log.info(list.toString());
    }

    @Test
    void selectOne() {
        log.info(userInfoMapper.selectOne(1).toString());
    }

    @Test
    void selectOne2() {
        log.info(userInfoMapper.selectOne2(1).toString());
    }
}