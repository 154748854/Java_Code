package com.example.book.adapter;

public class Log4jAdapter implements Sl4jLog {
    private Log4j log4j;

    public Log4jAdapter(Log4j log4j) {
        this.log4j = log4j;
    }

    @Override
    public void log(String message) {
        log4j.log4jPrint("我是适配器,打印日志:"+message);
    }
}
