package com.example.springaop.demos.web.proxy;

public class HouseProxy implements HouseSubject{
    private HouseSubject target;

    public HouseProxy(HouseSubject target) {
        this.target = target;
    }

    @Override
    public void rent() {
        System.out.println("我是中介,开始代理");
        target.rent();
        System.out.println("我是中介,结束代理");
    }

    @Override
    public void seal() {
        System.out.println("我是中介,开始代理");
        target.seal();
        System.out.println("我是中介,结束代理");
    }
}
