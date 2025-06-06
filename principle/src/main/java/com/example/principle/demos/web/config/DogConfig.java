package com.example.principle.demos.web.config;


import com.example.principle.demos.web.model.Dog;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class DogConfig {
    @Bean
    public Dog dog() {
        // 使用@Bean让spring来管理这个对象,其他地方就能拿到这个对象了
        Dog dog = new Dog();
        dog.setName("小黄");
        return dog;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Dog singletonDog() {
        return new Dog();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Dog prototypeDog() {
        return new Dog();
    }

    @Bean
    @RequestScope
    public Dog requestDog() {
        return new Dog();
    }
}
