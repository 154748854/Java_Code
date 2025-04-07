package com.example.demo.demos.web.v2;

public class Tire {
    private int size;
    private String color;

    public Tire(int size,String color) {
        this.size = size;
        this.color = color;
        System.out.println("tire init... size:"+size+"color:"+color);
    }

    public Tire(int size) {
        this.size = size;
        System.out.println("tire init...");
    }
}
