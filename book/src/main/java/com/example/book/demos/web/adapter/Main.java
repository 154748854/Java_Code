package com.example.book.demos.web.adapter;



public class Main {
    public static void main(String[] args) {
        Sl4jLog sl4jLog = new Log4jAdapter(new Log4j());
        sl4jLog.log("我是mian方法");
    }
}
