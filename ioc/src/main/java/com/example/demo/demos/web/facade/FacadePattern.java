package com.example.demo.demos.web.facade;

public class FacadePattern {
    public void lightOn() {
        HallLight hallLight = new HallLight();
        LivingLight livingLight = new LivingLight();
        hallLight.on();
        livingLight.on();
    }
}
