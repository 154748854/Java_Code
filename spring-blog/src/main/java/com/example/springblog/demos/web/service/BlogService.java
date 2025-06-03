package com.example.springblog.demos.web.service;

import com.example.springblog.demos.web.mapper.BlogMapper;
import com.example.springblog.demos.web.model.BlogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public List<BlogInfo> getList() {
        return blogMapper.selectAll();
    }

    public BlogInfo getBlogDetail(Integer blogId) {
        return blogMapper.selectById(blogId);
    }

    public boolean insertBook(BlogInfo blogInfo) {
        try {
            Integer result = blogMapper.insertBlog(blogInfo);
            if (result==1) {
                return true;
            }
        } catch (Exception e) {
            log.error("博客添加失败,e:",e);
        }
        return false;
    }

    public Integer update(BlogInfo blogInfo) {
        return blogMapper.updateBlog(blogInfo);
    }
}
