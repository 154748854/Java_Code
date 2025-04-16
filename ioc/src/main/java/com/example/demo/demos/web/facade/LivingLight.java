package com.example.demo.demos.web.facade;

public class LivingLight implements Light{
    @Override
    public void on() {
        System.out.println("打开客厅的灯");
    }

    @Override
    public void off() {
        System.out.println("关闭客厅的灯");
    }
}
