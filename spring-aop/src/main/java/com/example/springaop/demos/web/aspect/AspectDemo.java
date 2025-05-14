package com.example.springaop.demos.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class AspectDemo {

    @Pointcut("execution(* com.example.springaop.demos.web.controller.*.*(..))")
    public void pt(){};

    @Before("pt()")
    public void doBefore() {
        log.info("do before...");
    }

    @After("pt()")
    public void doAfter() {
        log.info("do after...");
    }

    @Around("pt()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("do around before...");
        Object result = joinPoint.proceed();
        log.info("do around after...");
        return result;
    }
}
