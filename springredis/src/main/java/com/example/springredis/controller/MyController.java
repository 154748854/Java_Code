package com.example.springredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/testString")
    @ResponseBody
    public String testString() {
        redisTemplate.opsForValue().set("key","111");
        redisTemplate.opsForValue().set("key2","222");
        redisTemplate.opsForValue().set("key3","333");

        String value = redisTemplate.opsForValue().get("key");
        System.out.println(value);

        return "OK";
    }

    @GetMapping("/testList")
    @ResponseBody
    public String testList() {
        redisTemplate.execute((RedisConnection connection) -> {
            // execute 要求回调方法中必须写return语句, 返回个东西
            // 返回的东西就作为execute的返回值
            connection.flushAll();
            return null;
        });

        return "OK";
    }
}
