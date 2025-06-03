package com.example.springblog.demos.web.model;

import com.example.springblog.demos.web.utils.DateUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Boolean isLoginUser;
    private Date createTime;
    private Date updateTime;

    public String getCreateTime() {
        return DateUtils.DateFormat(createTime);
    }
}
