package com.example.springaop.demos.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspectDemo {
    @Around("@annotation(com.example.springaop.demos.web.config.MyAspect)")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        log.info("do around before..");
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("发生异常,e:",e);
        }
        log.info("do around after...");
        return o;
    }
}
