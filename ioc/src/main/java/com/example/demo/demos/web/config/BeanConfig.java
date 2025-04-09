package com.example.demo.demos.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public String name() {
        return "zhangsan";
    }

    @Bean
    public UserInfo userInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("zhangsan");
        userInfo.setAge(12);
        return userInfo;
    }
//    @Bean
//    public UserInfo userInfo2() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setId(2);
//        userInfo.setName("lisi");
//        userInfo.setAge(13);
//        return userInfo;
//    }
}
