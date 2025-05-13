package com.example.book.demos.web.config;

import com.example.book.demos.web.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public Result handlerException(Exception e) {
        // 使用统一异常的时候,将错误信息打印出来,不然后面去找异常会很麻烦
        log.error("发生异常,e:",e);
        return Result.fail("内部错误");
    }

    @ExceptionHandler
    public Result handlerException(NullPointerException e) {
        // 使用统一异常的时候,将错误信息打印出来,不然后面去找异常会很麻烦
        log.error("发生异常,e:",e);
        return Result.fail("发生空指针异常");
    }
}
