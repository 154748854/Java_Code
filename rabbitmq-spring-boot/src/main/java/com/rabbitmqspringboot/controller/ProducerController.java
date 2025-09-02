package com.rabbitmqspringboot.controller;

import com.rabbitmqspringboot.constant.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/producer")
@RestController
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/work")
    public String work() {
        // 使用内置交换机,
        rabbitTemplate.convertAndSend("", Constants.WORK_QUEUE, "hello spring amqp: work...");
        return "发送成功";
    }
}
