package com.example.principle.demos.web.component;

import com.example.principle.demos.web.model.Dog;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLOutput;

@Component
public class BeanLifeComponent implements BeanNameAware {
    private Dog singletonDog;
    public BeanLifeComponent() {
        System.out.println("执行构造函数...");
    }

    @Autowired
    public void setSingletonDog(Dog singletonDog) {
        this.singletonDog = singletonDog;
        System.out.println("执行singletonDog...");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName: "+s);
    }
    @PostConstruct
    public void init() {
        System.out.println("执行postConstruct方法...");
    }
    public void use() {
        System.out.println("执行use方法..");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("执行destroy..");
    }
}
