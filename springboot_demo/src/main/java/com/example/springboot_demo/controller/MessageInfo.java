package com.example.springboot_demo.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@ToString
public class MessageInfo {
    @Getter @Setter
    private String from;
    @Getter @Setter
    private String to;
    @Getter @Setter
    private String message;


}
