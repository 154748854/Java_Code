package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("2023-2");
        userInfo.setGender(1);
        userInfo.setAge(1);
        List<UserInfo> userInfos = userInfo2Mapper.selectByCondition(userInfo);
        log.info(userInfos.toString());
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("2023-3");
        userInfo.setGender(1);
        userInfo.setAge(1);
        List<UserInfo> userInfos = userInfo2Mapper.updateByCondition(userInfo);
    }

    @Test
    void batchDelete() {
        userInfo2Mapper.batchDelete(Arrays.asList(5,26,27));
    }
}