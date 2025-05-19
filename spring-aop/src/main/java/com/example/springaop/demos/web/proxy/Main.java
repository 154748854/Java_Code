package com.example.springaop.demos.web.proxy;

import org.springframework.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        // 使用cglib 完成代理
        // 目标对象(类和接口都可以
        HouseSubject target = new RealHouseSubject();
        /**
         * 第一个参数是什么类型, 第二个参数是要做的什么增强(要做的流程是什么吗
         */
        HouseSubject houseSubject = (HouseSubject) Enhancer.create(target.getClass(), new CGLibMethodInterceptor(target));
        houseSubject.rent();
    }
}
