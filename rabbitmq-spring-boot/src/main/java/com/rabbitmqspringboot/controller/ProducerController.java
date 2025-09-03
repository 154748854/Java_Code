package com.rabbitmqspringboot.controller;

import com.rabbitmqspringboot.constant.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/fanout")
    public String fanout() {
        rabbitTemplate.convertAndSend(Constants.FANOUT_EXCHANGE,"","hello Spring amqp: fanout...");
        return "发送成功";
    }

    @RequestMapping("/direct/{routingKey}")
    public String direct(@PathVariable("routingKey") String routingKey) {
        rabbitTemplate.convertAndSend(Constants.DIRECT_EXCHANGE, routingKey, "hello spring amqp:direct, my routingKey is " +
                routingKey);
        return "发送成功";
    }

}
