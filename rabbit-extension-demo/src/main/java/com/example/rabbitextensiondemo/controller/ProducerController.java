package com.example.rabbitextensiondemo.controller;

import com.example.rabbitextensiondemo.constant.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/producer")
@RestController
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/ack")
    public String ack() {
        rabbitTemplate.convertAndSend(Constants.ACK_EXCHANGE, "ack", "ack ack mode test...");
        return "消息发送成功";
    }
}
