package com.example.springaop.demos.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
// 数字越大,优先级越低,切面是一个同心圆状,优先级越低距离目标方法越近.是从外往圆心执行的
@Slf4j
@Component
@Aspect
public class AspectDemo2 {

    @Before("com.example.springaop.demos.web.aspect.AspectDemo.pt()pt()")
    public void doBefore() {
        log.info("do 2 before...");
    }

    @After("com.example.springaop.demos.web.aspect.AspectDemo.pt()")
    public void doAfter() {
        log.info("do 2 after...");
    }


}
