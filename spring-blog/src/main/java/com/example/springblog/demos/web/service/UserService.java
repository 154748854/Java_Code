package com.example.springblog.demos.web.service;

import com.example.springblog.demos.web.mapper.BlogMapper;
import com.example.springblog.demos.web.mapper.UserInfoMapper;
import com.example.springblog.demos.web.model.BlogInfo;
import com.example.springblog.demos.web.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogMapper blogMapper;
    public UserInfo selectByName(String userName) {
        return userInfoMapper.selectByName(userName);
    }

    public UserInfo selectById(Integer userId) {
        return userInfoMapper.selectById(userId);
    }

    public UserInfo getAuthorInfo(Integer blogId) {
        // 博客id来获取博客信息
        BlogInfo blogInfo = blogMapper.selectById(blogId);
        if (blogInfo==null && blogInfo.getUserId()<=0) {
            log.error("获取博客不存在,或博客信息不合法.blogId:{}",blogId);
            return null;
        }
        // 根据博客id,获取作者信息
        return userInfoMapper.selectById(blogInfo.getId());
    }
}
