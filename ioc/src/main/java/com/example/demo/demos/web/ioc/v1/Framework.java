package com.example.demo.demos.web.ioc.v1;

public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        bottom = new Bottom(size);
        System.out.println("framework init...");
    }
}
