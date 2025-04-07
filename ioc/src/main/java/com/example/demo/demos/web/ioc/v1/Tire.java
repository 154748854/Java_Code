package com.example.demo.demos.web.ioc.v1;

public class Tire {
    private int size;

    public Tire(int size) {
        // 你要把传过来的参数给设置给成员属性
        this.size = size;
        System.out.println("tire init...size:"+size);
    }
}
