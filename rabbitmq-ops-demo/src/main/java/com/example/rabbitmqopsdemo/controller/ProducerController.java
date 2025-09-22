package com.example.rabbitmqopsdemo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/quorum")
    public String quorum() {
        rabbitTemplate.convertAndSend("", "quorum.queue", "quorum test...");
        return "消息发送成功";
    }

    @RequestMapping("/haproxy")
    public String haproxy() {
        rabbitTemplate.convertAndSend("", "cluster.queue", "haproxy test...");
        return "消息发送成功";
    }
}
