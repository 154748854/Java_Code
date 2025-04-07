package com.example.demo.demos.web.ioc.v1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(19);
        car.run();

        Car car2 = new Car(17);
        car.run();
    }
}
