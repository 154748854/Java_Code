package com.example.springblog.demos.web.config;

import com.example.springblog.demos.web.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public Result handle(Exception e) {
        log.error("发生异常,e", e);
        return Result.fail("内部错误,请联系管理员");
    }

}
