package com.example.springblog.demos.web.controller;
import com.example.springblog.demos.web.constant.Constants;
import com.example.springblog.demos.web.model.BlogInfo;
import com.example.springblog.demos.web.model.UserInfo;
import com.example.springblog.demos.web.model.UserInfoDO;
import com.example.springblog.demos.web.service.BlogService;
import com.example.springblog.demos.web.utils.JwtUtils;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import javax.servlet.http.HttpServletRequest;
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
    public BlogInfo getBlogDetail(Integer blogId, HttpServletRequest request) {
        log.info("根据博客id获取详细, blogId:{}", blogId);
        BlogInfo blogDetail = blogService.getBlogDetail(blogId);
        // 获取token
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        // 从token中获取登录用户ID
        Integer userId = JwtUtils.getIdByToken(token);
        // 判断作者是否为登录用户
        if (userId!=null && userId==blogDetail.getUserId()) {
            blogDetail.setIsLoginUser(true);
        }
        return blogDetail;
    }

    @RequestMapping("/add")
    public Boolean addBook(@RequestBody BlogInfo blogInfo, HttpServletRequest request) {
        log.info("添加博客,blogInfo:{}",blogInfo);
        // 参数校验
        if (!StringUtils.hasLength(blogInfo.getTitle()) || StringUtils.hasLength(blogInfo.getContent())) {
            return false;
        }
        // 获取登录用户
        // 获取token
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);

        // 从token中获取登录用户ID
        Integer userId = JwtUtils.getIdByToken(token);
        if (userId==null || userId<= 0) {
            return false;
        }
        blogInfo.setUserId(userId);
        return blogService.insertBook(blogInfo);
    }

    @RequestMapping("/update")
    public Boolean update(BlogInfo blogInfo) {
        log.info("更新博客,blogInfo:{}",blogInfo);
        // 参数校验
        if (blogInfo.getId()==null
                || !StringUtils.hasLength(blogInfo.getTitle())
                || !StringUtils.hasLength(blogInfo.getContent())) {
            return false;
        }
        blogService.update(blogInfo);
        return true;
    }

    @RequestMapping("/delete")
    public Boolean delete(Integer blogId) {
        log.info("删除博客.blogID:{}", blogId);
        if (blogId<=0) {
            return false;
        }
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(1);
        blogService.update(blogInfo);
        return true;
    }
}
