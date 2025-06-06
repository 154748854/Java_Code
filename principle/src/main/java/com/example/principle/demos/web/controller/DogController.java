package com.example.principle.demos.web.controller;

import com.example.principle.demos.web.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    @Autowired
    private Dog singletonDog;

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/single")
    public String single() {
        // 从context中获取对象
        Dog contextDog = context.getBean("singletonDog", Dog.class);
        return "contextDog"+contextDog+", autowiredDog"+singletonDog;
    }

}
