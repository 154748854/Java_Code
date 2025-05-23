package com.example.springblog.demos.web.mapper;

import com.example.springblog.demos.web.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogMapperTest {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    void selectAll() {
        System.out.println(blogMapper.selectAll());
    }

    @Test
    void selectById() {
        System.out.println(blogMapper.selectById(1));
    }

    @Test
    void updateBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("testtesttest");
        blogInfo.setContent("测试测试测试");
        blogInfo.setUserId(2);
        blogInfo.setId(3);
        blogInfo.setDeleteFlag(1);
        blogMapper.insertBlog(blogInfo);

    }

    @Test
    void insertBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("testtesttest");
        blogInfo.setContent("测试测试测试");
        blogInfo.setUserId(1);
        blogMapper.insertBlog(blogInfo);
    }
}