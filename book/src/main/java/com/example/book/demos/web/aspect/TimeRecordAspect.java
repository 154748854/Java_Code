package com.example.book.demos.web.aspect;

import com.fasterxml.jackson.databind.ObjectReader;
import javafx.beans.binding.ObjectExpression;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

@Slf4j
@Component
@Aspect
public class TimeRecordAspect {
    /**
     * 记录耗时
     */
    @Around("execution(* com.example.book.demos.web.controller.*.*(..))")
    public Object timeRecord(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 执行目标方法
        Object proceed = joinPoint.proceed();
        // 记录结束时间
        long end = System.currentTimeMillis();
        // 打印耗时时间
        log.info("耗时时间: "+(end - start)+"ms");
        return proceed;
    }
}
