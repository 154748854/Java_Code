package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoXMLMapperTest {
    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;

    @Test
    void selectAll() {
        List<UserInfo> userInfos = userInfoXMLMapper.selectAll();
        log.info(userInfos.toString());
    }

    @Test
    void insert() {
        // 因为接口是对象,所以我们哟在这列生成一个对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("java");
        userInfo.setGender(2);
        userInfo.setAge(1);
        Integer result = userInfoXMLMapper.insert(userInfo);
        log.info("影响:{},id:{}",result,userInfo.getId());
    }

    @Test
    void delete() {
        userInfoXMLMapper.delete(11);
    }
}