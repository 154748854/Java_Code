package com.example.springaop.demos.web.proxy;

public class RealHouseSubject implements HouseSubject{
    @Override
    public void rent() {
        System.out.println("我是房东,我要租房子了");
    }

    @Override
    public void seal() {
        System.out.println("我是房东,我要卖房子了");
    }
}
