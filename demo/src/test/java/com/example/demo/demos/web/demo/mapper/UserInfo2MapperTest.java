package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfo2MapperTest {
    @Autowired
    private UserInfo2Mapper userInfo2Mapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("123");
        userInfo.setPassword("123");
        userInfo.setAge(1);
        userInfo.setGender(1);
        userInfo.setPhone("1234123412");
        userInfo2Mapper.insert(userInfo);
    }

    @Test
    void insertByXML() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("123");
        userInfo.setPassword("123");
        userInfo.setAge(1);
//        userInfo.setGender(1);
        userInfo.setPhone("1234123412");
        userInfo2Mapper.insertByXML(userInfo);
    }
}