package com.example.demo.demos.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
public class LoggerController {
//    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);


    // 在程序运行的时候会先执行postConstruct的代码
    @PostConstruct
    public void print() {
        System.out.println("打印日志");
        log.info("======我是日志框架=====");
        log.error("===我是error日志===");
        log.warn("我是warn日志");
        log.debug("我是debug日志");
        log.trace("我是trace日志");
    }
}
