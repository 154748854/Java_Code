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

    void selectAll2() {
        List<UserInfo> list = userInfoMapper.selectAll2();
        log.info(list.toString());
    }

    void selectAll3() {
        List<UserInfo> list = userInfoMapper.selectAll3();
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

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(6);
        userInfo.setGender(0);
        userInfo.setPhone("1234566789");

        Integer result = userInfoMapper.insert(userInfo);
        log.info("insert 结果"+result+"自增id"+userInfo.getId());
    }

    @Test
    void delete() {
        userInfoMapper.delete(10);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(8);
        userInfo.setId(11);
        Integer result = userInfoMapper.update(userInfo);
        // 开发中常用影响的行数来显示修改是否成功
        if (result > 0) {
            log.info("数据修改成功");
        }
    }

    @Test
    void selectUserBySort() {
        log.info(userInfoMapper.selectUserBySort("desc").toString());
    }

    @Test
    void selectUserByLike() {
        log.info(userInfoMapper.selectUserByLike("java").toString());
    }
}