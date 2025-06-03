package com.example.springblog.demos.web.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDO {
    private Integer id;
    private String userName;
    private String githubUrl;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
