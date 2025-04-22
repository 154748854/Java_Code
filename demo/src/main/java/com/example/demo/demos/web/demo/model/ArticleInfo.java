package com.example.demo.demos.web.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleInfo {
    // 文章相关信息
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteFlag;
    private Date cteateTime;
    private Date updateTime;

    // 为了进行多表查询时也能使用此类接受
    // 用户相关信息
    private String username;
    private Integer age;
}
