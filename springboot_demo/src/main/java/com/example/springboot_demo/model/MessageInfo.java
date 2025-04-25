package com.example.springboot_demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@Data
public class MessageInfo {
    private Integer id;
    private String from;
    private String to;
    private String message;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;


}
