package com.example.springblog.demos.web.controller;
import com.example.springblog.demos.web.model.BlogInfo;
import com.example.springblog.demos.web.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/getList")
    public List<BlogInfo> getList() {
        log.info("获取博客列表..");
        return blogService.getList();
    }

    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogDetail(Integer blogId) {
        log.info("根据博客id获取详细, blogId:{}", blogId);
        return blogService.getBlogDetail(blogId);
    }
}
